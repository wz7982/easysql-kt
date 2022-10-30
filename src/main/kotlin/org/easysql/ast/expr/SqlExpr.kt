package org.easysql.ast.expr

import org.easysql.ast.SqlNode
import org.easysql.ast.order.SqlOrderBy
import org.easysql.ast.statement.select.SqlSelectQuery
import java.text.SimpleDateFormat
import java.util.*

sealed class SqlExpr : SqlNode

data class SqlBinaryExpr(val left: SqlExpr, val operator: SqlBinaryOperator, val right: SqlExpr) : SqlExpr()

data class SqlIdentExpr(val name: String) : SqlExpr()

data class SqlPropertyExpr(val owner: String, val name: String) : SqlExpr()

object SqlNullExpr : SqlExpr() {
    override fun toString() = "NULL"
}

data class SqlAllColumnExpr(val owner: String? = null) : SqlExpr()

data class SqlNumberExpr(val number: Number) : SqlExpr() {
    override fun toString(): String = number.toString()
}

data class SqlDateExpr(val date: Date) : SqlExpr() {
    override fun toString(): String {
        val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        return "'${format.format(date)}'"
    }
}

data class SqlCharExpr(val text: String) : SqlExpr() {
    override fun toString() = "'${text.replace("'", "''")}'"
}

data class SqlBooleanExpr(val boolean: Boolean) : SqlExpr() {
    override fun toString(): String = boolean.toString()
}

data class SqlListExpr(val items: List<SqlExpr> = listOf()) : SqlExpr()

data class SqlAggFunctionExpr(
    val name: String,
    val args: List<SqlExpr> = listOf(),
    val distinct: Boolean = false,
    val attributes: Map<String, SqlExpr> = mapOf(),
    val orderBy: List<SqlOrderBy> = listOf()
) : SqlExpr()

data class SqlExprFunctionExpr(val name: String, var args: List<SqlExpr> = listOf()) : SqlExpr()

data class SqlCastExpr(val expr: SqlExpr, val castType: String) : SqlExpr()

data class SqlSelectQueryExpr(val query: SqlSelectQuery) : SqlExpr()

data class SqlInExpr(val expr: SqlExpr, val inExpr: SqlExpr, val isNot: Boolean = false) : SqlExpr()

data class SqlBetweenExpr(
    val expr: SqlExpr,
    val start: SqlExpr,
    val end: SqlExpr, val isNot: Boolean = false
) : SqlExpr()

data class SqlOverExpr(
    val agg: SqlAggFunctionExpr,
    val partitionBy: List<SqlExpr> = listOf(),
    val orderBy: List<SqlOrderBy> = listOf()
) : SqlExpr()

data class SqlCaseExpr(val dataList: List<SqlCase> = listOf(), val default: SqlExpr) : SqlExpr()

data class SqlSubQueryPredicateExpr(val select: SqlSelectQueryExpr, val predicate: SqlSubQueryPredicate) : SqlExpr()