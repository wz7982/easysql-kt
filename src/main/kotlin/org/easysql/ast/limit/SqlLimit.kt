package org.easysql.ast.limit

import org.easysql.ast.SqlNode

data class SqlLimit(var limit: Int, var offset: Int): SqlNode
