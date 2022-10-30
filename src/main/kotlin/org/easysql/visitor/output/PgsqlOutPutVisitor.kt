package org.easysql.visitor.output

import org.easysql.ast.statement.upsert.SqlUpsert

class PgsqlOutPutVisitor : OutPutVisitor() {
    override fun visitSqlUpsert(sqlUpsert: SqlUpsert) {
        sqlBuilder.append("INSERT INTO ")
        visitSqlTableSource(sqlUpsert.table!!)

        sqlBuilder.append(" (")
        printList(sqlUpsert.columns, ::visitSqlExpr)
        sqlBuilder.append(")")

        sqlBuilder.append(" VALUES")
        sqlBuilder.append(" (")
        printList(sqlUpsert.value, ::visitSqlExpr)
        sqlBuilder.append(")")

        sqlBuilder.append(" DO UPDATE SET ")

        printList(sqlUpsert.updateColumns) { it ->
            visitSqlExpr(it)
            sqlBuilder.append(" = ")
            sqlBuilder.append("EXCLUDED.")
            visitSqlExpr(it)
        }
    }
}