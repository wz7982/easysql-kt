package org.easysql.visitor.output

import org.easysql.ast.SqlNode
import org.easysql.ast.expr.*
import org.easysql.ast.limit.SqlLimit
import org.easysql.ast.order.SqlOrderBy
import org.easysql.ast.statement.SqlStatement
import org.easysql.ast.statement.delete.SqlDelete
import org.easysql.ast.statement.insert.SqlInsert
import org.easysql.ast.statement.select.*
import org.easysql.ast.statement.truncate.SqlTruncate
import org.easysql.ast.statement.update.SqlUpdate
import org.easysql.ast.statement.upsert.SqlUpsert
import org.easysql.ast.table.SqlIdentTable
import org.easysql.ast.table.SqlJoinTable
import org.easysql.ast.table.SqlSubQueryTable
import org.easysql.ast.table.SqlTable
import org.easysql.visitor.visitExpr
import java.sql.SQLException
import java.util.*

abstract class OutPutVisitor {
    val sqlBuilder: StringBuilder = StringBuilder()

    open val quote = "\""

    protected var spaceNum = 0

    fun sql(): String = sqlBuilder.toString()

    fun visitSqlStatement(stmt: SqlStatement) {
        when (stmt) {
            is SqlSelectQuery -> visitSqlSelectQuery(stmt)
            is SqlUpdate -> visitSqlUpdate(stmt)
            is SqlInsert -> visitSqlInsert(stmt)
            is SqlDelete -> visitSqlDelete(stmt)
            is SqlTruncate -> visitSqlTruncate(stmt)
            is SqlUpsert -> visitSqlUpsert(stmt)
        }
    }

    fun visitSqlSelectQuery(query: SqlSelectQuery) {
        when (query) {
            is SqlSelect -> visitSqlSelect(query)
            is SqlUnionSelect -> {
                if (query.left !is SqlUnionSelect) {
                    sqlBuilder.append("(")
                }
                visitSqlSelectQuery(query.left)
                if (query.left !is SqlUnionSelect) {
                    sqlBuilder.append(")")
                }

                sqlBuilder.append("\n")
                printSpace(spaceNum)
                sqlBuilder.append(query.unionType.unionType)
                sqlBuilder.append("\n")
                printSpace(spaceNum)

                if (query.right !is SqlUnionSelect) {
                    sqlBuilder.append("(")
                }
                visitSqlSelectQuery(query.right)
                if (query.right !is SqlUnionSelect) {
                    sqlBuilder.append(")")
                }
            }
            is SqlValuesSelect -> visitSqlValuesSelect(query)
            is SqlWithSelect -> visitSqlWithSelect(query)
        }
    }

    open fun visitSqlSelect(select: SqlSelect) {
        sqlBuilder.append("SELECT ")

        if (select.selectList.isEmpty()) {
            throw SQLException("SELECT列表为空")
        }

        if (select.distinct) {
            sqlBuilder.append("DISTINCT ")
        }

        printList(select.selectList, ::visitSqlSelectItem)

        select.from?.let {
            sqlBuilder.append("\n")
            printSpace(spaceNum)
            sqlBuilder.append("FROM ")
            visitSqlTableSource(it)
        }

        select.where?.let {
            sqlBuilder.append("\n")
            printSpace(spaceNum)
            sqlBuilder.append("WHERE ")
            visitSqlExpr(it)
        }

        if (select.groupBy.isNotEmpty()) {
            sqlBuilder.append("\n")
            printSpace(spaceNum)
            sqlBuilder.append("GROUP BY ")
            printList(select.groupBy, ::visitSqlExpr)
        }

        select.having?.let {
            sqlBuilder.append("\n")
            printSpace(spaceNum)
            sqlBuilder.append("HAVING ")
            visitSqlExpr(it)
        }

        if (select.orderBy.isNotEmpty()) {
            sqlBuilder.append("\n")
            printSpace(spaceNum)
            sqlBuilder.append("ORDER BY ")
            printList(select.orderBy, ::visitSqlOrderBy)
        }

        select.limit?.let {
            sqlBuilder.append("\n")
            printSpace(spaceNum)
            visitSqlLimit(it)
        }

        if (select.forUpdate) {
            sqlBuilder.append(" ")
            visitSqlForUpdate()
        }
    }

    open fun visitSqlLimit(sqlLimit: SqlLimit) {
        sqlBuilder.append("LIMIT ${sqlLimit.limit} OFFSET ${sqlLimit.offset}")
    }

    fun visitSqlOrderBy(sqlOrderBy: SqlOrderBy) {
        visitSqlExpr(sqlOrderBy.expr)
        sqlBuilder.append(" ${sqlOrderBy.order.ord}")
    }

    open fun visitSqlForUpdate() {
        sqlBuilder.append("FOR UPDATE")
    }

    fun visitSqlBinaryExpr(sqlExpr: SqlBinaryExpr) {
        fun needParentheses(parent: SqlBinaryExpr, child: SqlExpr): Boolean {
            if (parent.operator == SqlBinaryOperator.AND) {
                if (child is SqlBinaryExpr) {
                    if (child.operator == SqlBinaryOperator.OR || child.operator == SqlBinaryOperator.XOR) {
                        return true
                    }
                }
            }

            if (parent.operator == SqlBinaryOperator.XOR) {
                if (child is SqlBinaryExpr) {
                    if (child.operator == SqlBinaryOperator.OR) {
                        return true
                    }
                }
            }

            if (parent.operator == SqlBinaryOperator.MUL || parent.operator == SqlBinaryOperator.DIV || parent.operator == SqlBinaryOperator.MOD) {
                if (child is SqlBinaryExpr) {
                    if (child.operator == SqlBinaryOperator.ADD || child.operator == SqlBinaryOperator.SUB) {
                        return true
                    }
                }
            }
            return false
        }

        val visitLeft = needParentheses(sqlExpr, sqlExpr.left)
        if (visitLeft) {
            sqlBuilder.append("(")
            visitSqlExpr(sqlExpr.left)
            sqlBuilder.append(")")
        } else {
            visitSqlExpr(sqlExpr.left)
        }

        if (sqlExpr.right is SqlNullExpr) {
            when (sqlExpr.operator) {
                SqlBinaryOperator.EQ -> sqlBuilder.append(" IS ")
                SqlBinaryOperator.NE -> sqlBuilder.append(" IS NOT ")
                else -> sqlBuilder.append(" ${sqlExpr.operator.operator} ")
            }
        } else {
            sqlBuilder.append(" ${sqlExpr.operator.operator} ")
        }

        val visitRight = needParentheses(sqlExpr, sqlExpr.right)
        if (visitRight) {
            sqlBuilder.append("(")
            visitSqlExpr(sqlExpr.right)
            sqlBuilder.append(")")
        } else {
            visitSqlExpr(sqlExpr.right)
        }
    }

    fun visitSqlExpr(expr: SqlExpr) {
        when (expr) {
            is SqlBinaryExpr -> visitSqlBinaryExpr(expr)

            is SqlCharExpr -> sqlBuilder.append(expr.toString())

            is SqlNumberExpr -> sqlBuilder.append(expr.number.toString())

            is SqlBooleanExpr -> sqlBuilder.append(expr.boolean.toString())

            is SqlDateExpr -> sqlBuilder.append(expr.toString())

            is SqlIdentExpr -> sqlBuilder.append("$quote${expr.name}$quote")

            is SqlPropertyExpr -> sqlBuilder.append("$quote${expr.owner}$quote.$quote${expr.name}$quote")

            is SqlNullExpr -> sqlBuilder.append("NULL")

            is SqlAllColumnExpr -> {
                expr.owner?.let {
                    sqlBuilder.append("$quote$it$quote.")
                }
                sqlBuilder.append("*")
            }

            is SqlListExpr -> {
                sqlBuilder.append("(")
                printList(expr.items, ::visitSqlExpr)
                sqlBuilder.append(")")
            }

            is SqlInExpr -> {
                visitSqlExpr(expr.expr)
                if (expr.isNot) {
                    sqlBuilder.append(" NOT")
                }
                sqlBuilder.append(" IN ")
                visitSqlExpr(expr.inExpr)
            }

            is SqlBetweenExpr -> {
                visitSqlExpr(expr.expr)
                if (expr.isNot) {
                    sqlBuilder.append(" NOT")
                }
                sqlBuilder.append(" BETWEEN ")
                visitSqlExpr(expr.start)
                sqlBuilder.append(" AND ")
                visitSqlExpr(expr.end)
            }

            is SqlCastExpr -> {
                sqlBuilder.append("CAST(")
                visitSqlExpr(expr.expr)
                sqlBuilder.append(" AS ${expr.castType}")
            }

            is SqlExprFunctionExpr -> {
                sqlBuilder.append(expr.name)
                sqlBuilder.append("(")
                printList(expr.args, ::visitSqlExpr)
                sqlBuilder.append(")")
            }

            is SqlSelectQueryExpr -> {
                sqlBuilder.append("(")
                spaceNum += 4
                sqlBuilder.append("\n")
                printSpace(spaceNum)
                visitSqlSelectQuery(expr.query)
                spaceNum -= 4
                sqlBuilder.append("\n")
                printSpace(spaceNum)
                sqlBuilder.append(")")
            }

            is SqlAggFunctionExpr -> visitSqlAggFunctionExpr(expr)

            is SqlOverExpr -> {
                visitSqlAggFunctionExpr(expr.agg)
                sqlBuilder.append(" OVER (")
                if (expr.partitionBy.isNotEmpty()) {
                    sqlBuilder.append("PARTITION BY ")
                    printList(expr.partitionBy, ::visitSqlExpr)
                }

                if (expr.orderBy.isNotEmpty()) {
                    if (expr.partitionBy.isNotEmpty()) {
                        sqlBuilder.append(" ")
                    }
                    sqlBuilder.append("ORDER BY ")
                    printList(expr.orderBy, ::visitSqlOrderBy)
                }
                sqlBuilder.append(")")
            }

            is SqlCaseExpr -> {
                sqlBuilder.append("CASE")
                expr.dataList.forEach {
                    sqlBuilder.append(" WHEN ")
                    visitSqlExpr(it.expr)
                    sqlBuilder.append(" THEN ")
                    visitSqlExpr(it.thenExpr)
                }

                sqlBuilder.append(" ELSE ")
                visitSqlExpr(expr.default)
                sqlBuilder.append(" END")
            }

            is SqlSubQueryPredicateExpr -> {
                sqlBuilder.append(expr.predicate.predicate)
                sqlBuilder.append(" ")
                visitSqlExpr(expr.select)
            }
        }
    }

    fun visitSqlAggFunctionExpr(sqlAggFunctionExpr: SqlAggFunctionExpr) {
        sqlBuilder.append(sqlAggFunctionExpr.name)
        sqlBuilder.append("(")
        if (sqlAggFunctionExpr.distinct) {
            sqlBuilder.append("DISTINCT ")
        }
        if (sqlAggFunctionExpr.name.uppercase(Locale.getDefault()) == "COUNT" && sqlAggFunctionExpr.args.isEmpty()) {
            sqlBuilder.append("*")
        }
        printList(sqlAggFunctionExpr.args, ::visitSqlExpr)
        if (sqlAggFunctionExpr.orderBy.isNotEmpty()) {
            sqlBuilder.append(" ORDER BY ")
            printList(sqlAggFunctionExpr.orderBy, ::visitSqlOrderBy)
        }
        sqlAggFunctionExpr.attributes.forEach { it ->
            sqlBuilder.append(" ${it.key} ")
            visitSqlExpr(it.value)
        }
        sqlBuilder.append(")")
    }

    fun visitSqlTableSource(table: SqlTable) {
        when (table) {
            is SqlIdentTable -> sqlBuilder.append("$quote${table.tableName}$quote")

            is SqlSubQueryTable -> {
                if (table.isLateral) {
                    sqlBuilder.append("LATERAL ")
                }

                sqlBuilder.append("(")
                spaceNum += 4
                sqlBuilder.append("\n")
                printSpace(spaceNum)
                visitSqlSelectQuery(table.select)
                spaceNum -= 4
                sqlBuilder.append("\n")
                printSpace(spaceNum)
                sqlBuilder.append(")")
            }

            is SqlJoinTable -> {
                visitSqlTableSource(table.left)
                spaceNum += 4
                sqlBuilder.append("\n")
                printSpace(spaceNum)
                sqlBuilder.append("${table.joinType.joinType} ")
                if (table.right is SqlJoinTable) {
                    sqlBuilder.append("(")
                }
                visitSqlTableSource(table.right)
                if (table.right is SqlJoinTable) {
                    sqlBuilder.append(")")
                }

                table.on?.let { it ->
                    sqlBuilder.append(" ON ")
                    visitSqlExpr(it)
                }
                spaceNum -= 4
            }
        }

        table.alias?.let { it ->
            sqlBuilder.append(" $quote$it$quote")
            if (table.columnAliasNames.isNotEmpty()) {
                sqlBuilder.append("(")
                printList(table.columnAliasNames.map { alias -> SqlIdentExpr(alias) }) { column ->
                    visitSqlExpr(column)
                }
                sqlBuilder.append(")")
            }
        }
    }

    fun visitSqlSelectItem(sqlSelectItem: SqlSelectItem) {
        visitSqlExpr(sqlSelectItem.expr)
        sqlSelectItem.alias?.let { sqlBuilder.append(" AS $quote$it$quote") }
    }


    open fun visitSqlValuesSelect(sqlValuesSelect: SqlValuesSelect) {
        sqlBuilder.append("VALUES ")
        printList(sqlValuesSelect.values.map { it ->
            SqlListExpr(it)
        }, ::visitSqlExpr)
    }

    open fun printWithRecursive() {
        sqlBuilder.append("RECURSIVE ")
    }

    fun visitSqlWithSelect(sqlWithSelect: SqlWithSelect) {
        sqlBuilder.append("WITH ")
        if (sqlWithSelect.recursive) {
            printWithRecursive()
        }

        fun visitSqlWithItem(sqlWithItem: SqlWithItem) {
            spaceNum += 4
            sqlBuilder.append("\n")
            printSpace(spaceNum)
            visitSqlExpr(sqlWithItem.name)
            if (sqlWithItem.columns.isNotEmpty()) {
                sqlBuilder.append("(")
                printList(sqlWithItem.columns, ::visitSqlExpr)
                sqlBuilder.append(")")
            }
            sqlBuilder.append(" AS ")
            sqlBuilder.append("(")
            spaceNum += 4
            sqlBuilder.append("\n")
            printSpace(spaceNum)
            visitSqlSelectQuery(sqlWithItem.query)
            spaceNum -= 4
            sqlBuilder.append("\n")
            printSpace(spaceNum)
            spaceNum -= 4
        }

        printList(sqlWithSelect.withList, ::visitSqlWithItem)
        sqlBuilder.append("\n")
        sqlWithSelect.query?.let {
            visitSqlSelectQuery(it)
        }
    }

    fun visitSqlDelete(sqlDelete: SqlDelete) {
        sqlBuilder.append("DELETE FROM ")
        visitSqlTableSource(sqlDelete.table!!)

        sqlDelete.where?.let { it ->
            sqlBuilder.append(" WHERE ")
            visitSqlExpr(it)
        }
    }

    fun visitSqlUpdate(sqlUpdate: SqlUpdate) {
        sqlBuilder.append("UPDATE ")
        visitSqlTableSource(sqlUpdate.table!!)
        sqlBuilder.append(" SET ")

        for (i in sqlUpdate.setList.indices) {
            visitSqlExpr(sqlUpdate.setList[i].first)
            sqlBuilder.append(" = ")
            visitSqlExpr(sqlUpdate.setList[i].second)

            if (i < sqlUpdate.setList.size - 1) {
                sqlBuilder.append(", ")
            }
        }

        sqlUpdate.where?.let { it ->
            sqlBuilder.append(" WHERE ")
            visitSqlExpr(it)
        }
    }

    fun visitSqlInsert(sqlInsert: SqlInsert) {
        sqlBuilder.append("INSERT INTO ")
        visitSqlTableSource(sqlInsert.table!!)
        if (sqlInsert.columns.isNotEmpty()) {
            sqlBuilder.append(" (")
            printList(sqlInsert.columns, ::visitSqlExpr)
            sqlBuilder.append(")")
        }

        if (sqlInsert.query != null) {
            sqlBuilder.append("\n")
            visitSqlSelectQuery(sqlInsert.query!!)
        } else {
            sqlBuilder.append(" VALUES ")
            printList(sqlInsert.values.map { SqlListExpr(it) }, ::visitSqlExpr)
        }
    }

    open fun visitSqlUpsert(sqlUpsert: SqlUpsert) {}

    fun visitSqlTruncate(sqlTruncate: SqlTruncate) {
        sqlBuilder.append("TRUNCATE ")
        visitSqlTableSource(sqlTruncate.table!!)
    }

    fun printSpace(num: Int) {
        if (num > 0) {
            for (i in 1..num) {
                sqlBuilder.append(" ")
            }
        }
    }

    inline fun <T : SqlNode> printList(list: List<T>, handler: (T) -> Unit) {
        for (i in list.indices) {
            handler(list[i])
            if (i < list.size - 1) {
                sqlBuilder.append(", ")
            }
        }
    }
}