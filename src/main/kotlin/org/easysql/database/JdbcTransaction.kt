package org.easysql.database

import java.sql.Connection

class JdbcTransaction(val db: DB, val conn: Connection) {
}