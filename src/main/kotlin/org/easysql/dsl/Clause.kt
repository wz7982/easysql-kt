@file:JvmName("Sql")

package org.easysql.dsl

import org.easysql.ast.expr.SqlSubQueryPredicate
import org.easysql.database.TableEntity
import org.easysql.query.insert.Insert
import org.easysql.query.select.Select
import org.easysql.query.select.SelectQuery
import org.easysql.query.update.Update

fun <T : Any> value(v: T) = ConstExpr(v)

@JvmName("typeCol")
fun <T> col(column: String) = ColumnExpr<T>(column)

fun col(column: String) = ColumnExpr<Any?>(column)

fun <T> caseWhen(vararg conditions: CaseBranch<T>) = CaseExpr(conditions.toList())

fun exists(s: SelectQuery<*>) = SubQueryPredicateExpr<Boolean>(s, SqlSubQueryPredicate.EXISTS)

fun notExists(s: SelectQuery<*>) = SubQueryPredicateExpr<Boolean>(s, SqlSubQueryPredicate.NOT_EXISTS)

fun all(s: SelectQuery<*>) = SubQueryPredicateExpr<Any?>(s, SqlSubQueryPredicate.ALL)

fun any(s: SelectQuery<*>) = SubQueryPredicateExpr<Any?>(s, SqlSubQueryPredicate.ANY)

fun some(s: SelectQuery<*>) = SubQueryPredicateExpr<Any?>(s, SqlSubQueryPredicate.SOME)

fun <T> cast(expr: Expr<*>, cast: String) = CastExpr<T>(expr, cast)

fun cols() = AllColumnExpr()

fun table(name: String): TableSchema<Nothing> = DynamicTable(name)

class DynamicTable(val table: String) : TableSchema<Nothing>(table)

fun select(items: List<Expr<*>>) = Select<EmptyTuple>().select(items)

inline fun <reified T1> select(_1: Selectable<T1>) = Select<EmptyTuple>().select(_1)

inline fun <reified T1, reified T2> select(_1: Selectable<T1>, _2: Selectable<T2>) = Select<EmptyTuple>().select(_1, _2)

inline fun <reified T1, reified T2, reified T3> select(_1: Selectable<T1>, _2: Selectable<T2>, _3: Selectable<T3>) =
    Select<EmptyTuple>().select(_1, _2, _3)

inline fun <reified T1, reified T2, reified T3, reified T4> select(
    _1: Selectable<T1>,
    _2: Selectable<T2>,
    _3: Selectable<T3>,
    _4: Selectable<T4>
) = Select<EmptyTuple>().select(_1, _2, _3, _4)

inline fun <reified T1, reified T2, reified T3, reified T4, reified T5> select(
    _1: Selectable<T1>,
    _2: Selectable<T2>,
    _3: Selectable<T3>,
    _4: Selectable<T4>,
    _5: Selectable<T5>
) = Select<EmptyTuple>().select(_1, _2, _3, _4, _5)

inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6> select(
    _1: Selectable<T1>,
    _2: Selectable<T2>,
    _3: Selectable<T3>,
    _4: Selectable<T4>,
    _5: Selectable<T5>,
    _6: Selectable<T6>
) = Select<EmptyTuple>().select(_1, _2, _3, _4, _5, _6)

inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7> select(
    _1: Selectable<T1>,
    _2: Selectable<T2>,
    _3: Selectable<T3>,
    _4: Selectable<T4>,
    _5: Selectable<T5>,
    _6: Selectable<T6>,
    _7: Selectable<T7>
) = Select<EmptyTuple>().select(_1, _2, _3, _4, _5, _6, _7)

inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8> select(
    _1: Selectable<T1>,
    _2: Selectable<T2>,
    _3: Selectable<T3>,
    _4: Selectable<T4>,
    _5: Selectable<T5>,
    _6: Selectable<T6>,
    _7: Selectable<T7>,
    _8: Selectable<T8>
) = Select<EmptyTuple>().select(_1, _2, _3, _4, _5, _6, _7, _8)

inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9> select(
    _1: Selectable<T1>,
    _2: Selectable<T2>,
    _3: Selectable<T3>,
    _4: Selectable<T4>,
    _5: Selectable<T5>,
    _6: Selectable<T6>,
    _7: Selectable<T7>,
    _8: Selectable<T8>,
    _9: Selectable<T9>
) = Select<EmptyTuple>().select(_1, _2, _3, _4, _5, _6, _7, _8, _9)

inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10> select(
    _1: Selectable<T1>,
    _2: Selectable<T2>,
    _3: Selectable<T3>,
    _4: Selectable<T4>,
    _5: Selectable<T5>,
    _6: Selectable<T6>,
    _7: Selectable<T7>,
    _8: Selectable<T8>,
    _9: Selectable<T9>,
    _10: Selectable<T10>
) = Select<EmptyTuple>().select(_1, _2, _3, _4, _5, _6, _7, _8, _9, _10)

inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11> select(
    _1: Selectable<T1>,
    _2: Selectable<T2>,
    _3: Selectable<T3>,
    _4: Selectable<T4>,
    _5: Selectable<T5>,
    _6: Selectable<T6>,
    _7: Selectable<T7>,
    _8: Selectable<T8>,
    _9: Selectable<T9>,
    _10: Selectable<T10>,
    _11: Selectable<T11>
) = Select<EmptyTuple>().select(_1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11)

inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12> select(
    _1: Selectable<T1>,
    _2: Selectable<T2>,
    _3: Selectable<T3>,
    _4: Selectable<T4>,
    _5: Selectable<T5>,
    _6: Selectable<T6>,
    _7: Selectable<T7>,
    _8: Selectable<T8>,
    _9: Selectable<T9>,
    _10: Selectable<T10>,
    _11: Selectable<T11>,
    _12: Selectable<T12>
) = Select<EmptyTuple>().select(_1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12)

inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13> select(
    _1: Selectable<T1>,
    _2: Selectable<T2>,
    _3: Selectable<T3>,
    _4: Selectable<T4>,
    _5: Selectable<T5>,
    _6: Selectable<T6>,
    _7: Selectable<T7>,
    _8: Selectable<T8>,
    _9: Selectable<T9>,
    _10: Selectable<T10>,
    _11: Selectable<T11>,
    _12: Selectable<T12>,
    _13: Selectable<T13>
) = Select<EmptyTuple>().select(_1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13)

inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14> select(
    _1: Selectable<T1>,
    _2: Selectable<T2>,
    _3: Selectable<T3>,
    _4: Selectable<T4>,
    _5: Selectable<T5>,
    _6: Selectable<T6>,
    _7: Selectable<T7>,
    _8: Selectable<T8>,
    _9: Selectable<T9>,
    _10: Selectable<T10>,
    _11: Selectable<T11>,
    _12: Selectable<T12>,
    _13: Selectable<T13>,
    _14: Selectable<T14>
) = Select<EmptyTuple>().select(_1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14)

inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14, reified T15> select(
    _1: Selectable<T1>,
    _2: Selectable<T2>,
    _3: Selectable<T3>,
    _4: Selectable<T4>,
    _5: Selectable<T5>,
    _6: Selectable<T6>,
    _7: Selectable<T7>,
    _8: Selectable<T8>,
    _9: Selectable<T9>,
    _10: Selectable<T10>,
    _11: Selectable<T11>,
    _12: Selectable<T12>,
    _13: Selectable<T13>,
    _14: Selectable<T14>,
    _15: Selectable<T15>
) = Select<EmptyTuple>().select(_1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15)

inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14, reified T15, reified T16> select(
    _1: Selectable<T1>,
    _2: Selectable<T2>,
    _3: Selectable<T3>,
    _4: Selectable<T4>,
    _5: Selectable<T5>,
    _6: Selectable<T6>,
    _7: Selectable<T7>,
    _8: Selectable<T8>,
    _9: Selectable<T9>,
    _10: Selectable<T10>,
    _11: Selectable<T11>,
    _12: Selectable<T12>,
    _13: Selectable<T13>,
    _14: Selectable<T14>,
    _15: Selectable<T15>,
    _16: Selectable<T16>
) = Select<EmptyTuple>().select(_1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16)

inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14, reified T15, reified T16, reified T17> select(
    _1: Selectable<T1>,
    _2: Selectable<T2>,
    _3: Selectable<T3>,
    _4: Selectable<T4>,
    _5: Selectable<T5>,
    _6: Selectable<T6>,
    _7: Selectable<T7>,
    _8: Selectable<T8>,
    _9: Selectable<T9>,
    _10: Selectable<T10>,
    _11: Selectable<T11>,
    _12: Selectable<T12>,
    _13: Selectable<T13>,
    _14: Selectable<T14>,
    _15: Selectable<T15>,
    _16: Selectable<T16>,
    _17: Selectable<T17>
) = Select<EmptyTuple>().select(_1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17)

inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14, reified T15, reified T16, reified T17, reified T18> select(
    _1: Selectable<T1>,
    _2: Selectable<T2>,
    _3: Selectable<T3>,
    _4: Selectable<T4>,
    _5: Selectable<T5>,
    _6: Selectable<T6>,
    _7: Selectable<T7>,
    _8: Selectable<T8>,
    _9: Selectable<T9>,
    _10: Selectable<T10>,
    _11: Selectable<T11>,
    _12: Selectable<T12>,
    _13: Selectable<T13>,
    _14: Selectable<T14>,
    _15: Selectable<T15>,
    _16: Selectable<T16>,
    _17: Selectable<T17>,
    _18: Selectable<T18>
) = Select<EmptyTuple>().select(_1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17, _18)

inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14, reified T15, reified T16, reified T17, reified T18, reified T19> select(
    _1: Selectable<T1>,
    _2: Selectable<T2>,
    _3: Selectable<T3>,
    _4: Selectable<T4>,
    _5: Selectable<T5>,
    _6: Selectable<T6>,
    _7: Selectable<T7>,
    _8: Selectable<T8>,
    _9: Selectable<T9>,
    _10: Selectable<T10>,
    _11: Selectable<T11>,
    _12: Selectable<T12>,
    _13: Selectable<T13>,
    _14: Selectable<T14>,
    _15: Selectable<T15>,
    _16: Selectable<T16>,
    _17: Selectable<T17>,
    _18: Selectable<T18>,
    _19: Selectable<T19>
) = Select<EmptyTuple>().select(_1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17, _18, _19)

inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14, reified T15, reified T16, reified T17, reified T18, reified T19, reified T20> select(
    _1: Selectable<T1>,
    _2: Selectable<T2>,
    _3: Selectable<T3>,
    _4: Selectable<T4>,
    _5: Selectable<T5>,
    _6: Selectable<T6>,
    _7: Selectable<T7>,
    _8: Selectable<T8>,
    _9: Selectable<T9>,
    _10: Selectable<T10>,
    _11: Selectable<T11>,
    _12: Selectable<T12>,
    _13: Selectable<T13>,
    _14: Selectable<T14>,
    _15: Selectable<T15>,
    _16: Selectable<T16>,
    _17: Selectable<T17>,
    _18: Selectable<T18>,
    _19: Selectable<T19>,
    _20: Selectable<T20>
) = Select<EmptyTuple>().select(
    _1,
    _2,
    _3,
    _4,
    _5,
    _6,
    _7,
    _8,
    _9,
    _10,
    _11,
    _12,
    _13,
    _14,
    _15,
    _16,
    _17,
    _18,
    _19,
    _20
)

inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14, reified T15, reified T16, reified T17, reified T18, reified T19, reified T20, reified T21> select(
    _1: Selectable<T1>,
    _2: Selectable<T2>,
    _3: Selectable<T3>,
    _4: Selectable<T4>,
    _5: Selectable<T5>,
    _6: Selectable<T6>,
    _7: Selectable<T7>,
    _8: Selectable<T8>,
    _9: Selectable<T9>,
    _10: Selectable<T10>,
    _11: Selectable<T11>,
    _12: Selectable<T12>,
    _13: Selectable<T13>,
    _14: Selectable<T14>,
    _15: Selectable<T15>,
    _16: Selectable<T16>,
    _17: Selectable<T17>,
    _18: Selectable<T18>,
    _19: Selectable<T19>,
    _20: Selectable<T20>,
    _21: Selectable<T21>
) = Select<EmptyTuple>().select(
    _1,
    _2,
    _3,
    _4,
    _5,
    _6,
    _7,
    _8,
    _9,
    _10,
    _11,
    _12,
    _13,
    _14,
    _15,
    _16,
    _17,
    _18,
    _19,
    _20,
    _21
)

inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14, reified T15, reified T16, reified T17, reified T18, reified T19, reified T20, reified T21, reified T22> select(
    _1: Selectable<T1>,
    _2: Selectable<T2>,
    _3: Selectable<T3>,
    _4: Selectable<T4>,
    _5: Selectable<T5>,
    _6: Selectable<T6>,
    _7: Selectable<T7>,
    _8: Selectable<T8>,
    _9: Selectable<T9>,
    _10: Selectable<T10>,
    _11: Selectable<T11>,
    _12: Selectable<T12>,
    _13: Selectable<T13>,
    _14: Selectable<T14>,
    _15: Selectable<T15>,
    _16: Selectable<T16>,
    _17: Selectable<T17>,
    _18: Selectable<T18>,
    _19: Selectable<T19>,
    _20: Selectable<T20>,
    _21: Selectable<T21>,
    _22: Selectable<T22>
) = Select<EmptyTuple>().select(
    _1,
    _2,
    _3,
    _4,
    _5,
    _6,
    _7,
    _8,
    _9,
    _10,
    _11,
    _12,
    _13,
    _14,
    _15,
    _16,
    _17,
    _18,
    _19,
    _20,
    _21,
    _22
)

fun insert(vararg entities: TableEntity): Insert = Insert().insert(*entities)

fun update(entity: TableEntity, skipNulls: Boolean = true): Update = Update().update(entity, skipNulls)