package org.easysql.ast.statement.upsert

import org.easysql.ast.expr.SqlExpr
import org.easysql.ast.statement.SqlStatement
import org.easysql.ast.table.SqlIdentTable

data class SqlUpsert(
    var table: SqlIdentTable? = null,
    val columns: MutableList<SqlExpr> = mutableListOf(),
    val value: MutableList<SqlExpr> = mutableListOf(),
    val primaryColumns: MutableList<SqlExpr> = mutableListOf(),
    val updateColumns: MutableList<SqlExpr> = mutableListOf()
) : SqlStatement