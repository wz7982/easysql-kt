package org.easysql.database

import org.easysql.query.ReviseQuery
import org.easysql.query.insert.Insert
import org.easysql.query.select.Select
import java.sql.Connection

class JdbcTransaction(override val db: DB, val conn: Connection) : DBOperator(db) {
    override fun fetchCount(query: Select<*>): Long {
        TODO("Not yet implemented")
    }

    override fun query(sql: String): List<Map<String, Any?>> {
        TODO("Not yet implemented")
    }

    override fun queryFunc(sql: String): List<List<Any?>> {
        TODO("Not yet implemented")
    }

    override fun run(query: ReviseQuery<*>): Int {
        TODO("Not yet implemented")
    }

    override fun runAndReturnKey(query: Insert): List<Long> {
        TODO("Not yet implemented")
    }
}