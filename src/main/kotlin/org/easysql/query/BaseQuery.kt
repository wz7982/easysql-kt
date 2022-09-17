package org.easysql.query

import org.easysql.ast.statement.SqlStatement
import org.easysql.database.DB
import org.easysql.util.toSqlString

interface BaseQuery<T : SqlStatement> {
    fun getAst(): T

    fun sql(db: DB): String = toSqlString(db, getAst())
}