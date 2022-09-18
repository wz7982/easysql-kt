package org.easysql.query.select

import org.easysql.ast.expr.SqlAllColumnExpr
import org.easysql.ast.limit.SqlLimit
import org.easysql.ast.order.SqlOrderBy
import org.easysql.ast.statement.select.SqlSelect
import org.easysql.ast.statement.select.SqlSelectItem
import org.easysql.ast.table.*
import org.easysql.database.DB
import org.easysql.dsl.*
import org.easysql.util.toSqlString
import org.easysql.visitor.visitExpr

class Select<T : Tuple> : SelectQuery<T>() {
    val sqlAst = SqlSelect(selectList = mutableListOf(SqlSelectItem(SqlAllColumnExpr())))

    private lateinit var joinLeft: SqlTable

    override fun getAst() = sqlAst

    private fun toSqlTable(t: AnyTable): SqlTable = when (t) {
        is TableSchema<*> -> {
            val table = SqlIdentTable(t.tableName)
            table.alias = t.aliasName
            table
        }

        is JoinTable -> {
            val table = SqlJoinTable(toSqlTable(t.left), t.joinType, toSqlTable(t.right), visitExpr(t.on))
            table
        }
    }

    infix fun from(t: AnyTable): Select<T> {
        val from = toSqlTable(t)

        joinLeft = from
        sqlAst.from = from

        return this
    }

    infix fun from(q: SelectQuery<*>): Select<T> {
        val from = SqlSubQueryTable(q.getAst())
        from.alias = q.aliasName
        joinLeft = from
        sqlAst.from = from

        return this
    }

    fun addSelectItem(s: Selectable<*>) {
        when (s) {
            is TableSchema<*> -> {
                s.cols.forEach {
                    sqlAst.addSelectItem(visitExpr(it))
                }
            }

            is Expr<*> -> {
                sqlAst.addSelectItem(visitExpr(s), s.alias)
                s.alias?.let { aliasNames.add(it) }
            }
        }
    }

    infix fun select(items: List<Expr<*>>): Select<EmptyTuple> {
        if (sqlAst.selectList.size == 1 && sqlAst.selectList[0].expr is SqlAllColumnExpr) {
            sqlAst.selectList.clear()
        }

        items.forEach {
            sqlAst.addSelectItem(visitExpr(it), it.alias)
        }

        return this as Select<EmptyTuple>
    }

    inline fun <reified T1> select(_1: Selectable<T1>): Select<Tuple1<T1>> {
        if (sqlAst.selectList.size == 1 && sqlAst.selectList[0].expr is SqlAllColumnExpr) {
            sqlAst.selectList.clear()
        }
        addSelectItem(_1)

        return this as Select<Tuple1<T1>>
    }

    inline fun <reified T1, reified T2> select(_1: Selectable<T1>, _2: Selectable<T2>): Select<Tuple2<T1, T2>> {
        if (sqlAst.selectList.size == 1 && sqlAst.selectList[0].expr is SqlAllColumnExpr) {
            sqlAst.selectList.clear()
        }
        addSelectItem(_1)
        addSelectItem(_2)

        return this as Select<Tuple2<T1, T2>>
    }

    inline fun <reified T1, reified T2, reified T3> select(
        _1: Selectable<T1>,
        _2: Selectable<T2>,
        _3: Selectable<T3>
    ): Select<Tuple3<T1, T2, T3>> {
        if (sqlAst.selectList.size == 1 && sqlAst.selectList[0].expr is SqlAllColumnExpr) {
            sqlAst.selectList.clear()
        }
        addSelectItem(_1)
        addSelectItem(_2)
        addSelectItem(_3)

        return this as Select<Tuple3<T1, T2, T3>>
    }

    inline fun <reified T1, reified T2, reified T3, reified T4> select(
        _1: Selectable<T1>,
        _2: Selectable<T2>,
        _3: Selectable<T3>,
        _4: Selectable<T4>
    ): Select<Tuple4<T1, T2, T3, T4>> {
        if (sqlAst.selectList.size == 1 && sqlAst.selectList[0].expr is SqlAllColumnExpr) {
            sqlAst.selectList.clear()
        }
        addSelectItem(_1)
        addSelectItem(_2)
        addSelectItem(_3)
        addSelectItem(_4)

        return this as Select<Tuple4<T1, T2, T3, T4>>
    }

    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5> select(
        _1: Selectable<T1>,
        _2: Selectable<T2>,
        _3: Selectable<T3>,
        _4: Selectable<T4>,
        _5: Selectable<T5>
    ): Select<Tuple5<T1, T2, T3, T4, T5>> {
        if (sqlAst.selectList.size == 1 && sqlAst.selectList[0].expr is SqlAllColumnExpr) {
            sqlAst.selectList.clear()
        }
        addSelectItem(_1)
        addSelectItem(_2)
        addSelectItem(_3)
        addSelectItem(_4)
        addSelectItem(_5)

        return this as Select<Tuple5<T1, T2, T3, T4, T5>>
    }

    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6> select(
        _1: Selectable<T1>,
        _2: Selectable<T2>,
        _3: Selectable<T3>,
        _4: Selectable<T4>,
        _5: Selectable<T5>,
        _6: Selectable<T6>
    ): Select<Tuple6<T1, T2, T3, T4, T5, T6>> {
        if (sqlAst.selectList.size == 1 && sqlAst.selectList[0].expr is SqlAllColumnExpr) {
            sqlAst.selectList.clear()
        }
        addSelectItem(_1)
        addSelectItem(_2)
        addSelectItem(_3)
        addSelectItem(_4)
        addSelectItem(_5)
        addSelectItem(_6)

        return this as Select<Tuple6<T1, T2, T3, T4, T5, T6>>
    }

    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7> select(
        _1: Selectable<T1>,
        _2: Selectable<T2>,
        _3: Selectable<T3>,
        _4: Selectable<T4>,
        _5: Selectable<T5>,
        _6: Selectable<T6>,
        _7: Selectable<T7>
    ): Select<Tuple7<T1, T2, T3, T4, T5, T6, T7>> {
        if (sqlAst.selectList.size == 1 && sqlAst.selectList[0].expr is SqlAllColumnExpr) {
            sqlAst.selectList.clear()
        }
        addSelectItem(_1)
        addSelectItem(_2)
        addSelectItem(_3)
        addSelectItem(_4)
        addSelectItem(_5)
        addSelectItem(_6)
        addSelectItem(_7)

        return this as Select<Tuple7<T1, T2, T3, T4, T5, T6, T7>>
    }

    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8> select(
        _1: Selectable<T1>,
        _2: Selectable<T2>,
        _3: Selectable<T3>,
        _4: Selectable<T4>,
        _5: Selectable<T5>,
        _6: Selectable<T6>,
        _7: Selectable<T7>,
        _8: Selectable<T8>
    ): Select<Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>> {
        if (sqlAst.selectList.size == 1 && sqlAst.selectList[0].expr is SqlAllColumnExpr) {
            sqlAst.selectList.clear()
        }
        addSelectItem(_1)
        addSelectItem(_2)
        addSelectItem(_3)
        addSelectItem(_4)
        addSelectItem(_5)
        addSelectItem(_6)
        addSelectItem(_7)
        addSelectItem(_8)

        return this as Select<Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>>
    }

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
    ): Select<Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>> {
        if (sqlAst.selectList.size == 1 && sqlAst.selectList[0].expr is SqlAllColumnExpr) {
            sqlAst.selectList.clear()
        }
        addSelectItem(_1)
        addSelectItem(_2)
        addSelectItem(_3)
        addSelectItem(_4)
        addSelectItem(_5)
        addSelectItem(_6)
        addSelectItem(_7)
        addSelectItem(_8)
        addSelectItem(_9)

        return this as Select<Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>>
    }

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
    ): Select<Tuple10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>> {
        if (sqlAst.selectList.size == 1 && sqlAst.selectList[0].expr is SqlAllColumnExpr) {
            sqlAst.selectList.clear()
        }
        addSelectItem(_1)
        addSelectItem(_2)
        addSelectItem(_3)
        addSelectItem(_4)
        addSelectItem(_5)
        addSelectItem(_6)
        addSelectItem(_7)
        addSelectItem(_8)
        addSelectItem(_9)
        addSelectItem(_10)

        return this as Select<Tuple10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>>
    }

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
    ): Select<Tuple11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>> {
        if (sqlAst.selectList.size == 1 && sqlAst.selectList[0].expr is SqlAllColumnExpr) {
            sqlAst.selectList.clear()
        }
        addSelectItem(_1)
        addSelectItem(_2)
        addSelectItem(_3)
        addSelectItem(_4)
        addSelectItem(_5)
        addSelectItem(_6)
        addSelectItem(_7)
        addSelectItem(_8)
        addSelectItem(_9)
        addSelectItem(_10)
        addSelectItem(_11)

        return this as Select<Tuple11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>>
    }

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
    ): Select<Tuple12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>> {
        if (sqlAst.selectList.size == 1 && sqlAst.selectList[0].expr is SqlAllColumnExpr) {
            sqlAst.selectList.clear()
        }
        addSelectItem(_1)
        addSelectItem(_2)
        addSelectItem(_3)
        addSelectItem(_4)
        addSelectItem(_5)
        addSelectItem(_6)
        addSelectItem(_7)
        addSelectItem(_8)
        addSelectItem(_9)
        addSelectItem(_10)
        addSelectItem(_11)
        addSelectItem(_12)

        return this as Select<Tuple12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>>
    }

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
    ): Select<Tuple13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>> {
        if (sqlAst.selectList.size == 1 && sqlAst.selectList[0].expr is SqlAllColumnExpr) {
            sqlAst.selectList.clear()
        }
        addSelectItem(_1)
        addSelectItem(_2)
        addSelectItem(_3)
        addSelectItem(_4)
        addSelectItem(_5)
        addSelectItem(_6)
        addSelectItem(_7)
        addSelectItem(_8)
        addSelectItem(_9)
        addSelectItem(_10)
        addSelectItem(_11)
        addSelectItem(_12)
        addSelectItem(_13)

        return this as Select<Tuple13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>>
    }

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
    ): Select<Tuple14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>> {
        if (sqlAst.selectList.size == 1 && sqlAst.selectList[0].expr is SqlAllColumnExpr) {
            sqlAst.selectList.clear()
        }
        addSelectItem(_1)
        addSelectItem(_2)
        addSelectItem(_3)
        addSelectItem(_4)
        addSelectItem(_5)
        addSelectItem(_6)
        addSelectItem(_7)
        addSelectItem(_8)
        addSelectItem(_9)
        addSelectItem(_10)
        addSelectItem(_11)
        addSelectItem(_12)
        addSelectItem(_13)
        addSelectItem(_14)

        return this as Select<Tuple14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>>
    }

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
    ): Select<Tuple15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>> {
        if (sqlAst.selectList.size == 1 && sqlAst.selectList[0].expr is SqlAllColumnExpr) {
            sqlAst.selectList.clear()
        }
        addSelectItem(_1)
        addSelectItem(_2)
        addSelectItem(_3)
        addSelectItem(_4)
        addSelectItem(_5)
        addSelectItem(_6)
        addSelectItem(_7)
        addSelectItem(_8)
        addSelectItem(_9)
        addSelectItem(_10)
        addSelectItem(_11)
        addSelectItem(_12)
        addSelectItem(_13)
        addSelectItem(_14)
        addSelectItem(_15)

        return this as Select<Tuple15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>>
    }

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
    ): Select<Tuple16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>> {
        if (sqlAst.selectList.size == 1 && sqlAst.selectList[0].expr is SqlAllColumnExpr) {
            sqlAst.selectList.clear()
        }
        addSelectItem(_1)
        addSelectItem(_2)
        addSelectItem(_3)
        addSelectItem(_4)
        addSelectItem(_5)
        addSelectItem(_6)
        addSelectItem(_7)
        addSelectItem(_8)
        addSelectItem(_9)
        addSelectItem(_10)
        addSelectItem(_11)
        addSelectItem(_12)
        addSelectItem(_13)
        addSelectItem(_14)
        addSelectItem(_15)
        addSelectItem(_16)

        return this as Select<Tuple16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>>
    }

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
    ): Select<Tuple17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>> {
        if (sqlAst.selectList.size == 1 && sqlAst.selectList[0].expr is SqlAllColumnExpr) {
            sqlAst.selectList.clear()
        }
        addSelectItem(_1)
        addSelectItem(_2)
        addSelectItem(_3)
        addSelectItem(_4)
        addSelectItem(_5)
        addSelectItem(_6)
        addSelectItem(_7)
        addSelectItem(_8)
        addSelectItem(_9)
        addSelectItem(_10)
        addSelectItem(_11)
        addSelectItem(_12)
        addSelectItem(_13)
        addSelectItem(_14)
        addSelectItem(_15)
        addSelectItem(_16)
        addSelectItem(_17)

        return this as Select<Tuple17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>>
    }

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
    ): Select<Tuple18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>> {
        if (sqlAst.selectList.size == 1 && sqlAst.selectList[0].expr is SqlAllColumnExpr) {
            sqlAst.selectList.clear()
        }
        addSelectItem(_1)
        addSelectItem(_2)
        addSelectItem(_3)
        addSelectItem(_4)
        addSelectItem(_5)
        addSelectItem(_6)
        addSelectItem(_7)
        addSelectItem(_8)
        addSelectItem(_9)
        addSelectItem(_10)
        addSelectItem(_11)
        addSelectItem(_12)
        addSelectItem(_13)
        addSelectItem(_14)
        addSelectItem(_15)
        addSelectItem(_16)
        addSelectItem(_17)
        addSelectItem(_18)

        return this as Select<Tuple18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>>
    }

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
    ): Select<Tuple19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>> {
        if (sqlAst.selectList.size == 1 && sqlAst.selectList[0].expr is SqlAllColumnExpr) {
            sqlAst.selectList.clear()
        }
        addSelectItem(_1)
        addSelectItem(_2)
        addSelectItem(_3)
        addSelectItem(_4)
        addSelectItem(_5)
        addSelectItem(_6)
        addSelectItem(_7)
        addSelectItem(_8)
        addSelectItem(_9)
        addSelectItem(_10)
        addSelectItem(_11)
        addSelectItem(_12)
        addSelectItem(_13)
        addSelectItem(_14)
        addSelectItem(_15)
        addSelectItem(_16)
        addSelectItem(_17)
        addSelectItem(_18)
        addSelectItem(_19)

        return this as Select<Tuple19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>>
    }

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
    ): Select<Tuple20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>> {
        if (sqlAst.selectList.size == 1 && sqlAst.selectList[0].expr is SqlAllColumnExpr) {
            sqlAst.selectList.clear()
        }
        addSelectItem(_1)
        addSelectItem(_2)
        addSelectItem(_3)
        addSelectItem(_4)
        addSelectItem(_5)
        addSelectItem(_6)
        addSelectItem(_7)
        addSelectItem(_8)
        addSelectItem(_9)
        addSelectItem(_10)
        addSelectItem(_11)
        addSelectItem(_12)
        addSelectItem(_13)
        addSelectItem(_14)
        addSelectItem(_15)
        addSelectItem(_16)
        addSelectItem(_17)
        addSelectItem(_18)
        addSelectItem(_19)
        addSelectItem(_20)

        return this as Select<Tuple20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>>
    }

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
    ): Select<Tuple21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>> {
        if (sqlAst.selectList.size == 1 && sqlAst.selectList[0].expr is SqlAllColumnExpr) {
            sqlAst.selectList.clear()
        }
        addSelectItem(_1)
        addSelectItem(_2)
        addSelectItem(_3)
        addSelectItem(_4)
        addSelectItem(_5)
        addSelectItem(_6)
        addSelectItem(_7)
        addSelectItem(_8)
        addSelectItem(_9)
        addSelectItem(_10)
        addSelectItem(_11)
        addSelectItem(_12)
        addSelectItem(_13)
        addSelectItem(_14)
        addSelectItem(_15)
        addSelectItem(_16)
        addSelectItem(_17)
        addSelectItem(_18)
        addSelectItem(_19)
        addSelectItem(_20)
        addSelectItem(_21)

        return this as Select<Tuple21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>>
    }

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
    ): Select<Tuple22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>> {
        if (sqlAst.selectList.size == 1 && sqlAst.selectList[0].expr is SqlAllColumnExpr) {
            sqlAst.selectList.clear()
        }
        addSelectItem(_1)
        addSelectItem(_2)
        addSelectItem(_3)
        addSelectItem(_4)
        addSelectItem(_5)
        addSelectItem(_6)
        addSelectItem(_7)
        addSelectItem(_8)
        addSelectItem(_9)
        addSelectItem(_10)
        addSelectItem(_11)
        addSelectItem(_12)
        addSelectItem(_13)
        addSelectItem(_14)
        addSelectItem(_15)
        addSelectItem(_16)
        addSelectItem(_17)
        addSelectItem(_18)
        addSelectItem(_19)
        addSelectItem(_20)
        addSelectItem(_21)
        addSelectItem(_22)

        return this as Select<Tuple22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>>
    }

    fun distinct(): Select<T> {
        sqlAst.distinct = true
        return this
    }

    infix fun where(condition: Expr<*>): Select<T> {
        sqlAst.addCondition(visitExpr(condition))
        return this
    }

    infix fun having(condition: Expr<*>): Select<T> {
        sqlAst.addHaving(visitExpr(condition))
        return this
    }

    infix fun orderBy(items: List<OrderBy>): Select<T> {
        sqlAst.orderBy.addAll(items.map { SqlOrderBy(visitExpr(it.query), it.order) })
        return this
    }

    infix fun orderBy(item: OrderBy): Select<T> = orderBy(listOf(item))

    fun orderBy(vararg items: OrderBy): Select<T> = orderBy(items.toList())

    infix fun limit(count: Int): Select<T> {
        if (sqlAst.limit == null) {
            sqlAst.limit = SqlLimit(count, 0)
        } else {
            sqlAst.limit?.limit = count
        }

        return this
    }

    infix fun offset(offset: Int): Select<T> {
        if (sqlAst.limit == null) {
            sqlAst.limit = SqlLimit(1, offset)
        } else {
            sqlAst.limit?.offset = offset
        }

        return this
    }

    infix fun groupBy(items: List<Expr<*>>): Select<T> {
        sqlAst.groupBy.addAll(items.map { visitExpr(it) })
        return this
    }

    infix fun groupBy(item: Expr<*>): Select<T> = groupBy(listOf(item))

    fun groupBy(vararg items: Expr<*>): Select<T> = groupBy(items.toList())

    private fun joinClause(table: AnyTable, joinType: SqlJoinType): Select<T> {
        val joinTable = toSqlTable(table)
        val join = SqlJoinTable(joinLeft, joinType, joinTable)
        sqlAst.from = join
        joinLeft = join

        return this
    }

    private fun joinClause(table: SelectQuery<*>, joinType: SqlJoinType, isLateral: Boolean = false): Select<T> {
        val join = SqlJoinTable(joinLeft, joinType, SqlSubQueryTable(table.getAst(), isLateral))
        join.alias = table.aliasName
        sqlAst.from = join
        joinLeft = join

        return this
    }

    infix fun on(on: Expr<*>): Select<T> {
        val from = sqlAst.from
        if (from != null && from is SqlJoinTable) {
            from.on = visitExpr(on)
        }

        return this
    }

    infix fun join(table: AnyTable): Select<T> = joinClause(table, SqlJoinType.JOIN)

    infix fun join(query: SelectQuery<*>): Select<T> = joinClause(query, SqlJoinType.JOIN)

    infix fun join(table: JoinTable): Select<T> = joinClause(table, SqlJoinType.JOIN)

    infix fun joinLateral(query: SelectQuery<*>): Select<T> = joinClause(query, SqlJoinType.JOIN, true)

    infix fun leftJoin(table: AnyTable): Select<T> = joinClause(table, SqlJoinType.LEFT_JOIN)

    infix fun leftJoin(query: SelectQuery<*>): Select<T> = joinClause(query, SqlJoinType.LEFT_JOIN)

    infix fun leftJoin(table: JoinTable): Select<T> = joinClause(table, SqlJoinType.LEFT_JOIN)

    infix fun leftJoinLateral(query: SelectQuery<*>): Select<T> = joinClause(query, SqlJoinType.LEFT_JOIN, true)

    infix fun rightJoin(table: AnyTable): Select<T> = joinClause(table, SqlJoinType.RIGHT_JOIN)

    infix fun rightJoin(query: SelectQuery<*>): Select<T> = joinClause(query, SqlJoinType.RIGHT_JOIN)

    infix fun rightJoin(table: JoinTable): Select<T> = joinClause(table, SqlJoinType.RIGHT_JOIN)

    infix fun rightJoinLateral(query: SelectQuery<*>): Select<T> = joinClause(query, SqlJoinType.RIGHT_JOIN, true)

    infix fun innerJoin(table: AnyTable): Select<T> = joinClause(table, SqlJoinType.INNER_JOIN)

    infix fun innerJoin(query: SelectQuery<*>): Select<T> = joinClause(query, SqlJoinType.INNER_JOIN)

    infix fun innerJoin(table: JoinTable): Select<T> = joinClause(table, SqlJoinType.INNER_JOIN)

    infix fun innerJoinLateral(query: SelectQuery<*>): Select<T> = joinClause(query, SqlJoinType.INNER_JOIN, true)

    infix fun crossJoin(table: AnyTable): Select<T> = joinClause(table, SqlJoinType.CROSS_JOIN)

    infix fun crossJoin(query: SelectQuery<*>): Select<T> = joinClause(query, SqlJoinType.CROSS_JOIN)

    infix fun crossJoin(table: JoinTable): Select<T> = joinClause(table, SqlJoinType.CROSS_JOIN)

    infix fun crossJoinLateral(query: SelectQuery<*>): Select<T> = joinClause(query, SqlJoinType.CROSS_JOIN, true)

    infix fun fullJoin(table: AnyTable): Select<T> = joinClause(table, SqlJoinType.FULL_JOIN)

    infix fun fullJoin(query: SelectQuery<*>): Select<T> = joinClause(query, SqlJoinType.FULL_JOIN)

    infix fun fullJoin(table: JoinTable): Select<T> = joinClause(table, SqlJoinType.FULL_JOIN)

    infix fun fullJoinLateral(query: SelectQuery<*>): Select<T> = joinClause(query, SqlJoinType.FULL_JOIN, true)

    fun forUpdate(): Select<T> {
        sqlAst.forUpdate = true
        return this
    }

    fun countSql(db: DB): String {
        val copy = sqlAst.copy(selectList = mutableListOf(), limit = null, orderBy = mutableListOf())
        copy.addSelectItem(visitExpr(count()), "count")

        return toSqlString(db, copy)
    }

    fun pageSql(pageSize: Int, pageNum: Int, db: DB): String {
        val offset = if (pageNum <= 1) 0 else pageSize * (pageNum - 1)
        val limit = SqlLimit(pageSize, offset)
        val copy = sqlAst.copy(limit = limit)
        return toSqlString(db, copy)
    }
}