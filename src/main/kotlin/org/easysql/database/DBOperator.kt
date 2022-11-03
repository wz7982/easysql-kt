package org.easysql.database

import org.easysql.dsl.*
import org.easysql.query.ReviseQuery
import org.easysql.query.insert.Insert
import org.easysql.query.select.Select
import org.easysql.query.select.SelectQuery

abstract class DBOperator(val db: DB) {

    abstract val queryFunc: (sql: String) -> List<List<Any?>>

    fun queryPage(query: Select<*>, pageSize: Int, pageNum: Int, fetchCount: Boolean): Page<List<Any?>> {
        val data = if (pageSize == 0) {
            listOf()
        } else {
            val sql = query.pageSql(db, pageSize, pageNum)
            queryFunc(sql)
        }
        
        val count = if (fetchCount) {
            fetchCount(query)
        } else {
            0L
        }
        
        val totalPage = if (count == 0L || pageSize == 0) {
            0
        } else {
            if (count % pageSize == 0L) {
                count / pageSize
            } else {
                count / pageSize + 1
            }
        }
        return Page(totalPage, count, data)
    }

    abstract fun run(query: ReviseQuery<*>): Int

    abstract fun runAndReturnKey(query: Insert): List<Long>

    abstract fun query(sql: String): List<Map<String, Any?>>

    @JvmName("queryTuple1")
    inline fun <reified T1> query(query: SelectQuery<Tuple1<T1>>): List<T1> =
        queryFunc(query.sql(db)).map { Bind.bindTuple1(it)!! }

    @JvmName("queryTuple2")
    inline fun <reified T1, reified T2> query(query: SelectQuery<Tuple2<T1, T2>>): List<Tuple2<T1?, T2?>> =
        queryFunc(query.sql(db)).map { Bind.bindTuple2(it) }

    @JvmName("queryTuple3")
    inline fun <reified T1, reified T2, reified T3> query(query: SelectQuery<Tuple3<T1, T2, T3>>): List<Tuple3<T1?, T2?, T3?>> =
        queryFunc(query.sql(db)).map { Bind.bindTuple3(it) }

    @JvmName("queryTuple4")
    inline fun <reified T1, reified T2, reified T3, reified T4> query(query: SelectQuery<Tuple4<T1, T2, T3, T4>>): List<Tuple4<T1?, T2?, T3?, T4?>> =
        queryFunc(query.sql(db)).map { Bind.bindTuple4(it) }

    @JvmName("queryTuple5")
    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5> query(query: SelectQuery<Tuple5<T1, T2, T3, T4, T5>>): List<Tuple5<T1?, T2?, T3?, T4?, T5?>> =
        queryFunc(query.sql(db)).map { Bind.bindTuple5(it) }

    @JvmName("queryTuple6")
    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6> query(query: SelectQuery<Tuple6<T1, T2, T3, T4, T5, T6>>): List<Tuple6<T1?, T2?, T3?, T4?, T5?, T6?>> =
        queryFunc(query.sql(db)).map { Bind.bindTuple6(it) }

    @JvmName("queryTuple7")
    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7> query(query: SelectQuery<Tuple7<T1, T2, T3, T4, T5, T6, T7>>): List<Tuple7<T1?, T2?, T3?, T4?, T5?, T6?, T7?>> =
        queryFunc(query.sql(db)).map { Bind.bindTuple7(it) }

    @JvmName("queryTuple8")
    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8> query(
        query: SelectQuery<Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>>
    ): List<Tuple8<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?>> =
        queryFunc(query.sql(db)).map { Bind.bindTuple8(it) }

    @JvmName("queryTuple9")
    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9> query(
        query: SelectQuery<Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>>
    ): List<Tuple9<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?>> =
        queryFunc(query.sql(db)).map { Bind.bindTuple9(it) }

    @JvmName("queryTuple10")
    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10> query(
        query: SelectQuery<Tuple10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>>
    ): List<Tuple10<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?>> =
        queryFunc(query.sql(db)).map { Bind.bindTuple10(it) }

    @JvmName("queryTuple11")
    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11> query(
        query: SelectQuery<Tuple11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>>
    ): List<Tuple11<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?>> =
        queryFunc(query.sql(db)).map { Bind.bindTuple11(it) }

    @JvmName("queryTuple12")
    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12> query(
        query: SelectQuery<Tuple12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>>
    ): List<Tuple12<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?>> =
        queryFunc(query.sql(db)).map { Bind.bindTuple12(it) }

    @JvmName("queryTuple13")
    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13> query(
        query: SelectQuery<Tuple13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>>
    ): List<Tuple13<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?>> =
        queryFunc(query.sql(db)).map { Bind.bindTuple13(it) }

    @JvmName("queryTuple14")
    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14> query(
        query: SelectQuery<Tuple14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>>
    ): List<Tuple14<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?>> =
        queryFunc(query.sql(db)).map { Bind.bindTuple14(it) }

    @JvmName("queryTuple15")
    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14, reified T15> query(
        query: SelectQuery<Tuple15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>>
    ): List<Tuple15<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?, T15?>> =
        queryFunc(query.sql(db)).map { Bind.bindTuple15(it) }

    @JvmName("queryTuple16")
    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14, reified T15, reified T16> query(
        query: SelectQuery<Tuple16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>>
    ): List<Tuple16<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?, T15?, T16?>> =
        queryFunc(query.sql(db)).map { Bind.bindTuple16(it) }

    @JvmName("queryTuple17")
    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14, reified T15, reified T16, reified T17> query(
        query: SelectQuery<Tuple17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>>
    ): List<Tuple17<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?, T15?, T16?, T17?>> =
        queryFunc(query.sql(db)).map { Bind.bindTuple17(it) }

    @JvmName("queryTuple18")
    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14, reified T15, reified T16, reified T17, reified T18> query(
        query: SelectQuery<Tuple18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>>
    ): List<Tuple18<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?, T15?, T16?, T17?, T18?>> =
        queryFunc(query.sql(db)).map { Bind.bindTuple18(it) }

    @JvmName("queryTuple19")
    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14, reified T15, reified T16, reified T17, reified T18, reified T19> query(
        query: SelectQuery<Tuple19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>>
    ): List<Tuple19<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?, T15?, T16?, T17?, T18?, T19?>> =
        queryFunc(query.sql(db)).map { Bind.bindTuple19(it) }

    @JvmName("queryTuple20")
    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14, reified T15, reified T16, reified T17, reified T18, reified T19, reified T20> query(
        query: SelectQuery<Tuple20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>>
    ): List<Tuple20<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?, T15?, T16?, T17?, T18?, T19?, T20?>> =
        queryFunc(query.sql(db)).map { Bind.bindTuple20(it) }

    @JvmName("queryTuple21")
    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14, reified T15, reified T16, reified T17, reified T18, reified T19, reified T20, reified T21> query(
        query: SelectQuery<Tuple21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>>
    ): List<Tuple21<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?, T15?, T16?, T17?, T18?, T19?, T20?, T21?>> =
        queryFunc(query.sql(db)).map { Bind.bindTuple21(it) }

    @JvmName("queryTuple22")
    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14, reified T15, reified T16, reified T17, reified T18, reified T19, reified T20, reified T21, reified T22> query(
        query: SelectQuery<Tuple22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>>
    ): List<Tuple22<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?, T15?, T16?, T17?, T18?, T19?, T20?, T21?, T22?>> =
        queryFunc(query.sql(db)).map { Bind.bindTuple22(it) }

    @JvmName("findTuple1")
    inline fun <reified T1> find(query: Select<Tuple1<T1>>): T1? =
        queryFunc(query.limit(1).sql(db)).map { Bind.bindTuple1<T1>(it) }.firstOrNull()

    @JvmName("findTuple2")
    inline fun <reified T1, reified T2> find(query: Select<Tuple2<T1, T2>>): Tuple2<T1?, T2?>? =
        queryFunc(query.limit(1).sql(db)).map { Bind.bindTuple2<T1, T2>(it) }.firstOrNull()

    @JvmName("findTuple3")
    inline fun <reified T1, reified T2, reified T3> find(query: Select<Tuple3<T1, T2, T3>>): Tuple3<T1?, T2?, T3?>? =
        queryFunc(query.limit(1).sql(db)).map { Bind.bindTuple3<T1, T2, T3>(it) }.firstOrNull()

    @JvmName("findTuple4")
    inline fun <reified T1, reified T2, reified T3, reified T4> find(query: Select<Tuple4<T1, T2, T3, T4>>): Tuple4<T1?, T2?, T3?, T4?>? =
        queryFunc(query.limit(1).sql(db)).map { Bind.bindTuple4<T1, T2, T3, T4>(it) }.firstOrNull()

    @JvmName("findTuple5")
    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5> find(query: Select<Tuple5<T1, T2, T3, T4, T5>>): Tuple5<T1?, T2?, T3?, T4?, T5?>? =
        queryFunc(query.limit(1).sql(db)).map { Bind.bindTuple5<T1, T2, T3, T4, T5>(it) }.firstOrNull()

    @JvmName("findTuple6")
    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6> find(query: Select<Tuple6<T1, T2, T3, T4, T5, T6>>): Tuple6<T1?, T2?, T3?, T4?, T5?, T6?>? =
        queryFunc(query.limit(1).sql(db)).map { Bind.bindTuple6<T1, T2, T3, T4, T5, T6>(it) }.firstOrNull()

    @JvmName("findTuple7")
    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7> find(query: Select<Tuple7<T1, T2, T3, T4, T5, T6, T7>>): Tuple7<T1?, T2?, T3?, T4?, T5?, T6?, T7?>? =
        queryFunc(query.limit(1).sql(db)).map { Bind.bindTuple7<T1, T2, T3, T4, T5, T6, T7>(it) }.firstOrNull()

    @JvmName("findTuple8")
    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8> find(
        query: Select<Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>>
    ): Tuple8<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?>? =
        queryFunc(query.limit(1).sql(db)).map { Bind.bindTuple8<T1, T2, T3, T4, T5, T6, T7, T8>(it) }.firstOrNull()

    @JvmName("findTuple9")
    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9> find(
        query: Select<Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>>
    ): Tuple9<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?>? =
        queryFunc(query.limit(1).sql(db)).map { Bind.bindTuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>(it) }.firstOrNull()

    @JvmName("findTuple10")
    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10> find(
        query: Select<Tuple10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>>
    ): Tuple10<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?>? =
        queryFunc(query.limit(1).sql(db)).map { Bind.bindTuple10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>(it) }.firstOrNull()

    @JvmName("findTuple11")
    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11> find(
        query: Select<Tuple11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>>
    ): Tuple11<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?>? =
        queryFunc(query.limit(1).sql(db)).map { Bind.bindTuple11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>(it) }
            .firstOrNull()

    @JvmName("findTuple12")
    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12> find(
        query: Select<Tuple12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>>
    ): Tuple12<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?>? =
        queryFunc(query.limit(1).sql(db)).map { Bind.bindTuple12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>(it) }
            .firstOrNull()

    @JvmName("findTuple13")
    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13> find(
        query: Select<Tuple13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>>
    ): Tuple13<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?>? =
        queryFunc(query.limit(1).sql(db)).map { Bind.bindTuple13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>(it) }
            .firstOrNull()

    @JvmName("findTuple14")
    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14> find(
        query: Select<Tuple14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>>
    ): Tuple14<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?>? =
        queryFunc(query.limit(1).sql(db)).map { Bind.bindTuple14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>(it) }
            .firstOrNull()

    @JvmName("findTuple15")
    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14, reified T15> find(
        query: Select<Tuple15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>>
    ): Tuple15<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?, T15?>? =
        queryFunc(query.limit(1).sql(db)).map {
            Bind.bindTuple15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>(
                it
            )
        }
            .firstOrNull()

    @JvmName("findTuple16")
    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14, reified T15, reified T16> find(
        query: Select<Tuple16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>>
    ): Tuple16<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?, T15?, T16?>? =
        queryFunc(query.limit(1).sql(db)).map {
            Bind.bindTuple16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>(
                it
            )
        }.firstOrNull()

    @JvmName("findTuple17")
    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14, reified T15, reified T16, reified T17> find(
        query: Select<Tuple17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>>
    ): Tuple17<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?, T15?, T16?, T17?>? =
        queryFunc(query.limit(1).sql(db)).map {
            Bind.bindTuple17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>(
                it
            )
        }.firstOrNull()

    @JvmName("findTuple18")
    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14, reified T15, reified T16, reified T17, reified T18> find(
        query: Select<Tuple18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>>
    ): Tuple18<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?, T15?, T16?, T17?, T18?>? =
        queryFunc(query.limit(1).sql(db)).map {
            Bind.bindTuple18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>(
                it
            )
        }.firstOrNull()

    @JvmName("findTuple19")
    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14, reified T15, reified T16, reified T17, reified T18, reified T19> find(
        query: Select<Tuple19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>>
    ): Tuple19<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?, T15?, T16?, T17?, T18?, T19?>? =
        queryFunc(query.limit(1).sql(db)).map {
            Bind.bindTuple19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>(
                it
            )
        }.firstOrNull()

    @JvmName("findTuple20")
    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14, reified T15, reified T16, reified T17, reified T18, reified T19, reified T20> find(
        query: Select<Tuple20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>>
    ): Tuple20<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?, T15?, T16?, T17?, T18?, T19?, T20?>? =
        queryFunc(query.limit(1).sql(db)).map {
            Bind.bindTuple20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>(
                it
            )
        }.firstOrNull()

    @JvmName("findTuple21")
    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14, reified T15, reified T16, reified T17, reified T18, reified T19, reified T20, reified T21> find(
        query: Select<Tuple21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>>
    ): Tuple21<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?, T15?, T16?, T17?, T18?, T19?, T20?, T21?>? =
        queryFunc(query.limit(1).sql(db)).map {
            Bind.bindTuple21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>(
                it
            )
        }.firstOrNull()

    @JvmName("findTuple22")
    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14, reified T15, reified T16, reified T17, reified T18, reified T19, reified T20, reified T21, reified T22> find(
        query: Select<Tuple22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>>
    ): Tuple22<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?, T15?, T16?, T17?, T18?, T19?, T20?, T21?, T22?>? =
        queryFunc(query.limit(1).sql(db)).map {
            Bind.bindTuple22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>(
                it
            )
        }.firstOrNull()

    @JvmName("pageTuple1")
    inline fun <reified T1> page(
        query: Select<Tuple1<T1>>,
        pageSize: Int,
        pageNum: Int,
        fetchCount: Boolean
    ): Page<T1> = queryPage(query, pageSize, pageNum, fetchCount).map { Bind.bindTuple1(it)!! }

    @JvmName("pageTuple2")
    inline fun <reified T1, reified T2> page(
        query: Select<Tuple2<T1, T2>>,
        pageSize: Int,
        pageNum: Int,
        fetchCount: Boolean
    ): Page<Tuple2<T1?, T2?>> = queryPage(query, pageSize, pageNum, fetchCount).map { Bind.bindTuple2(it) }

    @JvmName("pageTuple3")
    inline fun <reified T1, reified T2, reified T3> page(
        query: Select<Tuple3<T1, T2, T3>>,
        pageSize: Int,
        pageNum: Int,
        fetchCount: Boolean
    ): Page<Tuple3<T1?, T2?, T3?>> =
        queryPage(query, pageSize, pageNum, fetchCount).map { Bind.bindTuple3(it) }

    @JvmName("pageTuple4")
    inline fun <reified T1, reified T2, reified T3, reified T4> page(
        query: Select<Tuple4<T1, T2, T3, T4>>,
        pageSize: Int,
        pageNum: Int,
        fetchCount: Boolean
    ): Page<Tuple4<T1?, T2?, T3?, T4?>> =
        queryPage(query, pageSize, pageNum, fetchCount).map { Bind.bindTuple4(it) }

    @JvmName("pageTuple5")
    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5> page(
        query: Select<Tuple5<T1, T2, T3, T4, T5>>,
        pageSize: Int,
        pageNum: Int,
        fetchCount: Boolean
    ): Page<Tuple5<T1?, T2?, T3?, T4?, T5?>> =
        queryPage(query, pageSize, pageNum, fetchCount).map { Bind.bindTuple5(it) }

    @JvmName("pageTuple6")
    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6> page(
        query: Select<Tuple6<T1, T2, T3, T4, T5, T6>>,
        pageSize: Int,
        pageNum: Int,
        fetchCount: Boolean
    ): Page<Tuple6<T1?, T2?, T3?, T4?, T5?, T6?>> =
        queryPage(query, pageSize, pageNum, fetchCount).map { Bind.bindTuple6(it) }

    @JvmName("pageTuple7")
    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7> page(
        query: Select<Tuple7<T1, T2, T3, T4, T5, T6, T7>>,
        pageSize: Int,
        pageNum: Int,
        fetchCount: Boolean
    ): Page<Tuple7<T1?, T2?, T3?, T4?, T5?, T6?, T7?>> =
        queryPage(query, pageSize, pageNum, fetchCount).map { Bind.bindTuple7(it) }

    @JvmName("pageTuple8")
    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8> page(
        query: Select<Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>>, pageSize: Int, pageNum: Int, fetchCount: Boolean
    ): Page<Tuple8<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?>> =
        queryPage(query, pageSize, pageNum, fetchCount).map { Bind.bindTuple8(it) }

    @JvmName("pageTuple9")
    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9> page(
        query: Select<Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>>, pageSize: Int, pageNum: Int, fetchCount: Boolean
    ): Page<Tuple9<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?>> =
        queryPage(query, pageSize, pageNum, fetchCount).map { Bind.bindTuple9(it) }

    @JvmName("pageTuple10")
    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10> page(
        query: Select<Tuple10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>>,
        pageSize: Int,
        pageNum: Int,
        fetchCount: Boolean
    ): Page<Tuple10<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?>> =
        queryPage(query, pageSize, pageNum, fetchCount).map { Bind.bindTuple10(it) }

    @JvmName("pageTuple11")
    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11> page(
        query: Select<Tuple11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>>,
        pageSize: Int,
        pageNum: Int,
        fetchCount: Boolean
    ): Page<Tuple11<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?>> =
        queryPage(query, pageSize, pageNum, fetchCount).map { Bind.bindTuple11(it) }

    @JvmName("pageTuple12")
    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12> page(
        query: Select<Tuple12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>>,
        pageSize: Int,
        pageNum: Int,
        fetchCount: Boolean
    ): Page<Tuple12<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?>> =
        queryPage(query, pageSize, pageNum, fetchCount).map { Bind.bindTuple12(it) }

    @JvmName("pageTuple13")
    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13> page(
        query: Select<Tuple13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>>,
        pageSize: Int,
        pageNum: Int,
        fetchCount: Boolean
    ): Page<Tuple13<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?>> =
        queryPage(query, pageSize, pageNum, fetchCount).map { Bind.bindTuple13(it) }

    @JvmName("pageTuple14")
    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14> page(
        query: Select<Tuple14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>>,
        pageSize: Int,
        pageNum: Int,
        fetchCount: Boolean
    ): Page<Tuple14<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?>> =
        queryPage(query, pageSize, pageNum, fetchCount).map { Bind.bindTuple14(it) }

    @JvmName("pageTuple15")
    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14, reified T15> page(
        query: Select<Tuple15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>>,
        pageSize: Int,
        pageNum: Int,
        fetchCount: Boolean
    ): Page<Tuple15<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?, T15?>> =
        queryPage(query, pageSize, pageNum, fetchCount).map { Bind.bindTuple15(it) }

    @JvmName("pageTuple16")
    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14, reified T15, reified T16> page(
        query: Select<Tuple16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>>,
        pageSize: Int,
        pageNum: Int,
        fetchCount: Boolean
    ): Page<Tuple16<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?, T15?, T16?>> =
        queryPage(query, pageSize, pageNum, fetchCount).map { Bind.bindTuple16(it) }

    @JvmName("pageTuple17")
    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14, reified T15, reified T16, reified T17> page(
        query: Select<Tuple17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>>,
        pageSize: Int,
        pageNum: Int,
        fetchCount: Boolean
    ): Page<Tuple17<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?, T15?, T16?, T17?>> =
        queryPage(query, pageSize, pageNum, fetchCount).map { Bind.bindTuple17(it) }

    @JvmName("pageTuple18")
    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14, reified T15, reified T16, reified T17, reified T18> page(
        query: Select<Tuple18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>>,
        pageSize: Int,
        pageNum: Int,
        fetchCount: Boolean
    ): Page<Tuple18<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?, T15?, T16?, T17?, T18?>> =
        queryPage(query, pageSize, pageNum, fetchCount).map { Bind.bindTuple18(it) }

    @JvmName("pageTuple19")
    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14, reified T15, reified T16, reified T17, reified T18, reified T19> page(
        query: Select<Tuple19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>>,
        pageSize: Int,
        pageNum: Int,
        fetchCount: Boolean
    ): Page<Tuple19<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?, T15?, T16?, T17?, T18?, T19?>> =
        queryPage(query, pageSize, pageNum, fetchCount).map { Bind.bindTuple19(it) }

    @JvmName("pageTuple20")
    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14, reified T15, reified T16, reified T17, reified T18, reified T19, reified T20> page(
        query: Select<Tuple20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>>,
        pageSize: Int,
        pageNum: Int,
        fetchCount: Boolean
    ): Page<Tuple20<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?, T15?, T16?, T17?, T18?, T19?, T20?>> =
        queryPage(query, pageSize, pageNum, fetchCount).map { Bind.bindTuple20(it) }

    @JvmName("pageTuple21")
    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14, reified T15, reified T16, reified T17, reified T18, reified T19, reified T20, reified T21> page(
        query: Select<Tuple21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>>,
        pageSize: Int,
        pageNum: Int,
        fetchCount: Boolean
    ): Page<Tuple21<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?, T15?, T16?, T17?, T18?, T19?, T20?, T21?>> =
        queryPage(query, pageSize, pageNum, fetchCount).map { Bind.bindTuple21(it) }

    @JvmName("pageTuple22")
    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14, reified T15, reified T16, reified T17, reified T18, reified T19, reified T20, reified T21, reified T22> page(
        query: Select<Tuple22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>>,
        pageSize: Int,
        pageNum: Int,
        fetchCount: Boolean
    ): Page<Tuple22<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?, T15?, T16?, T17?, T18?, T19?, T20?, T21?, T22?>> =
        queryPage(query, pageSize, pageNum, fetchCount).map { Bind.bindTuple22(it) }

    abstract fun fetchCount(query: Select<*>): Long
}

object Bind {
    inline fun <reified T> bindEntity(nextIndex: Int, data: List<Any?>): Pair<Int, T?> {
        val clazz = T::class
        val constructor = clazz.constructors.first()
        val size = constructor.parameters.size
        val bindData = data.drop(nextIndex).take(constructor.parameters.size).toTypedArray()
        val isNull = bindData.map { it == null }.reduce { l, r -> l && r }

        return if (isNull) {
            nextIndex + size to null
        } else {
            nextIndex + size to constructor.call(*bindData)
        }
    }

    inline fun <reified T> bindSingleton(nextIndex: Int, data: List<Any?>): Pair<Int, T?> {
        val clazz = T::class
        return if (clazz.isData) {
            bindEntity<T>(nextIndex, data)
        } else {
            nextIndex + 1 to data[nextIndex] as T?
        }
    }

    inline fun <reified T1> bindTuple1(data: List<Any?>): T1? {
        return bindSingleton<T1>(0, data).second
    }

    inline fun <reified T1, reified T2> bindTuple2(data: List<Any?>): Tuple2<T1?, T2?> {
        val b1 = bindSingleton<T1>(0, data)
        val b2 = bindSingleton<T2>(b1.first, data)
        return Tuple2(b1.second, b2.second)
    }

    inline fun <reified T1, reified T2, reified T3> bindTuple3(data: List<Any?>): Tuple3<T1?, T2?, T3?> {
        val b1 = bindSingleton<T1>(0, data)
        val b2 = bindSingleton<T2>(b1.first, data)
        val b3 = bindSingleton<T3>(b2.first, data)
        return Tuple3(b1.second, b2.second, b3.second)
    }

    inline fun <reified T1, reified T2, reified T3, reified T4> bindTuple4(data: List<Any?>): Tuple4<T1?, T2?, T3?, T4?> {
        val b1 = bindSingleton<T1>(0, data)
        val b2 = bindSingleton<T2>(b1.first, data)
        val b3 = bindSingleton<T3>(b2.first, data)
        val b4 = bindSingleton<T4>(b3.first, data)
        return Tuple4(b1.second, b2.second, b3.second, b4.second)
    }

    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5> bindTuple5(data: List<Any?>): Tuple5<T1?, T2?, T3?, T4?, T5?> {
        val b1 = bindSingleton<T1>(0, data)
        val b2 = bindSingleton<T2>(b1.first, data)
        val b3 = bindSingleton<T3>(b2.first, data)
        val b4 = bindSingleton<T4>(b3.first, data)
        val b5 = bindSingleton<T5>(b4.first, data)
        return Tuple5(b1.second, b2.second, b3.second, b4.second, b5.second)
    }

    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6> bindTuple6(data: List<Any?>): Tuple6<T1?, T2?, T3?, T4?, T5?, T6?> {
        val b1 = bindSingleton<T1>(0, data)
        val b2 = bindSingleton<T2>(b1.first, data)
        val b3 = bindSingleton<T3>(b2.first, data)
        val b4 = bindSingleton<T4>(b3.first, data)
        val b5 = bindSingleton<T5>(b4.first, data)
        val b6 = bindSingleton<T6>(b5.first, data)
        return Tuple6(b1.second, b2.second, b3.second, b4.second, b5.second, b6.second)
    }

    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7> bindTuple7(data: List<Any?>): Tuple7<T1?, T2?, T3?, T4?, T5?, T6?, T7?> {
        val b1 = bindSingleton<T1>(0, data)
        val b2 = bindSingleton<T2>(b1.first, data)
        val b3 = bindSingleton<T3>(b2.first, data)
        val b4 = bindSingleton<T4>(b3.first, data)
        val b5 = bindSingleton<T5>(b4.first, data)
        val b6 = bindSingleton<T6>(b5.first, data)
        val b7 = bindSingleton<T7>(b6.first, data)
        return Tuple7(b1.second, b2.second, b3.second, b4.second, b5.second, b6.second, b7.second)
    }

    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8> bindTuple8(
        data: List<Any?>
    ): Tuple8<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?> {
        val b1 = bindSingleton<T1>(0, data)
        val b2 = bindSingleton<T2>(b1.first, data)
        val b3 = bindSingleton<T3>(b2.first, data)
        val b4 = bindSingleton<T4>(b3.first, data)
        val b5 = bindSingleton<T5>(b4.first, data)
        val b6 = bindSingleton<T6>(b5.first, data)
        val b7 = bindSingleton<T7>(b6.first, data)
        val b8 = bindSingleton<T8>(b7.first, data)
        return Tuple8(b1.second, b2.second, b3.second, b4.second, b5.second, b6.second, b7.second, b8.second)
    }

    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9> bindTuple9(
        data: List<Any?>
    ): Tuple9<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?> {
        val b1 = bindSingleton<T1>(0, data)
        val b2 = bindSingleton<T2>(b1.first, data)
        val b3 = bindSingleton<T3>(b2.first, data)
        val b4 = bindSingleton<T4>(b3.first, data)
        val b5 = bindSingleton<T5>(b4.first, data)
        val b6 = bindSingleton<T6>(b5.first, data)
        val b7 = bindSingleton<T7>(b6.first, data)
        val b8 = bindSingleton<T8>(b7.first, data)
        val b9 = bindSingleton<T9>(b8.first, data)
        return Tuple9(b1.second, b2.second, b3.second, b4.second, b5.second, b6.second, b7.second, b8.second, b9.second)
    }

    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10> bindTuple10(
        data: List<Any?>
    ): Tuple10<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?> {
        val b1 = bindSingleton<T1>(0, data)
        val b2 = bindSingleton<T2>(b1.first, data)
        val b3 = bindSingleton<T3>(b2.first, data)
        val b4 = bindSingleton<T4>(b3.first, data)
        val b5 = bindSingleton<T5>(b4.first, data)
        val b6 = bindSingleton<T6>(b5.first, data)
        val b7 = bindSingleton<T7>(b6.first, data)
        val b8 = bindSingleton<T8>(b7.first, data)
        val b9 = bindSingleton<T9>(b8.first, data)
        val b10 = bindSingleton<T10>(b9.first, data)
        return Tuple10(
            b1.second,
            b2.second,
            b3.second,
            b4.second,
            b5.second,
            b6.second,
            b7.second,
            b8.second,
            b9.second,
            b10.second
        )
    }

    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11> bindTuple11(
        data: List<Any?>
    ): Tuple11<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?> {
        val b1 = bindSingleton<T1>(0, data)
        val b2 = bindSingleton<T2>(b1.first, data)
        val b3 = bindSingleton<T3>(b2.first, data)
        val b4 = bindSingleton<T4>(b3.first, data)
        val b5 = bindSingleton<T5>(b4.first, data)
        val b6 = bindSingleton<T6>(b5.first, data)
        val b7 = bindSingleton<T7>(b6.first, data)
        val b8 = bindSingleton<T8>(b7.first, data)
        val b9 = bindSingleton<T9>(b8.first, data)
        val b10 = bindSingleton<T10>(b9.first, data)
        val b11 = bindSingleton<T11>(b10.first, data)
        return Tuple11(
            b1.second,
            b2.second,
            b3.second,
            b4.second,
            b5.second,
            b6.second,
            b7.second,
            b8.second,
            b9.second,
            b10.second,
            b11.second
        )
    }

    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12> bindTuple12(
        data: List<Any?>
    ): Tuple12<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?> {
        val b1 = bindSingleton<T1>(0, data)
        val b2 = bindSingleton<T2>(b1.first, data)
        val b3 = bindSingleton<T3>(b2.first, data)
        val b4 = bindSingleton<T4>(b3.first, data)
        val b5 = bindSingleton<T5>(b4.first, data)
        val b6 = bindSingleton<T6>(b5.first, data)
        val b7 = bindSingleton<T7>(b6.first, data)
        val b8 = bindSingleton<T8>(b7.first, data)
        val b9 = bindSingleton<T9>(b8.first, data)
        val b10 = bindSingleton<T10>(b9.first, data)
        val b11 = bindSingleton<T11>(b10.first, data)
        val b12 = bindSingleton<T12>(b11.first, data)
        return Tuple12(
            b1.second,
            b2.second,
            b3.second,
            b4.second,
            b5.second,
            b6.second,
            b7.second,
            b8.second,
            b9.second,
            b10.second,
            b11.second,
            b12.second
        )
    }

    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13> bindTuple13(
        data: List<Any?>
    ): Tuple13<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?> {
        val b1 = bindSingleton<T1>(0, data)
        val b2 = bindSingleton<T2>(b1.first, data)
        val b3 = bindSingleton<T3>(b2.first, data)
        val b4 = bindSingleton<T4>(b3.first, data)
        val b5 = bindSingleton<T5>(b4.first, data)
        val b6 = bindSingleton<T6>(b5.first, data)
        val b7 = bindSingleton<T7>(b6.first, data)
        val b8 = bindSingleton<T8>(b7.first, data)
        val b9 = bindSingleton<T9>(b8.first, data)
        val b10 = bindSingleton<T10>(b9.first, data)
        val b11 = bindSingleton<T11>(b10.first, data)
        val b12 = bindSingleton<T12>(b11.first, data)
        val b13 = bindSingleton<T13>(b12.first, data)
        return Tuple13(
            b1.second,
            b2.second,
            b3.second,
            b4.second,
            b5.second,
            b6.second,
            b7.second,
            b8.second,
            b9.second,
            b10.second,
            b11.second,
            b12.second,
            b13.second
        )
    }

    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14> bindTuple14(
        data: List<Any?>
    ): Tuple14<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?> {
        val b1 = bindSingleton<T1>(0, data)
        val b2 = bindSingleton<T2>(b1.first, data)
        val b3 = bindSingleton<T3>(b2.first, data)
        val b4 = bindSingleton<T4>(b3.first, data)
        val b5 = bindSingleton<T5>(b4.first, data)
        val b6 = bindSingleton<T6>(b5.first, data)
        val b7 = bindSingleton<T7>(b6.first, data)
        val b8 = bindSingleton<T8>(b7.first, data)
        val b9 = bindSingleton<T9>(b8.first, data)
        val b10 = bindSingleton<T10>(b9.first, data)
        val b11 = bindSingleton<T11>(b10.first, data)
        val b12 = bindSingleton<T12>(b11.first, data)
        val b13 = bindSingleton<T13>(b12.first, data)
        val b14 = bindSingleton<T14>(b13.first, data)
        return Tuple14(
            b1.second,
            b2.second,
            b3.second,
            b4.second,
            b5.second,
            b6.second,
            b7.second,
            b8.second,
            b9.second,
            b10.second,
            b11.second,
            b12.second,
            b13.second,
            b14.second
        )
    }

    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14, reified T15> bindTuple15(
        data: List<Any?>
    ): Tuple15<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?, T15?> {
        val b1 = bindSingleton<T1>(0, data)
        val b2 = bindSingleton<T2>(b1.first, data)
        val b3 = bindSingleton<T3>(b2.first, data)
        val b4 = bindSingleton<T4>(b3.first, data)
        val b5 = bindSingleton<T5>(b4.first, data)
        val b6 = bindSingleton<T6>(b5.first, data)
        val b7 = bindSingleton<T7>(b6.first, data)
        val b8 = bindSingleton<T8>(b7.first, data)
        val b9 = bindSingleton<T9>(b8.first, data)
        val b10 = bindSingleton<T10>(b9.first, data)
        val b11 = bindSingleton<T11>(b10.first, data)
        val b12 = bindSingleton<T12>(b11.first, data)
        val b13 = bindSingleton<T13>(b12.first, data)
        val b14 = bindSingleton<T14>(b13.first, data)
        val b15 = bindSingleton<T15>(b14.first, data)
        return Tuple15(
            b1.second,
            b2.second,
            b3.second,
            b4.second,
            b5.second,
            b6.second,
            b7.second,
            b8.second,
            b9.second,
            b10.second,
            b11.second,
            b12.second,
            b13.second,
            b14.second,
            b15.second
        )
    }

    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14, reified T15, reified T16> bindTuple16(
        data: List<Any?>
    ): Tuple16<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?, T15?, T16?> {
        val b1 = bindSingleton<T1>(0, data)
        val b2 = bindSingleton<T2>(b1.first, data)
        val b3 = bindSingleton<T3>(b2.first, data)
        val b4 = bindSingleton<T4>(b3.first, data)
        val b5 = bindSingleton<T5>(b4.first, data)
        val b6 = bindSingleton<T6>(b5.first, data)
        val b7 = bindSingleton<T7>(b6.first, data)
        val b8 = bindSingleton<T8>(b7.first, data)
        val b9 = bindSingleton<T9>(b8.first, data)
        val b10 = bindSingleton<T10>(b9.first, data)
        val b11 = bindSingleton<T11>(b10.first, data)
        val b12 = bindSingleton<T12>(b11.first, data)
        val b13 = bindSingleton<T13>(b12.first, data)
        val b14 = bindSingleton<T14>(b13.first, data)
        val b15 = bindSingleton<T15>(b14.first, data)
        val b16 = bindSingleton<T16>(b15.first, data)
        return Tuple16(
            b1.second,
            b2.second,
            b3.second,
            b4.second,
            b5.second,
            b6.second,
            b7.second,
            b8.second,
            b9.second,
            b10.second,
            b11.second,
            b12.second,
            b13.second,
            b14.second,
            b15.second,
            b16.second
        )
    }

    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14, reified T15, reified T16, reified T17> bindTuple17(
        data: List<Any?>
    ): Tuple17<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?, T15?, T16?, T17?> {
        val b1 = bindSingleton<T1>(0, data)
        val b2 = bindSingleton<T2>(b1.first, data)
        val b3 = bindSingleton<T3>(b2.first, data)
        val b4 = bindSingleton<T4>(b3.first, data)
        val b5 = bindSingleton<T5>(b4.first, data)
        val b6 = bindSingleton<T6>(b5.first, data)
        val b7 = bindSingleton<T7>(b6.first, data)
        val b8 = bindSingleton<T8>(b7.first, data)
        val b9 = bindSingleton<T9>(b8.first, data)
        val b10 = bindSingleton<T10>(b9.first, data)
        val b11 = bindSingleton<T11>(b10.first, data)
        val b12 = bindSingleton<T12>(b11.first, data)
        val b13 = bindSingleton<T13>(b12.first, data)
        val b14 = bindSingleton<T14>(b13.first, data)
        val b15 = bindSingleton<T15>(b14.first, data)
        val b16 = bindSingleton<T16>(b15.first, data)
        val b17 = bindSingleton<T17>(b16.first, data)
        return Tuple17(
            b1.second,
            b2.second,
            b3.second,
            b4.second,
            b5.second,
            b6.second,
            b7.second,
            b8.second,
            b9.second,
            b10.second,
            b11.second,
            b12.second,
            b13.second,
            b14.second,
            b15.second,
            b16.second,
            b17.second
        )
    }

    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14, reified T15, reified T16, reified T17, reified T18> bindTuple18(
        data: List<Any?>
    ): Tuple18<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?, T15?, T16?, T17?, T18?> {
        val b1 = bindSingleton<T1>(0, data)
        val b2 = bindSingleton<T2>(b1.first, data)
        val b3 = bindSingleton<T3>(b2.first, data)
        val b4 = bindSingleton<T4>(b3.first, data)
        val b5 = bindSingleton<T5>(b4.first, data)
        val b6 = bindSingleton<T6>(b5.first, data)
        val b7 = bindSingleton<T7>(b6.first, data)
        val b8 = bindSingleton<T8>(b7.first, data)
        val b9 = bindSingleton<T9>(b8.first, data)
        val b10 = bindSingleton<T10>(b9.first, data)
        val b11 = bindSingleton<T11>(b10.first, data)
        val b12 = bindSingleton<T12>(b11.first, data)
        val b13 = bindSingleton<T13>(b12.first, data)
        val b14 = bindSingleton<T14>(b13.first, data)
        val b15 = bindSingleton<T15>(b14.first, data)
        val b16 = bindSingleton<T16>(b15.first, data)
        val b17 = bindSingleton<T17>(b16.first, data)
        val b18 = bindSingleton<T18>(b17.first, data)
        return Tuple18(
            b1.second,
            b2.second,
            b3.second,
            b4.second,
            b5.second,
            b6.second,
            b7.second,
            b8.second,
            b9.second,
            b10.second,
            b11.second,
            b12.second,
            b13.second,
            b14.second,
            b15.second,
            b16.second,
            b17.second,
            b18.second
        )
    }

    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14, reified T15, reified T16, reified T17, reified T18, reified T19> bindTuple19(
        data: List<Any?>
    ): Tuple19<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?, T15?, T16?, T17?, T18?, T19?> {
        val b1 = bindSingleton<T1>(0, data)
        val b2 = bindSingleton<T2>(b1.first, data)
        val b3 = bindSingleton<T3>(b2.first, data)
        val b4 = bindSingleton<T4>(b3.first, data)
        val b5 = bindSingleton<T5>(b4.first, data)
        val b6 = bindSingleton<T6>(b5.first, data)
        val b7 = bindSingleton<T7>(b6.first, data)
        val b8 = bindSingleton<T8>(b7.first, data)
        val b9 = bindSingleton<T9>(b8.first, data)
        val b10 = bindSingleton<T10>(b9.first, data)
        val b11 = bindSingleton<T11>(b10.first, data)
        val b12 = bindSingleton<T12>(b11.first, data)
        val b13 = bindSingleton<T13>(b12.first, data)
        val b14 = bindSingleton<T14>(b13.first, data)
        val b15 = bindSingleton<T15>(b14.first, data)
        val b16 = bindSingleton<T16>(b15.first, data)
        val b17 = bindSingleton<T17>(b16.first, data)
        val b18 = bindSingleton<T18>(b17.first, data)
        val b19 = bindSingleton<T19>(b18.first, data)
        return Tuple19(
            b1.second,
            b2.second,
            b3.second,
            b4.second,
            b5.second,
            b6.second,
            b7.second,
            b8.second,
            b9.second,
            b10.second,
            b11.second,
            b12.second,
            b13.second,
            b14.second,
            b15.second,
            b16.second,
            b17.second,
            b18.second,
            b19.second
        )
    }

    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14, reified T15, reified T16, reified T17, reified T18, reified T19, reified T20> bindTuple20(
        data: List<Any?>
    ): Tuple20<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?, T15?, T16?, T17?, T18?, T19?, T20?> {
        val b1 = bindSingleton<T1>(0, data)
        val b2 = bindSingleton<T2>(b1.first, data)
        val b3 = bindSingleton<T3>(b2.first, data)
        val b4 = bindSingleton<T4>(b3.first, data)
        val b5 = bindSingleton<T5>(b4.first, data)
        val b6 = bindSingleton<T6>(b5.first, data)
        val b7 = bindSingleton<T7>(b6.first, data)
        val b8 = bindSingleton<T8>(b7.first, data)
        val b9 = bindSingleton<T9>(b8.first, data)
        val b10 = bindSingleton<T10>(b9.first, data)
        val b11 = bindSingleton<T11>(b10.first, data)
        val b12 = bindSingleton<T12>(b11.first, data)
        val b13 = bindSingleton<T13>(b12.first, data)
        val b14 = bindSingleton<T14>(b13.first, data)
        val b15 = bindSingleton<T15>(b14.first, data)
        val b16 = bindSingleton<T16>(b15.first, data)
        val b17 = bindSingleton<T17>(b16.first, data)
        val b18 = bindSingleton<T18>(b17.first, data)
        val b19 = bindSingleton<T19>(b18.first, data)
        val b20 = bindSingleton<T20>(b19.first, data)
        return Tuple20(
            b1.second,
            b2.second,
            b3.second,
            b4.second,
            b5.second,
            b6.second,
            b7.second,
            b8.second,
            b9.second,
            b10.second,
            b11.second,
            b12.second,
            b13.second,
            b14.second,
            b15.second,
            b16.second,
            b17.second,
            b18.second,
            b19.second,
            b20.second
        )
    }

    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14, reified T15, reified T16, reified T17, reified T18, reified T19, reified T20, reified T21> bindTuple21(
        data: List<Any?>
    ): Tuple21<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?, T15?, T16?, T17?, T18?, T19?, T20?, T21?> {
        val b1 = bindSingleton<T1>(0, data)
        val b2 = bindSingleton<T2>(b1.first, data)
        val b3 = bindSingleton<T3>(b2.first, data)
        val b4 = bindSingleton<T4>(b3.first, data)
        val b5 = bindSingleton<T5>(b4.first, data)
        val b6 = bindSingleton<T6>(b5.first, data)
        val b7 = bindSingleton<T7>(b6.first, data)
        val b8 = bindSingleton<T8>(b7.first, data)
        val b9 = bindSingleton<T9>(b8.first, data)
        val b10 = bindSingleton<T10>(b9.first, data)
        val b11 = bindSingleton<T11>(b10.first, data)
        val b12 = bindSingleton<T12>(b11.first, data)
        val b13 = bindSingleton<T13>(b12.first, data)
        val b14 = bindSingleton<T14>(b13.first, data)
        val b15 = bindSingleton<T15>(b14.first, data)
        val b16 = bindSingleton<T16>(b15.first, data)
        val b17 = bindSingleton<T17>(b16.first, data)
        val b18 = bindSingleton<T18>(b17.first, data)
        val b19 = bindSingleton<T19>(b18.first, data)
        val b20 = bindSingleton<T20>(b19.first, data)
        val b21 = bindSingleton<T21>(b20.first, data)
        return Tuple21(
            b1.second,
            b2.second,
            b3.second,
            b4.second,
            b5.second,
            b6.second,
            b7.second,
            b8.second,
            b9.second,
            b10.second,
            b11.second,
            b12.second,
            b13.second,
            b14.second,
            b15.second,
            b16.second,
            b17.second,
            b18.second,
            b19.second,
            b20.second,
            b21.second
        )
    }

    inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14, reified T15, reified T16, reified T17, reified T18, reified T19, reified T20, reified T21, reified T22> bindTuple22(
        data: List<Any?>
    ): Tuple22<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?, T15?, T16?, T17?, T18?, T19?, T20?, T21?, T22?> {
        val b1 = bindSingleton<T1>(0, data)
        val b2 = bindSingleton<T2>(b1.first, data)
        val b3 = bindSingleton<T3>(b2.first, data)
        val b4 = bindSingleton<T4>(b3.first, data)
        val b5 = bindSingleton<T5>(b4.first, data)
        val b6 = bindSingleton<T6>(b5.first, data)
        val b7 = bindSingleton<T7>(b6.first, data)
        val b8 = bindSingleton<T8>(b7.first, data)
        val b9 = bindSingleton<T9>(b8.first, data)
        val b10 = bindSingleton<T10>(b9.first, data)
        val b11 = bindSingleton<T11>(b10.first, data)
        val b12 = bindSingleton<T12>(b11.first, data)
        val b13 = bindSingleton<T13>(b12.first, data)
        val b14 = bindSingleton<T14>(b13.first, data)
        val b15 = bindSingleton<T15>(b14.first, data)
        val b16 = bindSingleton<T16>(b15.first, data)
        val b17 = bindSingleton<T17>(b16.first, data)
        val b18 = bindSingleton<T18>(b17.first, data)
        val b19 = bindSingleton<T19>(b18.first, data)
        val b20 = bindSingleton<T20>(b19.first, data)
        val b21 = bindSingleton<T21>(b20.first, data)
        val b22 = bindSingleton<T22>(b21.first, data)
        return Tuple22(
            b1.second,
            b2.second,
            b3.second,
            b4.second,
            b5.second,
            b6.second,
            b7.second,
            b8.second,
            b9.second,
            b10.second,
            b11.second,
            b12.second,
            b13.second,
            b14.second,
            b15.second,
            b16.second,
            b17.second,
            b18.second,
            b19.second,
            b20.second,
            b21.second,
            b22.second
        )
    }
}