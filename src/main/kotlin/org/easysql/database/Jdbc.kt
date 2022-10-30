package org.easysql.database

import java.sql.Connection
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Statement
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

fun query(conn: Connection, sql: String): List<Map<String, Any?>> {
    var stmt: Statement? = null
    var rs: ResultSet? = null
    val result = mutableListOf<Map<String, Any?>>()

    try {
        stmt = conn.createStatement()
        rs = stmt.executeQuery(sql)
        val metadata = rs.metaData

        while (rs.next()) {
            val rowMap = mutableMapOf<String, Any?>()
            (1..metadata.columnCount).forEach {
                var field = rs.getObject(it)
                if (field is LocalDateTime) {
                    field = Date.from(field.atZone(ZoneId.systemDefault()).toInstant())
                }
                rowMap[metadata.getColumnLabel(it)] = field
            }
            result.add(rowMap)
        }
    } catch (e: SQLException) {
        e.printStackTrace()
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
        e.printStackTrace()
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
        e.printStackTrace()
    } finally {
        stmt?.close()
    }

    return result
}

fun execReturnKey(conn: Connection, sql: String): List<Long> {
    var stmt: Statement? = null
    val result = mutableListOf<Long>()

    try {
        stmt = conn.createStatement()
        stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)
        val resultSet = stmt.generatedKeys
        while (resultSet.next()) {
            result += resultSet.getLong(1)
        }
    } catch (e: SQLException) {
        e.printStackTrace()
    } finally {
        stmt?.close()
    }

    return result
}