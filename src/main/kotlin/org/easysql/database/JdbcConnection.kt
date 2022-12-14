package org.easysql.database

import org.easysql.query.ReviseQuery
import org.easysql.query.insert.Insert
import org.easysql.query.select.Select
import java.sql.Connection
import javax.sql.DataSource

class JdbcConnection(override val db: DB, private val dbSource: DataSource) : DBOperator(db) {
    override fun fetchCount(query: Select<*>): Long {
        TODO("Not yet implemented")
    }

    override fun query(sql: String): List<Map<String, Any?>> {
        TODO("Not yet implemented")
    }

    override fun queryFunc(sql: String): List<List<Any?>> = exec { query(it, sql) }

    override fun run(query: ReviseQuery<*>): Int {
        TODO("Not yet implemented")
    }

    override fun runAndReturnKey(query: Insert): List<Long> {
        TODO("Not yet implemented")
    }

    fun <T> exec(handler: (Connection) -> T): T {
        val conn = dbSource.connection
        val result = handler(conn)
        conn.close()
        return result
    }
}