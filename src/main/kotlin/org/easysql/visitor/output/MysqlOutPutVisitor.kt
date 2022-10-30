package org.easysql.visitor.output

import org.easysql.ast.expr.SqlListExpr
import org.easysql.ast.limit.SqlLimit
import org.easysql.ast.statement.select.SqlValuesSelect
import org.easysql.ast.statement.upsert.SqlUpsert

class MysqlOutPutVisitor : OutPutVisitor() {
    override val quote = "`"

    override fun visitSqlLimit(sqlLimit: SqlLimit) {
        sqlBuilder.append("LIMIT ${sqlLimit.offset}, ${sqlLimit.limit}")
    }

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

        sqlBuilder.append(" ON DUPLICATE KEY UPDATE ")

        printList(sqlUpsert.updateColumns) { it ->
            visitSqlExpr(it)
            sqlBuilder.append(" = VALUES(")
            visitSqlExpr(it)
            sqlBuilder.append(")")
        }
    }

    override fun visitSqlValuesSelect(sqlValuesSelect: SqlValuesSelect) {
        sqlBuilder.append("VALUES ")
        printList(sqlValuesSelect.values.map { SqlListExpr(it) }) { it ->
            sqlBuilder.append("ROW")
            visitSqlExpr(it)
        }
    }
}