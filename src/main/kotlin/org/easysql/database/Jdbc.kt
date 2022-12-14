package org.easysql.database

import java.sql.Connection
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Statement
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

fun query(conn: Connection, sql: String): List<List<Any?>> {
    var stmt: Statement? = null
    var rs: ResultSet? = null
    val result = mutableListOf<List<Any?>>()

    try {
        stmt = conn.createStatement()
        rs = stmt.executeQuery(sql)
        val metadata = rs.metaData

        while (rs.next()) {
            val row = (1..metadata.columnCount).map {
                var field = rs.getObject(it)
                if (field is LocalDateTime) {
                    field = Date.from(field.atZone(ZoneId.systemDefault()).toInstant())
                }
                field
            }
            result.add(row)
        }
    } catch (e: SQLException) {
        throw e
    } finally {
        stmt?.close()
        rs?.close()
    }

    return result
}

fun queryCount(conn: Connection, sql: String): Int {
    var stmt: Statement? = null
    var rs: ResultSet? = null
    var result = 0

    try {
        stmt = conn.createStatement()
        rs = stmt.executeQuery(sql)
        result = rs.fetchSize
    } catch (e: SQLException) {
        throw e
    } finally {
        stmt?.close()
        rs?.close()
    }

    return result
}

fun exec(conn: Connection, sql: String): Int {
    var stmt: Statement? = null
    var result = 0

    try {
        stmt = conn.createStatement()
        result = stmt.executeUpdate(sql)
    } catch (e: SQLException) {
        throw e
    } finally {
        stmt?.close()
    }

    return result
}