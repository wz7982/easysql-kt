package org.easysql.ast.statement.update

import org.easysql.ast.expr.SqlBinaryExpr
import org.easysql.ast.expr.SqlBinaryOperator
import org.easysql.ast.expr.SqlExpr
import org.easysql.ast.statement.SqlStatement
import org.easysql.ast.table.SqlIdentTable

data class SqlUpdate(var table: SqlIdentTable? = null,
                     val setList: MutableList<Pair<SqlExpr, SqlExpr>> = mutableListOf(),
                     var where: SqlExpr? = null) : SqlStatement {
    fun addCondition(condition: SqlExpr) {
        where = if (where == null) {
            condition
        } else {
            SqlBinaryExpr(where!!, SqlBinaryOperator.AND, condition)
        }
    }
}