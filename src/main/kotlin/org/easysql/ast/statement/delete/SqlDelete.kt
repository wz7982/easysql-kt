package org.easysql.ast.statement.delete

import org.easysql.ast.expr.SqlBinaryExpr
import org.easysql.ast.expr.SqlBinaryOperator
import org.easysql.ast.expr.SqlExpr
import org.easysql.ast.statement.SqlStatement
import org.easysql.ast.table.SqlIdentTable

data class SqlDelete(var table: SqlIdentTable? = null, var where: SqlExpr? = null) : SqlStatement {
    fun addCondition(condition: SqlExpr) {
        where = if (where == null) {
            condition
        } else {
            SqlBinaryExpr(where!!, SqlBinaryOperator.AND, condition)
        }
    }
}