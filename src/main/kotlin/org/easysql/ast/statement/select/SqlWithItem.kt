package org.easysql.ast.statement.select

import org.easysql.ast.SqlNode
import org.easysql.ast.expr.SqlExpr

data class SqlWithItem(val name: SqlExpr, val query: SqlSelectQuery, val columns: List<SqlExpr>) : SqlNode
