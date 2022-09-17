package org.easysql.dsl

import org.easysql.ast.expr.SqlBinaryOperator
import org.easysql.ast.expr.SqlSubQueryPredicate
import org.easysql.ast.order.SqlOrderBy
import org.easysql.ast.order.SqlOrderByOption
import org.easysql.query.select.SelectQuery

sealed class Expr<T>(open var alias: String? = null) : Selectable<T> {
    infix fun <V : T> eq(v: V) = BinaryExpr<Boolean>(this, SqlBinaryOperator.EQ, ConstExpr(v))
    infix fun <V : T> ne(v: V) = BinaryExpr<Boolean>(this, SqlBinaryOperator.NE, ConstExpr(v))
    infix fun <V : T> lt(v: V) = BinaryExpr<Boolean>(this, SqlBinaryOperator.LT, ConstExpr(v))
    infix fun <V : T> le(v: V) = BinaryExpr<Boolean>(this, SqlBinaryOperator.LE, ConstExpr(v))
    infix fun <V : T> gt(v: V) = BinaryExpr<Boolean>(this, SqlBinaryOperator.GT, ConstExpr(v))
    infix fun <V : T> ge(v: V) = BinaryExpr<Boolean>(this, SqlBinaryOperator.GE, ConstExpr(v))

    infix fun <V : T?> eq(e: Expr<V>) = BinaryExpr<Boolean>(this, SqlBinaryOperator.EQ, e)
    infix fun <V : T?> ne(e: Expr<V>) = BinaryExpr<Boolean>(this, SqlBinaryOperator.NE, e)
    infix fun <V : T?> lt(e: Expr<V>) = BinaryExpr<Boolean>(this, SqlBinaryOperator.LT, e)
    infix fun <V : T?> le(e: Expr<V>) = BinaryExpr<Boolean>(this, SqlBinaryOperator.LE, e)
    infix fun <V : T?> gt(e: Expr<V>) = BinaryExpr<Boolean>(this, SqlBinaryOperator.GT, e)
    infix fun <V : T?> ge(e: Expr<V>) = BinaryExpr<Boolean>(this, SqlBinaryOperator.GE, e)

    infix fun <V : T?> eq(q: SelectQuery<Tuple1<V>>) = BinaryExpr<Boolean>(this, SqlBinaryOperator.EQ, SubQueryExpr(q))
    infix fun <V : T?> ne(q: SelectQuery<Tuple1<V>>) = BinaryExpr<Boolean>(this, SqlBinaryOperator.NE, SubQueryExpr(q))
    infix fun <V : T?> lt(q: SelectQuery<Tuple1<V>>) = BinaryExpr<Boolean>(this, SqlBinaryOperator.LT, SubQueryExpr(q))
    infix fun <V : T?> le(q: SelectQuery<Tuple1<V>>) = BinaryExpr<Boolean>(this, SqlBinaryOperator.LE, SubQueryExpr(q))
    infix fun <V : T?> gt(q: SelectQuery<Tuple1<V>>) = BinaryExpr<Boolean>(this, SqlBinaryOperator.GT, SubQueryExpr(q))
    infix fun <V : T?> ge(q: SelectQuery<Tuple1<V>>) = BinaryExpr<Boolean>(this, SqlBinaryOperator.GE, SubQueryExpr(q))

    infix fun and(e: Expr<*>) = BinaryExpr<Boolean>(this, SqlBinaryOperator.AND, e)
    infix fun or(e: Expr<*>) = BinaryExpr<Boolean>(this, SqlBinaryOperator.OR, e)
    infix fun xor(e: Expr<*>) = BinaryExpr<Boolean>(this, SqlBinaryOperator.XOR, e)

    @JvmName("in")
    infix fun <V : T> inList(list: List<V>) = InListExpr<Boolean>(this, list.map { ConstExpr(it) })
    infix fun <V : T> notInList(list: List<V>) = InListExpr<Boolean>(this, list.map { ConstExpr(it) }, true)

    infix fun <V : T?> inList(list: List<Expr<V>>) = InListExpr<Boolean>(this, list)

    @JvmName("notInList_")
    infix fun <V : T?> notInList(list: List<Expr<V>>) = InListExpr<Boolean>(this, list, true)

    infix fun <V : T?> inQuery(query: SelectQuery<Tuple1<V>>) = InListExpr<Boolean>(this, listOf(SubQueryExpr(query)))
    infix fun <V : T?> notInQuery(query: SelectQuery<Tuple1<V>>) = InListExpr<Boolean>(this, listOf(SubQueryExpr(query)), true)

    infix fun <V : T> between(value: Pair<V, V>) =
        BetweenExpr<Boolean>(this, ConstExpr(value.first), ConstExpr(value.second))

    infix fun <V : T> notBetween(value: Pair<V, V>) =
        BetweenExpr<Boolean>(this, ConstExpr(value.first), ConstExpr(value.second), true)

    @JvmName("betweenExpr")
    infix fun <V1 : T?, V2 : T?> between(e: Pair<Expr<V1>, Expr<V2>>) = BetweenExpr<Boolean>(this, e.first, e.second)

    @JvmName("notBetweenExpr")
    infix fun <V1 : T?, V2 : T?> notBetween(e: Pair<Expr<V1>, Expr<V2>>) =
        BetweenExpr<Boolean>(this, e.first, e.second, true)

    open infix fun alias(name: String): Expr<T> {
        this.alias = name
        return this
    }

    fun asc() = OrderBy(this, SqlOrderByOption.ASC)
    fun desc() = OrderBy(this, SqlOrderByOption.DESC)
}

operator fun <T : Number> Expr<T>.plus(v: Number) = BinaryExpr<Number?>(this, SqlBinaryOperator.ADD, ConstExpr(v))
operator fun <T : Number> Expr<T>.minus(v: Number) = BinaryExpr<Number?>(this, SqlBinaryOperator.SUB, ConstExpr(v))
operator fun <T : Number> Expr<T>.times(v: Number) = BinaryExpr<Number?>(this, SqlBinaryOperator.MUL, ConstExpr(v))
operator fun <T : Number> Expr<T>.div(v: Number) = BinaryExpr<Number?>(this, SqlBinaryOperator.DIV, ConstExpr(v))
operator fun <T : Number> Expr<T>.rem(v: Number) = BinaryExpr<Number?>(this, SqlBinaryOperator.MOD, ConstExpr(v))

operator fun <T : Number?> Expr<T>.plus(e: Expr<T>) = BinaryExpr<Number?>(this, SqlBinaryOperator.ADD, e)
operator fun <T : Number?> Expr<T>.minus(e: Expr<T>) = BinaryExpr<Number?>(this, SqlBinaryOperator.SUB, e)
operator fun <T : Number?> Expr<T>.times(e: Expr<T>) = BinaryExpr<Number?>(this, SqlBinaryOperator.MUL, e)
operator fun <T : Number?> Expr<T>.div(e: Expr<T>) = BinaryExpr<Number?>(this, SqlBinaryOperator.DIV, e)
operator fun <T : Number?> Expr<T>.rem(e: Expr<T>) = BinaryExpr<Number?>(this, SqlBinaryOperator.MOD, e)

operator fun <T : Number?> Expr<T>.plus(q: SelectQuery<Tuple1<T>>) = BinaryExpr<Number?>(this, SqlBinaryOperator.ADD, SubQueryExpr(q))
operator fun <T : Number?> Expr<T>.minus(q: SelectQuery<Tuple1<T>>) = BinaryExpr<Number?>(this, SqlBinaryOperator.SUB, SubQueryExpr(q))
operator fun <T : Number?> Expr<T>.times(q: SelectQuery<Tuple1<T>>) = BinaryExpr<Number?>(this, SqlBinaryOperator.MUL, SubQueryExpr(q))
operator fun <T : Number?> Expr<T>.div(q: SelectQuery<Tuple1<T>>) = BinaryExpr<Number?>(this, SqlBinaryOperator.DIV, SubQueryExpr(q))
operator fun <T : Number?> Expr<T>.rem(q: SelectQuery<Tuple1<T>>) = BinaryExpr<Number?>(this, SqlBinaryOperator.MOD, SubQueryExpr(q))

infix fun <T : String?> Expr<T>.like(v: String) = BinaryExpr<Boolean>(this, SqlBinaryOperator.LIKE, ConstExpr(v))
infix fun <T : String?> Expr<T>.notLike(v: String) = BinaryExpr<Boolean>(this, SqlBinaryOperator.NOT_LIKE, ConstExpr(v))

infix fun <T : String?, V : T?> Expr<T>.like(e: Expr<V>) = BinaryExpr<Boolean>(this, SqlBinaryOperator.LIKE, e)
infix fun <T : String?, V : T?> Expr<T>.notLike(e: Expr<V>) = BinaryExpr<Boolean>(this, SqlBinaryOperator.NOT_LIKE, e)

data class ConstExpr<T>(val value: T, override var alias: String? = null) : Expr<T>()

data class BinaryExpr<T>(
    val left: Expr<*>,
    val operator: SqlBinaryOperator,
    val right: Expr<*>,
    override var alias: String? = null
) : Expr<T>() {
    infix fun <V> then(value: V) = CaseBranch<V>(this, ConstExpr(value))
    infix fun <V> then(e: Expr<V>) = CaseBranch<V>(this, e)
    infix fun <V> then(q: SelectQuery<Tuple1<V>>) = CaseBranch<V>(this, SubQueryExpr(q))
}

data class ColumnExpr<T>(val column: String, override var alias: String? = null) : Expr<T>()

data class TableColumnExpr<T>(
    val table: String,
    val column: String,
    val schema: TableSchema<*>,
    override var alias: String? = null
) : Expr<T>() {
    fun primaryKey() = PrimaryKeyColumnExpr<T>(table, column, schema, false)

    fun nullable() = TableColumnExpr<T?>(table, column, schema)

    override fun alias(name: String) = this.copy(alias = name)

    fun incr() = PrimaryKeyColumnExpr<T>(this.table, this.column, schema, true)
}

data class PrimaryKeyColumnExpr<T>(
    val table: String,
    val column: String,
    val schema: TableSchema<*>,
    var incr: Boolean = false,
    override var alias: String? = null
) : Expr<T>() {
    override fun alias(name: String) = this.copy(alias = name)
}

data class SubQueryExpr<T>(val selectQuery: SelectQuery<Tuple1<T>>, override var alias: String? = null) : Expr<T>()

data class NormalFunExpr<T>(
    val name: String,
    val args: List<Expr<*>>,
    override var alias: String? = null
) : Expr<T>()

data class AggFunExpr<T>(
    val name: String,
    val args: List<Expr<*>>,
    val distinct: Boolean = false,
    val attributes: Map<String, Expr<*>> = mapOf(),
    val orderBy: List<OrderBy> = listOf(),
    override var alias: String? = null
) : Expr<T>() {
    fun over() = OverExpr<T>(this)
}

data class CaseExpr<T>(
    val conditions: List<CaseBranch<T>>,
    var default: Expr<*>? = null,
    override var alias: String? = null
) : Expr<T>() {
    infix fun elseIs(value: T?) = if (value != null) CaseExpr(this.conditions, ConstExpr(value)) else this
    infix fun elseIs(e: Expr<T>) = CaseExpr(this.conditions, e)
    infix fun elseIs(q: SelectQuery<Tuple1<T>>) = CaseExpr(this.conditions, SubQueryExpr(q))
}

data class ListExpr<T>(val list: List<Expr<*>>, override var alias: String? = null) : Expr<T>()

data class InListExpr<T>(
    val query: Expr<*>,
    val list: List<Expr<*>>,
    val isNot: Boolean = false,
    override var alias: String? = null
) : Expr<T>()

data class InSubQueryExpr<T>(
    val query: Expr<*>,
    val subQuery: SelectQuery<*>,
    val isNot: Boolean = false,
    override var alias: String? = null
) : Expr<T>()

data class CastExpr<T>(
    val query: Expr<*>,
    val castType: String,
    override var alias: String? = null
) : Expr<T>()

data class BetweenExpr<T>(
    val query: Expr<*>,
    val start: Expr<*>,
    val end: Expr<*>,
    val isNot: Boolean = false,
    override var alias: String? = null
) : Expr<T>()

data class AllColumnExpr(val owner: String? = null, override var alias: String? = null) : Expr<Nothing>()

data class OverExpr<T>(
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

data class SubQueryPredicateExpr<T>(
    val q: SelectQuery<*>,
    val predicate: SqlSubQueryPredicate,
    override var alias: String? = null
) : Expr<T>()

data class CaseBranch<T>(val query: Expr<*>, val thenValue: Expr<*>)

data class OrderBy(val query: Expr<*>, val order: SqlOrderByOption)