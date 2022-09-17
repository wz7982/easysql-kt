package org.easysql.util

import org.easysql.ast.statement.SqlStatement
import org.easysql.database.DB
import org.easysql.visitor.output.*

fun getVisitor(db: DB): OutPutVisitor = when (db) {
    DB.MYSQL -> MysqlOutPutVisitor()
    DB.PGSQL -> PgsqlOutPutVisitor()
    DB.ORACLE -> OracleOutPutVisitor()
    DB.SQLSERVER -> SqlServerOutPutVisitor()
    DB.SQLITE -> SqliteOutPutVisitor()
}

fun toSqlString(db: DB, stmt: SqlStatement): String {
    val visitor = getVisitor(db)
    visitor.visitSqlStatement(stmt)
    return visitor.sql()
}