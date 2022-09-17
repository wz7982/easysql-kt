package org.easysql.ast.table

import org.easysql.ast.SqlNode
import org.easysql.ast.expr.SqlExpr
import org.easysql.ast.statement.select.SqlSelectQuery

sealed class SqlTable(var alias: String? = null, var columnAliasNames: MutableList<String> = mutableListOf()) :
    SqlNode

data class SqlIdentTable(val tableName: String) : SqlTable()

data class SqlSubQueryTable(
    val select: SqlSelectQuery,
    var isLateral: Boolean = false
) : SqlTable()

data class SqlJoinTable(
    val left: SqlTable,
    val joinType: SqlJoinType,
    val right: SqlTable,
    var on: SqlExpr? = null
) : SqlTable()
