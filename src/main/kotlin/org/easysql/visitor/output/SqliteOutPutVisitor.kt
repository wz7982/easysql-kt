package org.easysql.visitor.output

import org.easysql.ast.limit.SqlLimit
import org.easysql.ast.statement.upsert.SqlUpsert

class SqliteOutPutVisitor : OutPutVisitor() {
    override fun visitSqlLimit(sqlLimit: SqlLimit) {
        sqlBuilder.append("LIMIT ${sqlLimit.offset}, ${sqlLimit.limit}")
    }

    override fun visitSqlUpsert(sqlUpsert: SqlUpsert) {
        sqlBuilder.append("INSERT OR REPLACE INTO ")
        visitSqlTableSource(sqlUpsert.table!!)

        sqlBuilder.append(" (")
        printList(sqlUpsert.columns, ::visitSqlExpr)
        sqlBuilder.append(")")

        sqlBuilder.append(" VALUES")
        sqlBuilder.append(" (")
        printList(sqlUpsert.value, ::visitSqlExpr)
        sqlBuilder.append(")")
    }
}