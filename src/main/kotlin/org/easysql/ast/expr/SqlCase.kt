package org.easysql.ast.expr

data class SqlCase(val expr: SqlExpr, val thenExpr: SqlExpr)