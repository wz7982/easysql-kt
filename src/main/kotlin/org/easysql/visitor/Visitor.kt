package org.easysql.visitor

import org.easysql.ast.expr.*
import org.easysql.ast.order.SqlOrderBy
import org.easysql.dsl.*
import org.easysql.query.select.SelectQuery
import java.sql.SQLException
import java.util.*

fun visitExpr(e: Expr<*>?): SqlExpr = when (e) {
    null -> SqlNullExpr
    is ConstExpr -> toSqlExpr(e.value)
    is BinaryExpr -> SqlBinaryExpr(visitExpr(e.left), e.operator, visitExpr(e.right))
    is ColumnExpr -> visitColumnExpr(e)
    is TableColumnExpr -> SqlPropertyExpr((if (e.schema.aliasName == null) e.table else e.schema.aliasName)!!, e.column)
    is PrimaryKeyColumnExpr -> SqlPropertyExpr((if (e.schema.aliasName == null) e.table else e.schema.aliasName)!!, e.column)
    is SubQueryExpr -> SqlSelectQueryExpr(e.selectQuery.getAst())
    is NormalFunExpr -> SqlExprFunctionExpr(e.name, e.args.map { visitExpr(it) })
    is AggFunExpr -> visitAggFunExpr(e)
    is CaseExpr -> SqlCaseExpr(e.conditions.map {
        SqlCase(
            visitExpr(it.query),
            visitExpr(it.thenValue)
        )
    }, visitExpr(e.default))
    is InListExpr -> SqlInExpr(visitExpr(e.query), SqlListExpr(e.list.map { visitExpr(it) }), e.isNot)
    is InSubQueryExpr -> SqlInExpr(visitExpr(e.query), SqlSelectQueryExpr(e.subQuery.getAst()), e.isNot)
    is CastExpr -> SqlCastExpr(visitExpr(e.query), e.castType)
    is BetweenExpr -> SqlBetweenExpr(visitExpr(e.query), visitExpr(e.start), visitExpr(e.end), e.isNot)
    is AllColumnExpr -> SqlAllColumnExpr(e.owner)
    is OverExpr -> SqlOverExpr(
        visitAggFunExpr(e.function),
        e.partitionBy.map { visitExpr(it) },
        e.orderBy.map { SqlOrderBy(visitExpr(it.query), it.order) })
    is SubQueryPredicateExpr -> SqlSubQueryPredicateExpr(SqlSelectQueryExpr(e.q.getAst()), e.predicate)
    is ListExpr -> SqlListExpr(e.list.map { visitExpr(it) })
}

fun visitColumnExpr(expr: ColumnExpr<*>): SqlExpr =
    if (expr.column.contains(".")) {
        val split = expr.column.split("\\.")
        if (split.last().contains("*")) {
            SqlAllColumnExpr(split.first())
        } else {
            SqlPropertyExpr(split.first(), split.last())
        }
    } else {
        if (expr.column.contains("*")) {
            SqlAllColumnExpr()
        } else {
            SqlIdentExpr(expr.column)
        }
    }

fun visitAggFunExpr(agg: AggFunExpr<*>): SqlAggFunctionExpr =
    SqlAggFunctionExpr(
        agg.name,
        agg.args.map { visitExpr(it) },
        agg.distinct,
        agg.attributes.map { (k, v) -> k to visitExpr(v) }.toMap(),
        agg.orderBy.map {
            SqlOrderBy(
                visitExpr(it.query), it.order
            )
        })

fun toSqlExpr(value: Any?): SqlExpr = when (value) {
    null -> SqlNullExpr
    is String -> SqlCharExpr(value)
    is Number -> SqlNumberExpr(value)
    is Boolean -> SqlBooleanExpr(value)
    is Date -> SqlDateExpr(value)
    is Expr<*> -> visitExpr(value)
    is SelectQuery<*> -> SqlSelectQueryExpr(value.getAst())
    else -> throw SQLException("此类型不能被正确转换为sql表达式")
}