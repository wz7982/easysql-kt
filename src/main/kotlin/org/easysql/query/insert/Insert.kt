package org.easysql.query.insert

import org.easysql.ast.expr.SqlIdentExpr
import org.easysql.ast.statement.insert.SqlInsert
import org.easysql.ast.table.SqlIdentTable
import org.easysql.database.TableEntity
import org.easysql.dsl.PrimaryKeyColumnExpr
import org.easysql.dsl.TableColumnExpr
import org.easysql.query.BaseQuery
import org.easysql.visitor.toSqlExpr

class Insert : BaseQuery<SqlInsert> {
    private val ast = SqlInsert()

    override fun getAst(): SqlInsert = ast

    fun insert(vararg entities: TableEntity): Insert {
        val table = entities[0].table_

        val clazz = table::class.java
        val cols = clazz.declaredFields.map {
            it?.isAccessible = true
            it.name to it.get(table)
        }.filter {
            when (val value = it.second) {
                is TableColumnExpr<*> -> true
                is PrimaryKeyColumnExpr<*> -> !value.incr
                else -> false
            }
        }.map {
            val columnName = when (val e = it.second) {
                is TableColumnExpr<*> -> e.column
                is PrimaryKeyColumnExpr<*> -> e.column
                else -> ""
            }
            it.first to SqlIdentExpr(columnName)
        }
        ast.table = SqlIdentTable(table.tableName)
        ast.columns.addAll(cols.map { it.second })

        val entityClazz =  entities[0]::class.java
        val entityFields =  entityClazz.declaredFields

        entities.forEach { entity ->
            val value = cols.flatMap {
                entityFields.map { f->
                    f?.isAccessible = true
                    if (f.name == it.first) {
                        return@map toSqlExpr(f.get(entity))
                    } else {
                        null
                    }
                }
            }.filterNotNull()
            ast.values.add(value)
        }
        return this
    }
}