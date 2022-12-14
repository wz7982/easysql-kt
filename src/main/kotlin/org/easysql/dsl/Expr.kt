package org.easysql.dsl

import org.easysql.ast.expr.SqlBinaryOperator
import org.easysql.ast.expr.SqlSubQueryPredicate
import org.easysql.ast.order.SqlOrderByOption
import org.easysql.query.select.SelectQuery
import java.math.BigDecimal
import java.util.Date

sealed class Expr<T : Any>(open var alias: String? = null) : Selectable<T> {
    infix fun eq(v: T?) = BinaryExpr<Boolean>(this, SqlBinaryOperator.EQ, ConstExpr(v))
    infix fun ne(v: T?) = BinaryExpr<Boolean>(this, SqlBinaryOperator.NE, ConstExpr(v))
    infix fun lt(v: T) = BinaryExpr<Boolean>(this, SqlBinaryOperator.LT, ConstExpr(v))
    infix fun le(v: T) = BinaryExpr<Boolean>(this, SqlBinaryOperator.LE, ConstExpr(v))
    infix fun gt(v: T) = BinaryExpr<Boolean>(this, SqlBinaryOperator.GT, ConstExpr(v))
    infix fun ge(v: T) = BinaryExpr<Boolean>(this, SqlBinaryOperator.GE, ConstExpr(v))

    infix fun eq(e: Expr<T>) = BinaryExpr<Boolean>(this, SqlBinaryOperator.EQ, e)
    infix fun ne(e: Expr<T>) = BinaryExpr<Boolean>(this, SqlBinaryOperator.NE, e)
    infix fun lt(e: Expr<T>) = BinaryExpr<Boolean>(this, SqlBinaryOperator.LT, e)
    infix fun le(e: Expr<T>) = BinaryExpr<Boolean>(this, SqlBinaryOperator.LE, e)
    infix fun gt(e: Expr<T>) = BinaryExpr<Boolean>(this, SqlBinaryOperator.GT, e)
    infix fun ge(e: Expr<T>) = BinaryExpr<Boolean>(this, SqlBinaryOperator.GE, e)

    infix fun eq(q: SelectQuery<Tuple1<T>>) = BinaryExpr<Boolean>(this, SqlBinaryOperator.EQ, SubQueryExpr(q))
    infix fun ne(q: SelectQuery<Tuple1<T>>) = BinaryExpr<Boolean>(this, SqlBinaryOperator.NE, SubQueryExpr(q))
    infix fun lt(q: SelectQuery<Tuple1<T>>) = BinaryExpr<Boolean>(this, SqlBinaryOperator.LT, SubQueryExpr(q))
    infix fun le(q: SelectQuery<Tuple1<T>>) = BinaryExpr<Boolean>(this, SqlBinaryOperator.LE, SubQueryExpr(q))
    infix fun gt(q: SelectQuery<Tuple1<T>>) = BinaryExpr<Boolean>(this, SqlBinaryOperator.GT, SubQueryExpr(q))
    infix fun ge(q: SelectQuery<Tuple1<T>>) = BinaryExpr<Boolean>(this, SqlBinaryOperator.GE, SubQueryExpr(q))

    @JvmName("in")
    infix fun inList(list: List<T>) = InListExpr<Boolean>(this, list.map { ConstExpr(it) })
    infix fun notInList(list: List<T>) = InListExpr<Boolean>(this, list.map { ConstExpr(it) }, true)

    infix fun inList(list: List<Expr<T>>) = InListExpr<Boolean>(this, list)

    @JvmName("notInList_")
    infix fun notInList(list: List<Expr<T>>) = InListExpr<Boolean>(this, list, true)

    infix fun inQuery(query: SelectQuery<Tuple1<T>>) = InListExpr<Boolean>(this, listOf(SubQueryExpr(query)))
    infix fun notInQuery(query: SelectQuery<Tuple1<T>>) = InListExpr<Boolean>(this, listOf(SubQueryExpr(query)), true)

    infix fun between(value: Pair<T, T>) =
        BetweenExpr<Boolean>(this, ConstExpr(value.first), ConstExpr(value.second))

    infix fun notBetween(value: Pair<T, T>) =
        BetweenExpr<Boolean>(this, ConstExpr(value.first), ConstExpr(value.second), true)

    @JvmName("betweenExpr")
    infix fun between(e: Pair<Expr<T>, Expr<T>>) = BetweenExpr<Boolean>(this, e.first, e.second)

    @JvmName("notBetweenExpr")
    infix fun notBetween(e: Pair<Expr<T>, Expr<T>>) = BetweenExpr<Boolean>(this, e.first, e.second, true)

    open infix fun alias(name: String): Expr<T> {
        this.alias = name
        return this
    }

    fun asc() = OrderBy(this, SqlOrderByOption.ASC)
    fun desc() = OrderBy(this, SqlOrderByOption.DESC)
}

operator fun <T1 : Number, T2 : Number> Expr<T1>.plus(v: T2) = BinaryExpr<BigDecimal>(this, SqlBinaryOperator.ADD, ConstExpr(v))
operator fun <T1 : Number, T2 : Number> Expr<T1>.minus(v: T2) = BinaryExpr<BigDecimal>(this, SqlBinaryOperator.SUB, ConstExpr(v))
operator fun <T1 : Number, T2 : Number> Expr<T1>.times(v: T2) = BinaryExpr<BigDecimal>(this, SqlBinaryOperator.MUL, ConstExpr(v))
operator fun <T1 : Number, T2 : Number> Expr<T1>.div(v: T2) = BinaryExpr<BigDecimal>(this, SqlBinaryOperator.DIV, ConstExpr(v))
operator fun <T1 : Number, T2 : Number> Expr<T1>.rem(v: T2) = BinaryExpr<BigDecimal>(this, SqlBinaryOperator.MOD, ConstExpr(v))
infix fun <T1 : Number, T2 : Number> Expr<T1>.eq(v: T2?) = BinaryExpr<Boolean>(this, SqlBinaryOperator.EQ, ConstExpr(v))
infix fun <T1 : Number, T2 : Number> Expr<T1>.ne(v: T2?) = BinaryExpr<Boolean>(this, SqlBinaryOperator.NE, ConstExpr(v))
infix fun <T1 : Number, T2 : Number> Expr<T1>.gt(v: T2) = BinaryExpr<Boolean>(this, SqlBinaryOperator.GT, ConstExpr(v))
infix fun <T1 : Number, T2 : Number> Expr<T1>.ge(v: T2) = BinaryExpr<Boolean>(this, SqlBinaryOperator.GE, ConstExpr(v))
infix fun <T1 : Number, T2 : Number> Expr<T1>.lt(v: T2) = BinaryExpr<Boolean>(this, SqlBinaryOperator.LT, ConstExpr(v))
infix fun <T1 : Number, T2 : Number> Expr<T1>.le(v: T2) = BinaryExpr<Boolean>(this, SqlBinaryOperator.LE, ConstExpr(v))
infix fun <T : Number> Expr<T>.inList(list: List<Number>) = InListExpr<Boolean>(this, list.map { ConstExpr(it) })
infix fun <T : Number> Expr<T>.notInList(list: List<Number>) = InListExpr<Boolean>(this, list.map { ConstExpr(it) }, true)
fun <T: Number> Expr<T>.between(start: Number, end: Number) = BetweenExpr<Boolean>(this, ConstExpr(start), ConstExpr(end))
fun <T: Number> Expr<T>.notBetween(start: Number, end: Number) = BetweenExpr<Boolean>(this, ConstExpr(start), ConstExpr(end), true)

operator fun <T1 : Number, T2 : Number> Expr<T1>.plus(e: Expr<T2>) = BinaryExpr<BigDecimal>(this, SqlBinaryOperator.ADD, e)
operator fun <T1 : Number, T2 : Number> Expr<T1>.minus(e: Expr<T2>) = BinaryExpr<BigDecimal>(this, SqlBinaryOperator.SUB, e)
operator fun <T1 : Number, T2 : Number> Expr<T1>.times(e: Expr<T2>) = BinaryExpr<BigDecimal>(this, SqlBinaryOperator.MUL, e)
operator fun <T1 : Number, T2 : Number> Expr<T1>.div(e: Expr<T2>) = BinaryExpr<BigDecimal>(this, SqlBinaryOperator.DIV, e)
operator fun <T1 : Number, T2 : Number> Expr<T1>.rem(e: Expr<T2>) = BinaryExpr<BigDecimal>(this, SqlBinaryOperator.MOD, e)
infix fun <T1 : Number, T2 : Number> Expr<T1>.eq(e: Expr<T2>) = BinaryExpr<Boolean>(this, SqlBinaryOperator.EQ, e)
infix fun <T1 : Number, T2 : Number> Expr<T1>.ne(e: Expr<T2>) = BinaryExpr<Boolean>(this, SqlBinaryOperator.NE, e)
infix fun <T1 : Number, T2 : Number> Expr<T1>.gt(e: Expr<T2>) = BinaryExpr<Boolean>(this, SqlBinaryOperator.GT, e)
infix fun <T1 : Number, T2 : Number> Expr<T1>.ge(e: Expr<T2>) = BinaryExpr<Boolean>(this, SqlBinaryOperator.GE, e)
infix fun <T1 : Number, T2 : Number> Expr<T1>.lt(e: Expr<T2>) = BinaryExpr<Boolean>(this, SqlBinaryOperator.LT, e)
infix fun <T1 : Number, T2 : Number> Expr<T1>.le(e: Expr<T2>) = BinaryExpr<Boolean>(this, SqlBinaryOperator.LE, e)

operator fun <T1 : Number, T2 : Number> Expr<T1>.plus(q: SelectQuery<Tuple1<T2>>) = BinaryExpr<BigDecimal>(this, SqlBinaryOperator.ADD, SubQueryExpr(q))
operator fun <T1 : Number, T2 : Number> Expr<T1>.minus(q: SelectQuery<Tuple1<T2>>) = BinaryExpr<BigDecimal>(this, SqlBinaryOperator.SUB, SubQueryExpr(q))
operator fun <T1 : Number, T2 : Number> Expr<T1>.times(q: SelectQuery<Tuple1<T2>>) = BinaryExpr<BigDecimal>(this, SqlBinaryOperator.MUL, SubQueryExpr(q))
operator fun <T1 : Number, T2 : Number> Expr<T1>.div(q: SelectQuery<Tuple1<T2>>) = BinaryExpr<BigDecimal>(this, SqlBinaryOperator.DIV, SubQueryExpr(q))
operator fun <T1 : Number, T2 : Number> Expr<T1>.rem(q: SelectQuery<Tuple1<T2>>) = BinaryExpr<BigDecimal>(this, SqlBinaryOperator.MOD, SubQueryExpr(q))
infix fun <T1 : Number, T2 : Number> Expr<T1>.eq(q: SelectQuery<Tuple1<T2>>) = BinaryExpr<Boolean>(this, SqlBinaryOperator.EQ, SubQueryExpr(q))
infix fun <T1 : Number, T2 : Number> Expr<T1>.ne(q: SelectQuery<Tuple1<T2>>) = BinaryExpr<Boolean>(this, SqlBinaryOperator.NE, SubQueryExpr(q))
infix fun <T1 : Number, T2 : Number> Expr<T1>.gt(q: SelectQuery<Tuple1<T2>>) = BinaryExpr<Boolean>(this, SqlBinaryOperator.GT, SubQueryExpr(q))
infix fun <T1 : Number, T2 : Number> Expr<T1>.ge(q: SelectQuery<Tuple1<T2>>) = BinaryExpr<Boolean>(this, SqlBinaryOperator.GE, SubQueryExpr(q))
infix fun <T1 : Number, T2 : Number> Expr<T1>.lt(q: SelectQuery<Tuple1<T2>>) = BinaryExpr<Boolean>(this, SqlBinaryOperator.LT, SubQueryExpr(q))
infix fun <T1 : Number, T2 : Number> Expr<T1>.le(q: SelectQuery<Tuple1<T2>>) = BinaryExpr<Boolean>(this, SqlBinaryOperator.LE, SubQueryExpr(q))

infix fun Expr<String>.like(v: String) = BinaryExpr<Boolean>(this, SqlBinaryOperator.LIKE, ConstExpr(v))
infix fun Expr<String>.notLike(v: String) = BinaryExpr<Boolean>(this, SqlBinaryOperator.NOT_LIKE, ConstExpr(v))

infix fun Expr<String>.like(e: Expr<String>) = BinaryExpr<Boolean>(this, SqlBinaryOperator.LIKE, e)
infix fun Expr<String>.notLike(e: Expr<String>) = BinaryExpr<Boolean>(this, SqlBinaryOperator.NOT_LIKE, e)

infix fun Expr<Date>.eq(v: String) = BinaryExpr<Boolean>(this, SqlBinaryOperator.EQ, ConstExpr(v))
infix fun Expr<Date>.ne(v: String) = BinaryExpr<Boolean>(this, SqlBinaryOperator.NE, ConstExpr(v))

fun Expr<Date>.between(start: String, end: String) = BetweenExpr<Boolean>(this, ConstExpr(start), ConstExpr(end))
fun Expr<Date>.notBetween(start: String, end: String) = BetweenExpr<Boolean>(this, ConstExpr(start), ConstExpr(end), true)

infix fun Expr<Boolean>.and(e: Expr<Boolean>) = BinaryExpr<Boolean>(this, SqlBinaryOperator.AND, e)
infix fun Expr<Boolean>.or(e: Expr<Boolean>) = BinaryExpr<Boolean>(this, SqlBinaryOperator.OR, e)
infix fun Expr<Boolean>.xor(e: Expr<Boolean>) = BinaryExpr<Boolean>(this, SqlBinaryOperator.XOR, e)

infix fun Expr<Boolean>.and(v: Boolean) = BinaryExpr<Boolean>(this, SqlBinaryOperator.AND, ConstExpr(v))
infix fun Expr<Boolean>.or(v: Boolean) = BinaryExpr<Boolean>(this, SqlBinaryOperator.OR, ConstExpr(v))
infix fun Expr<Boolean>.xor(v: Boolean) = BinaryExpr<Boolean>(this, SqlBinaryOperator.XOR, ConstExpr(v))

data class ConstExpr<T : Any>(val value: T?, override var alias: String? = null) : Expr<T>()

data class BinaryExpr<T : Any>(
    val left: Expr<*>,
    val operator: SqlBinaryOperator,
    val right: Expr<*>,
    override var alias: String? = null
) : Expr<T>() {
    infix fun <V> then(value: T?) = CaseBranch<V>(this, ConstExpr(value))
    infix fun <V> then(e: Expr<T>) = CaseBranch<V>(this, e)
    infix fun <V> then(q: SelectQuery<Tuple1<T>>) = CaseBranch<V>(this, SubQueryExpr(q))
}

data class DynamicColumn<T : Any>(val column: String, override var alias: String? = null) : Expr<T>()

data class Column<T : Any>(
    val table: String,
    val column: String,
    val schema: TableSchema<*>,
    override var alias: String? = null
) : Expr<T>() {
    fun primaryKey() = PrimaryKey<T>(table, column, schema, false)

    override fun alias(name: String) = this.copy(alias = name)

    fun incr() = PrimaryKey<T>(this.table, this.column, schema, true)
}

data class PrimaryKey<T : Any>(
    val table: String,
    val column: String,
    val schema: TableSchema<*>,
    var incr: Boolean = false,
    override var alias: String? = null
) : Expr<T>() {
    override fun alias(name: String) = this.copy(alias = name)
}

data class SubQueryExpr<T : Any>(val selectQuery: SelectQuery<Tuple1<T>>, override var alias: String? = null) :
    Expr<T>()

data class NormalFunExpr<T : Any>(
    val name: String,
    val args: List<Expr<*>>,
    override var alias: String? = null
) : Expr<T>()

data class AggFunExpr<T : Any>(
    val name: String,
    val args: List<Expr<*>>,
    val distinct: Boolean = false,
    val attributes: Map<String, Expr<*>> = mapOf(),
    val orderBy: List<OrderBy> = listOf(),
    override var alias: String? = null
) : Expr<T>() {
    fun over() = OverExpr<T>(this)
}

data class CaseExpr<T : Any>(
    val conditions: List<CaseBranch<T>>,
    var default: Expr<*>? = null,
    override var alias: String? = null
) : Expr<T>() {
    infix fun elseIs(value: T?) = if (value != null) CaseExpr(this.conditions, ConstExpr(value)) else this
    infix fun elseIs(e: Expr<T>) = CaseExpr(this.conditions, e)
    infix fun elseIs(q: SelectQuery<Tuple1<T>>) = CaseExpr(this.conditions, SubQueryExpr(q))
}

data class ListExpr<T : Any>(val list: List<Expr<*>>, override var alias: String? = null) : Expr<T>()

data class InListExpr<T : Any>(
    val query: Expr<*>,
    val list: List<Expr<*>>,
    val isNot: Boolean = false,
    override var alias: String? = null
) : Expr<T>()

data class InSubQueryExpr<T : Any>(
    val query: Expr<*>,
    val subQuery: SelectQuery<*>,
    val isNot: Boolean = false,
    override var alias: String? = null
) : Expr<T>()

data class CastExpr<T : Any>(
    val query: Expr<*>,
    val castType: String,
    override var alias: String? = null
) : Expr<T>()

data class BetweenExpr<T : Any>(
    val query: Expr<*>,
    val start: Expr<*>,
    val end: Expr<*>,
    val isNot: Boolean = false,
    override var alias: String? = null
) : Expr<T>()

data class AllColumnExpr(val owner: String? = null, override var alias: String? = null) : Expr<Nothing>()

data class OverExpr<T : Any>(
    val function: AggFunExpr<*>,
    val partitionBy: MutableList<Expr<*>> = mutableListOf(),
    val orderBy: MutableList<OrderBy> = mutableListOf(),
    override var alias: String? = null
) : Expr<T>() {
    fun partitionBy(vararg exprs: Expr<*>): OverExpr<T> {
        this.partitionBy.addAll(exprs)
        return this
    }

    fun orderBy(vararg ords: OrderBy): OverExpr<T> {
        this.orderBy.addAll(ords)
        return this
    }
}

data class SubQueryPredicateExpr<T : Any>(
    val q: SelectQuery<*>,
    val predicate: SqlSubQueryPredicate,
    override var alias: String? = null
) : Expr<T>()

data class CaseBranch<T>(val query: Expr<*>, val thenValue: Expr<*>)

data class OrderBy(val query: Expr<*>, val order: SqlOrderByOption)