package org.easysql.query.update

import org.easysql.ast.expr.SqlBinaryExpr
import org.easysql.ast.expr.SqlBinaryOperator
import org.easysql.ast.expr.SqlIdentExpr
import org.easysql.ast.statement.update.SqlUpdate
import org.easysql.ast.table.SqlIdentTable
import org.easysql.database.TableEntity
import org.easysql.dsl.PrimaryKey
import org.easysql.dsl.Column
import org.easysql.query.ReviseQuery
import org.easysql.visitor.toSqlExpr
import java.sql.SQLException

class Update : ReviseQuery<SqlUpdate> {
    private val ast = SqlUpdate()

    override fun getAst(): SqlUpdate = ast

    fun update(entity: TableEntity, skipNulls: Boolean = true): Update {
        val table = entity.table_

        val clazz = table::class.java

        val cols = clazz.declaredFields.map {
            it?.isAccessible = true
            it.name to it.get(table)
        }.filter {
            when (val value = it.second) {
                is Column<*> -> true
                is PrimaryKey<*> -> true
                else -> false
            }
        }.map {
            it.first to it.second
        }

        val entityClazz = entity::class.java
        val entityFields = entityClazz.declaredFields

        val whereCols = cols.filter { it.second is PrimaryKey<*> }
        if (whereCols.isEmpty()) {
            throw SQLException("表没有设置主键字段")
        }
        whereCols.forEach {
            entityFields.forEach { f ->
                f?.isAccessible = true
                if (f.name == it.first) {
                    val fieldValue = f.get(entity)
                    ast.addCondition(SqlBinaryExpr(SqlIdentExpr((it.second as PrimaryKey<*>).column), SqlBinaryOperator.EQ, toSqlExpr(fieldValue)))
                }
            }
        }

        ast.table = SqlIdentTable(table.tableName_)

        val setCols = cols.filter { it.second is Column<*> }
        var setNum = 0
        setCols.forEach {
            entityFields.forEach { f ->
                f?.isAccessible = true
                if (f.name == it.first) {
                    val fieldValue = f.get(entity)
                    if (!skipNulls) {
                        setNum++
                        ast.setList.add(SqlIdentExpr((it.second as Column<*>).column) to toSqlExpr(fieldValue))
                    } else {
                        if (fieldValue != null) {
                            setNum++
                            ast.setList.add(SqlIdentExpr((it.second as Column<*>).column) to toSqlExpr(fieldValue))
                        }
                    }
                }
            }
        }

        if (setNum == 0) {
            throw SQLException("没有需要更新的字段")
        }

        return this
    }
}