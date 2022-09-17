package org.easysql.ast.statement.truncate

import org.easysql.ast.statement.SqlStatement
import org.easysql.ast.table.SqlIdentTable

data class SqlTruncate(var table: SqlIdentTable? = null) : SqlStatement
