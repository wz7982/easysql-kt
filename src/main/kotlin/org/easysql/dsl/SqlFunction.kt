@file:JvmName("SqlFunction")

package org.easysql.dsl

fun count() = AggFunExpr<Number>("COUNT", listOf())

fun count(e: Expr<*>) = AggFunExpr<Number>("COUNT", listOf(e))

fun countDistinct(e: Expr<*>) = AggFunExpr<Number>("COUNT", listOf(e), distinct = true)

fun sum(e: Expr<Number>) = AggFunExpr<Number>("SUM", listOf(e))

fun avg(e: Expr<Number>) = AggFunExpr<Number>("AVG", listOf(e))

fun <T : Any> max(e: Expr<T>) = AggFunExpr<T>("MAX", listOf(e))

fun <T : Any> min(e: Expr<T>) = AggFunExpr<T>("MIN", listOf(e))

fun rank() = AggFunExpr<Number>("RANK", listOf())

fun denseRank() = AggFunExpr<Number>("DENSE_RANK", listOf())

fun rowNumber() = AggFunExpr<Number>("ROW_NUMBER", listOf())

fun cube(vararg expr: Expr<*>) = NormalFunExpr<Nothing>("CUBE", expr.toList())

fun roolup(vararg expr: Expr<*>) = NormalFunExpr<Nothing>("ROOLUP", expr.toList())

fun groupingSets(vararg sets: List<Expr<*>>): NormalFunExpr<Nothing> {
    val name = "GROUPING SETS"
    val args = sets.map { ListExpr<Nothing>(it) }
    return NormalFunExpr(name, args)
}