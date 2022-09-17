package org.easysql.database

import org.easysql.query.BaseQuery
import org.easysql.query.insert.Insert
import org.easysql.query.select.Select
import org.easysql.query.select.SelectQuery
import java.sql.Connection
import javax.sql.DataSource

class JdbcConnection(val db: DB, val dbSource: DataSource) {

}