package org.easysql.database

import javax.sql.DataSource

class JdbcConnection(val db: DB, val dbSource: DataSource) : DBOperator() {

}