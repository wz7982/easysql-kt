package org.easysql.ast.order

import org.easysql.ast.SqlNode
import org.easysql.ast.expr.SqlExpr

data class SqlOrderBy(val expr: SqlExpr, val order: SqlOrderByOption) : SqlNode