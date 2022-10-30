package org.easysql.ast.statement.insert

import org.easysql.ast.expr.SqlExpr
import org.easysql.ast.statement.SqlStatement
import org.easysql.ast.statement.select.SqlSelectQuery
import org.easysql.ast.table.SqlIdentTable

data class SqlInsert(
    var table: SqlIdentTable? = null,
    val columns: MutableList<SqlExpr> = mutableListOf(),
    val values: MutableList<List<SqlExpr>> = mutableListOf(),
    var query: SqlSelectQuery? = null
) : SqlStatement
