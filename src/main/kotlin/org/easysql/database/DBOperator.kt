package org.easysql.database

import org.easysql.dsl.*
import org.easysql.query.ReviseQuery
import org.easysql.query.insert.Insert
import org.easysql.query.select.Select
import org.easysql.query.select.SelectQuery

// todo
sealed class DBOperator {
    fun run(query: ReviseQuery<*>): Int = 0

    fun runAndReturnKey(query: Insert): List<Long> = listOf()

    fun query(sql: String): List<Map<String, Any?>> = listOf()

    @JvmName("queryTuple1")
    fun <T1> query(query: SelectQuery<Tuple1<T1>>): List<T1> = listOf()

    @JvmName("queryTuple2")
    fun <T1, T2> query(query: SelectQuery<Tuple2<T1, T2>>): List<Tuple2<T1?, T2?>> = listOf()

    @JvmName("queryTuple3")
    fun <T1, T2, T3> query(query: SelectQuery<Tuple3<T1, T2, T3>>): List<Tuple3<T1?, T2?, T3?>> = listOf()

    @JvmName("queryTuple4")
    fun <T1, T2, T3, T4> query(query: SelectQuery<Tuple4<T1, T2, T3, T4>>): List<Tuple4<T1?, T2?, T3?, T4?>> = listOf()

    @JvmName("queryTuple5")
    fun <T1, T2, T3, T4, T5> query(query: SelectQuery<Tuple5<T1, T2, T3, T4, T5>>): List<Tuple5<T1?, T2?, T3?, T4?, T5?>> =
        listOf()

    @JvmName("queryTuple6")
    fun <T1, T2, T3, T4, T5, T6> query(query: SelectQuery<Tuple6<T1, T2, T3, T4, T5, T6>>): List<Tuple6<T1?, T2?, T3?, T4?, T5?, T6?>> =
        listOf()

    @JvmName("queryTuple7")
    fun <T1, T2, T3, T4, T5, T6, T7> query(query: SelectQuery<Tuple7<T1, T2, T3, T4, T5, T6, T7>>): List<Tuple7<T1?, T2?, T3?, T4?, T5?, T6?, T7?>> =
        listOf()

    @JvmName("queryTuple8")
    fun <T1, T2, T3, T4, T5, T6, T7, T8> query(query: SelectQuery<Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>>): List<Tuple8<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?>> =
        listOf()

    @JvmName("queryTuple9")
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9> query(query: SelectQuery<Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>>): List<Tuple9<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?>> =
        listOf()

    @JvmName("queryTuple10")
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> query(query: SelectQuery<Tuple10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>>): List<Tuple10<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?>> =
        listOf()

    @JvmName("queryTuple11")
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> query(query: SelectQuery<Tuple11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>>): List<Tuple11<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?>> =
        listOf()

    @JvmName("queryTuple12")
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> query(query: SelectQuery<Tuple12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>>): List<Tuple12<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?>> =
        listOf()

    @JvmName("queryTuple13")
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> query(query: SelectQuery<Tuple13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>>): List<Tuple13<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?>> =
        listOf()

    @JvmName("queryTuple14")
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> query(query: SelectQuery<Tuple14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>>): List<Tuple14<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?>> =
        listOf()

    @JvmName("queryTuple15")
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> query(query: SelectQuery<Tuple15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>>): List<Tuple15<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?, T15?>> =
        listOf()

    @JvmName("queryTuple16")
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> query(query: SelectQuery<Tuple16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>>): List<Tuple16<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?, T15?, T16?>> =
        listOf()

    @JvmName("queryTuple17")
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> query(query: SelectQuery<Tuple17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>>): List<Tuple17<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?, T15?, T16?, T17?>> =
        listOf()

    @JvmName("queryTuple18")
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> query(query: SelectQuery<Tuple18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>>): List<Tuple18<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?, T15?, T16?, T17?, T18?>> =
        listOf()

    @JvmName("queryTuple19")
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> query(query: SelectQuery<Tuple19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>>): List<Tuple19<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?, T15?, T16?, T17?, T18?, T19?>> =
        listOf()

    @JvmName("queryTuple20")
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> query(query: SelectQuery<Tuple20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>>): List<Tuple20<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?, T15?, T16?, T17?, T18?, T19?, T20?>> =
        listOf()

    @JvmName("queryTuple21")
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> query(query: SelectQuery<Tuple21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>>): List<Tuple21<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?, T15?, T16?, T17?, T18?, T19?, T20?, T21?>> =
        listOf()

    @JvmName("queryTuple22")
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> query(
        query: SelectQuery<Tuple22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>>
    ): List<Tuple22<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?, T15?, T16?, T17?, T18?, T19?, T20?, T21?, T22?>> =
        listOf()

    @JvmName("findTuple1")
    fun <T1> find(query: SelectQuery<Tuple1<T1>>): T1? = null

    @JvmName("findTuple2")
    fun <T1, T2> find(query: SelectQuery<Tuple2<T1, T2>>): Tuple2<T1?, T2?>? = null

    @JvmName("findTuple3")
    fun <T1, T2, T3> find(query: SelectQuery<Tuple3<T1, T2, T3>>): Tuple3<T1?, T2?, T3?>? = null

    @JvmName("findTuple4")
    fun <T1, T2, T3, T4> find(query: SelectQuery<Tuple4<T1, T2, T3, T4>>): Tuple4<T1?, T2?, T3?, T4?>? = null

    @JvmName("findTuple5")
    fun <T1, T2, T3, T4, T5> find(query: SelectQuery<Tuple5<T1, T2, T3, T4, T5>>): Tuple5<T1?, T2?, T3?, T4?, T5?>? =
        null

    @JvmName("findTuple6")
    fun <T1, T2, T3, T4, T5, T6> find(query: SelectQuery<Tuple6<T1, T2, T3, T4, T5, T6>>): Tuple6<T1?, T2?, T3?, T4?, T5?, T6?>? =
        null

    @JvmName("findTuple7")
    fun <T1, T2, T3, T4, T5, T6, T7> find(query: SelectQuery<Tuple7<T1, T2, T3, T4, T5, T6, T7>>): Tuple7<T1?, T2?, T3?, T4?, T5?, T6?, T7?>? =
        null

    @JvmName("findTuple8")
    fun <T1, T2, T3, T4, T5, T6, T7, T8> find(query: SelectQuery<Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>>): Tuple8<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?>? =
        null

    @JvmName("findTuple9")
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9> find(query: SelectQuery<Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>>): Tuple9<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?>? =
        null

    @JvmName("findTuple10")
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> find(query: SelectQuery<Tuple10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>>): Tuple10<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?>? =
        null

    @JvmName("findTuple11")
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> find(query: SelectQuery<Tuple11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>>): Tuple11<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?>? =
        null

    @JvmName("findTuple12")
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> find(query: SelectQuery<Tuple12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>>): Tuple12<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?>? =
        null

    @JvmName("findTuple13")
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> find(query: SelectQuery<Tuple13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>>): Tuple13<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?>? =
        null

    @JvmName("findTuple14")
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> find(query: SelectQuery<Tuple14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>>): Tuple14<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?>? =
        null

    @JvmName("findTuple15")
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> find(query: SelectQuery<Tuple15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>>): Tuple15<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?, T15?>? =
        null

    @JvmName("findTuple16")
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> find(query: SelectQuery<Tuple16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>>): Tuple16<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?, T15?, T16?>? =
        null

    @JvmName("findTuple17")
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> find(query: SelectQuery<Tuple17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>>): Tuple17<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?, T15?, T16?, T17?>? =
        null

    @JvmName("findTuple18")
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> find(query: SelectQuery<Tuple18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>>): Tuple18<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?, T15?, T16?, T17?, T18?>? =
        null

    @JvmName("findTuple19")
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> find(query: SelectQuery<Tuple19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>>): Tuple19<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?, T15?, T16?, T17?, T18?, T19?>? =
        null

    @JvmName("findTuple20")
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> find(query: SelectQuery<Tuple20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>>): Tuple20<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?, T15?, T16?, T17?, T18?, T19?, T20?>? =
        null

    @JvmName("findTuple21")
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> find(query: SelectQuery<Tuple21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>>): Tuple21<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?, T15?, T16?, T17?, T18?, T19?, T20?, T21?>? =
        null

    @JvmName("findTuple22")
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> find(query: SelectQuery<Tuple22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>>): Tuple22<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?, T15?, T16?, T17?, T18?, T19?, T20?, T21?, T22?>? =
        null

    @JvmName("pageTuple1")
    fun <T1> page(query: SelectQuery<Tuple1<T1>>): Page<T1> = Page()

    @JvmName("pageTuple2")
    fun <T1, T2> page(query: SelectQuery<Tuple2<T1, T2>>): Page<Tuple2<T1?, T2?>> = Page()

    @JvmName("pageTuple3")
    fun <T1, T2, T3> page(query: SelectQuery<Tuple3<T1, T2, T3>>): Page<Tuple3<T1?, T2?, T3?>> = Page()

    @JvmName("pageTuple4")
    fun <T1, T2, T3, T4> page(query: SelectQuery<Tuple4<T1, T2, T3, T4>>): Page<Tuple4<T1?, T2?, T3?, T4?>> = Page()

    @JvmName("pageTuple5")
    fun <T1, T2, T3, T4, T5> page(query: SelectQuery<Tuple5<T1, T2, T3, T4, T5>>): Page<Tuple5<T1?, T2?, T3?, T4?, T5?>> =
        Page()

    @JvmName("pageTuple6")
    fun <T1, T2, T3, T4, T5, T6> page(query: SelectQuery<Tuple6<T1, T2, T3, T4, T5, T6>>): Page<Tuple6<T1?, T2?, T3?, T4?, T5?, T6?>> =
        Page()

    @JvmName("pageTuple7")
    fun <T1, T2, T3, T4, T5, T6, T7> page(query: SelectQuery<Tuple7<T1, T2, T3, T4, T5, T6, T7>>): Page<Tuple7<T1?, T2?, T3?, T4?, T5?, T6?, T7?>> =
        Page()

    @JvmName("pageTuple8")
    fun <T1, T2, T3, T4, T5, T6, T7, T8> page(query: SelectQuery<Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>>): Page<Tuple8<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?>> =
        Page()

    @JvmName("pageTuple9")
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9> page(query: SelectQuery<Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>>): Page<Tuple9<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?>> =
        Page()

    @JvmName("pageTuple10")
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> page(query: SelectQuery<Tuple10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>>): Page<Tuple10<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?>> =
        Page()

    @JvmName("pageTuple11")
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> page(query: SelectQuery<Tuple11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>>): Page<Tuple11<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?>> =
        Page()

    @JvmName("pageTuple12")
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> page(query: SelectQuery<Tuple12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>>): Page<Tuple12<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?>> =
        Page()

    @JvmName("pageTuple13")
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> page(query: SelectQuery<Tuple13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>>): Page<Tuple13<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?>> =
        Page()

    @JvmName("pageTuple14")
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> page(query: SelectQuery<Tuple14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>>): Page<Tuple14<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?>> =
        Page()

    @JvmName("pageTuple15")
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> page(query: SelectQuery<Tuple15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>>): Page<Tuple15<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?, T15?>> =
        Page()

    @JvmName("pageTuple16")
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> page(query: SelectQuery<Tuple16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>>): Page<Tuple16<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?, T15?, T16?>> =
        Page()

    @JvmName("pageTuple17")
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> page(query: SelectQuery<Tuple17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>>): Page<Tuple17<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?, T15?, T16?, T17?>> =
        Page()

    @JvmName("pageTuple18")
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> page(query: SelectQuery<Tuple18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>>): Page<Tuple18<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?, T15?, T16?, T17?, T18?>> =
        Page()

    @JvmName("pageTuple19")
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> page(query: SelectQuery<Tuple19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>>): Page<Tuple19<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?, T15?, T16?, T17?, T18?, T19?>> =
        Page()

    @JvmName("pageTuple20")
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> page(query: SelectQuery<Tuple20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>>): Page<Tuple20<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?, T15?, T16?, T17?, T18?, T19?, T20?>> =
        Page()

    @JvmName("pageTuple21")
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> page(query: SelectQuery<Tuple21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>>): Page<Tuple21<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?, T15?, T16?, T17?, T18?, T19?, T20?, T21?>> =
        Page()

    @JvmName("pageTuple22")
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> page(query: SelectQuery<Tuple22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>>): Page<Tuple22<T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?, T9?, T10?, T11?, T12?, T13?, T14?, T15?, T16?, T17?, T18?, T19?, T20?, T21?, T22?>> =
        Page()

    fun fetchCount(query: Select<*>): Long = 0L
}