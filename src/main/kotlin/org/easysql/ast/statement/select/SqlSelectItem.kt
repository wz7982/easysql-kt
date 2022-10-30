package org.easysql.ast.statement.select

import org.easysql.ast.SqlNode
import org.easysql.ast.expr.SqlExpr

data class SqlSelectItem(val expr: SqlExpr, val alias: String? = null) : SqlNode
