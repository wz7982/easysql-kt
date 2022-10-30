package org.easysql.ast.statement.select

import org.easysql.ast.expr.*
import org.easysql.ast.limit.SqlLimit
import org.easysql.ast.order.SqlOrderBy
import org.easysql.ast.statement.SqlStatement
import org.easysql.ast.table.SqlTable

sealed class SqlSelectQuery : SqlStatement

data class SqlSelect(
    var distinct: Boolean = false,
    val selectList: MutableList<SqlSelectItem> = mutableListOf(),
    var from: SqlTable? = null,
    var where: SqlExpr? = null,
    val groupBy: MutableList<SqlExpr> = mutableListOf(),
    val orderBy: MutableList<SqlOrderBy> = mutableListOf(),
    var forUpdate: Boolean = false,
    var limit: SqlLimit? = null,
    var having: SqlExpr? = null
) : SqlSelectQuery() {
    fun addSelectItem(expr: SqlExpr, alias: String? = null) {
        selectList += SqlSelectItem(expr, alias)
    }

    fun addCondition(condition: SqlExpr) {
        where = if (where == null) {
            condition
        } else {
            SqlBinaryExpr(where!!, SqlBinaryOperator.AND, condition)
        }
    }

    fun addHaving(condition: SqlExpr) {
        having = if (having == null) {
            condition
        } else {
            SqlBinaryExpr(having!!, SqlBinaryOperator.AND, condition)
        }
    }
}

data class SqlUnionSelect(
    val left: SqlSelectQuery,
    val unionType: SqlUnionType,
    val right: SqlSelectQuery
) : SqlSelectQuery()

data class SqlWithSelect(
    val withList: MutableList<SqlWithItem> = mutableListOf(),
    var recursive: Boolean = false,
    var query: SqlSelectQuery? = null
) : SqlSelectQuery()

data class SqlValuesSelect(val values: MutableList<List<SqlExpr>> = mutableListOf()) : SqlSelectQuery()