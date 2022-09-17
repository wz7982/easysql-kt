package org.easysql.visitor.output

import org.easysql.ast.limit.SqlLimit
import org.easysql.ast.statement.upsert.SqlUpsert

class OracleOutPutVisitor : OutPutVisitor() {
    override fun visitSqlLimit(sqlLimit: SqlLimit) {
        sqlBuilder.append("OFFSET ${sqlLimit.offset} ROWS FETCH FIRST ${sqlLimit.limit} ROWS ONLY")
    }

    override fun printWithRecursive() {}

    override fun visitSqlUpsert(sqlUpsert: SqlUpsert) {
        sqlBuilder.append("MERGE INTO ")
        visitSqlTableSource(sqlUpsert.table!!)
        sqlBuilder.append(" ${quote}t1$quote")

        sqlBuilder.append(" USING (")
        sqlBuilder.append("SELECT ")
        for (index in sqlUpsert.columns.indices) {
            visitSqlExpr(sqlUpsert.value[index])
            sqlBuilder.append(" AS ")
            visitSqlExpr(sqlUpsert.columns[index])
            if (index < sqlUpsert.columns.size - 1) {
                sqlBuilder.append(",")
                sqlBuilder.append(" ")
            }
        }
        sqlBuilder.append(" FROM ${quote}dual$quote) ${quote}t2$quote")

        sqlBuilder.append("\nON (")
        for (index in sqlUpsert.primaryColumns.indices) {
            sqlBuilder.append("${quote}t1$quote.")
            visitSqlExpr(sqlUpsert.primaryColumns[index])
            sqlBuilder.append(" = ")
            sqlBuilder.append("${quote}t2$quote.")
            visitSqlExpr(sqlUpsert.primaryColumns[index])
            if (index < sqlUpsert.primaryColumns.size - 1) {
                sqlBuilder.append(" AND ")
            }
        }
        sqlBuilder.append(")")

        sqlBuilder.append("\nWHEN MATCHED THEN UPDATE SET ")
        printList(sqlUpsert.updateColumns) { it ->
            sqlBuilder.append("${quote}t1$quote.")
            visitSqlExpr(it)
            sqlBuilder.append(" = ")
            sqlBuilder.append("${quote}t2$quote.")
            visitSqlExpr(it)
        }

        sqlBuilder.append("\nWHEN NOT MATCHED THEN INSERT")
        sqlBuilder.append(" (")
        printList(sqlUpsert.columns) { it ->
            sqlBuilder.append("${quote}t1$quote.")
            visitSqlExpr(it)
        }
        sqlBuilder.append(")")

        sqlBuilder.append(" VALUES")
        sqlBuilder.append(" (")
        printList(sqlUpsert.value, ::visitSqlExpr)
        sqlBuilder.append(")")
    }
}