package org.easysql.query.select

import org.easysql.ast.statement.select.SqlSelectQuery
import org.easysql.ast.statement.select.SqlUnionType
import org.easysql.dsl.*
import org.easysql.query.BaseQuery

abstract class SelectQuery<T : Tuple> : BaseQuery<SqlSelectQuery> {
    var aliasName: String? = null

    infix fun alias(name: String): SelectQuery<T> {
        this.aliasName = name
        return this
    }

    val aliasNames: MutableList<String> = mutableListOf()

    infix fun union(unionSelect: SelectQuery<T>): UnionSelect<T> {
        val union = UnionSelect<T>(this, SqlUnionType.UNION, unionSelect)
        union.aliasNames.clear()
        union.aliasNames.addAll(this.aliasNames)
        return union
    }

    infix fun unionAll(unionSelect: SelectQuery<T>): UnionSelect<T> {
        val union = UnionSelect<T>(this, SqlUnionType.UNION_ALL, unionSelect)
        union.aliasNames.clear()
        union.aliasNames.addAll(this.aliasNames)
        return union
    }

    infix fun except(unionSelect: SelectQuery<T>): UnionSelect<T> {
        val union = UnionSelect<T>(this, SqlUnionType.EXCEPT, unionSelect)
        union.aliasNames.clear()
        union.aliasNames.addAll(this.aliasNames)
        return union
    }

    infix fun exceptAll(unionSelect: SelectQuery<T>): UnionSelect<T> {
        val union = UnionSelect<T>(this, SqlUnionType.EXCEPT_ALL, unionSelect)
        union.aliasNames.clear()
        union.aliasNames.addAll(this.aliasNames)
        return union
    }

    infix fun intersect(unionSelect: SelectQuery<T>): UnionSelect<T> {
        val union = UnionSelect<T>(this, SqlUnionType.INTERSECT, unionSelect)
        union.aliasNames.clear()
        union.aliasNames.addAll(this.aliasNames)
        return union
    }

    infix fun intersectAll(unionSelect: SelectQuery<T>): UnionSelect<T> {
        val union = UnionSelect<T>(this, SqlUnionType.INTERSECT_ALL, unionSelect)
        union.aliasNames.clear()
        union.aliasNames.addAll(this.aliasNames)
        return union
    }
}

fun <T : Any> SelectQuery<Tuple1<T>>.toExpr() = SubQueryExpr(this, aliasName)

fun <T1 : Any> SelectQuery<Tuple1<T1>>._1() = col<T1>("${this.aliasName}.${aliasNames[0]}")

@JvmName("_1T1T2")
fun <T1 : Any, T2 : Any> SelectQuery<Tuple2<T1, T2>>._1() = col<T1>("${this.aliasName}.${aliasNames[0]}")

@JvmName("_2T1T2")
fun <T1 : Any, T2 : Any> SelectQuery<Tuple2<T1, T2>>._2() = col<T2>("${this.aliasName}.${aliasNames[1]}")

@JvmName("_1T1T2T3")
fun <T1 : Any, T2 : Any, T3 : Any> SelectQuery<Tuple3<T1, T2, T3>>._1() = col<T1>("${this.aliasName}.${aliasNames[0]}")
fun <T1 : Any, T2 : Any, T3 : Any> SelectQuery<Tuple3<T1, T2, T3>>._2() = col<T2>("${this.aliasName}.${aliasNames[1]}")
fun <T1 : Any, T2 : Any, T3 : Any> SelectQuery<Tuple3<T1, T2, T3>>._3() = col<T3>("${this.aliasName}.${aliasNames[2]}")

@JvmName("_1T1T2T3T4")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any> SelectQuery<Tuple4<T1, T2, T3, T4>>._1() = col<T1>("${this.aliasName}.${aliasNames[0]}")

@JvmName("_2T1T2T3T4")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any> SelectQuery<Tuple4<T1, T2, T3, T4>>._2() = col<T2>("${this.aliasName}.${aliasNames[1]}")

@JvmName("_3T1T2T3T4")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any> SelectQuery<Tuple4<T1, T2, T3, T4>>._3() = col<T3>("${this.aliasName}.${aliasNames[2]}")

@JvmName("_4T1T2T3T4")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any> SelectQuery<Tuple4<T1, T2, T3, T4>>._4() = col<T4>("${this.aliasName}.${aliasNames[3]}")

@JvmName("_1T1T2T3T4T5")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any> SelectQuery<Tuple5<T1, T2, T3, T4, T5>>._1() = col<T1>("${this.aliasName}.${aliasNames[0]}")

@JvmName("_2T1T2T3T4T5")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any> SelectQuery<Tuple5<T1, T2, T3, T4, T5>>._2() = col<T2>("${this.aliasName}.${aliasNames[1]}")

@JvmName("_3T1T2T3T4T5")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any> SelectQuery<Tuple5<T1, T2, T3, T4, T5>>._3() = col<T3>("${this.aliasName}.${aliasNames[2]}")

@JvmName("_4T1T2T3T4T5")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any> SelectQuery<Tuple5<T1, T2, T3, T4, T5>>._4() = col<T4>("${this.aliasName}.${aliasNames[3]}")

@JvmName("_5T1T2T3T4T5")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any> SelectQuery<Tuple5<T1, T2, T3, T4, T5>>._5() = col<T5>("${this.aliasName}.${aliasNames[4]}")

@JvmName("_1T1T2T3T4T5T6")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any> SelectQuery<Tuple6<T1, T2, T3, T4, T5, T6>>._1() =
    col<T1>("${this.aliasName}.${aliasNames[0]}")

@JvmName("_2T1T2T3T4T5T6")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any> SelectQuery<Tuple6<T1, T2, T3, T4, T5, T6>>._2() =
    col<T2>("${this.aliasName}.${aliasNames[1]}")

@JvmName("_3T1T2T3T4T5T6")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any> SelectQuery<Tuple6<T1, T2, T3, T4, T5, T6>>._3() =
    col<T3>("${this.aliasName}.${aliasNames[2]}")

@JvmName("_4T1T2T3T4T5T6")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any> SelectQuery<Tuple6<T1, T2, T3, T4, T5, T6>>._4() =
    col<T4>("${this.aliasName}.${aliasNames[3]}")

@JvmName("_5T1T2T3T4T5T6")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any> SelectQuery<Tuple6<T1, T2, T3, T4, T5, T6>>._5() =
    col<T5>("${this.aliasName}.${aliasNames[4]}")

@JvmName("_6T1T2T3T4T5T6")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any> SelectQuery<Tuple6<T1, T2, T3, T4, T5, T6>>._6() =
    col<T6>("${this.aliasName}.${aliasNames[5]}")

@JvmName("_1T1T2T3T4T5T6T7")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any> SelectQuery<Tuple7<T1, T2, T3, T4, T5, T6, T7>>._1() =
    col<T1>("${this.aliasName}.${aliasNames[0]}")

@JvmName("_2T1T2T3T4T5T6T7")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any> SelectQuery<Tuple7<T1, T2, T3, T4, T5, T6, T7>>._2() =
    col<T2>("${this.aliasName}.${aliasNames[1]}")

@JvmName("_3T1T2T3T4T5T6T7")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any> SelectQuery<Tuple7<T1, T2, T3, T4, T5, T6, T7>>._3() =
    col<T3>("${this.aliasName}.${aliasNames[2]}")

@JvmName("_4T1T2T3T4T5T6T7")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any> SelectQuery<Tuple7<T1, T2, T3, T4, T5, T6, T7>>._4() =
    col<T4>("${this.aliasName}.${aliasNames[3]}")

@JvmName("_5T1T2T3T4T5T6T7")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any> SelectQuery<Tuple7<T1, T2, T3, T4, T5, T6, T7>>._5() =
    col<T5>("${this.aliasName}.${aliasNames[4]}")

@JvmName("_6T1T2T3T4T5T6T7")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any> SelectQuery<Tuple7<T1, T2, T3, T4, T5, T6, T7>>._6() =
    col<T6>("${this.aliasName}.${aliasNames[5]}")

@JvmName("_7T1T2T3T4T5T6T7")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any> SelectQuery<Tuple7<T1, T2, T3, T4, T5, T6, T7>>._7() =
    col<T7>("${this.aliasName}.${aliasNames[6]}")

@JvmName("_1T1T2T3T4T5T6T7T8")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any> SelectQuery<Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>>._1() =
    col<T1>("${this.aliasName}.${aliasNames[0]}")

@JvmName("_2T1T2T3T4T5T6T7T8")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any> SelectQuery<Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>>._2() =
    col<T2>("${this.aliasName}.${aliasNames[1]}")

@JvmName("_3T1T2T3T4T5T6T7T8")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any> SelectQuery<Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>>._3() =
    col<T3>("${this.aliasName}.${aliasNames[2]}")

@JvmName("_4T1T2T3T4T5T6T7T8")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any> SelectQuery<Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>>._4() =
    col<T4>("${this.aliasName}.${aliasNames[3]}")

@JvmName("_5T1T2T3T4T5T6T7T8")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any> SelectQuery<Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>>._5() =
    col<T5>("${this.aliasName}.${aliasNames[4]}")

@JvmName("_6T1T2T3T4T5T6T7T8")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any> SelectQuery<Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>>._6() =
    col<T6>("${this.aliasName}.${aliasNames[5]}")

@JvmName("_7T1T2T3T4T5T6T7T8")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any> SelectQuery<Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>>._7() =
    col<T7>("${this.aliasName}.${aliasNames[6]}")

@JvmName("_8T1T2T3T4T5T6T7T8")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any> SelectQuery<Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>>._8() =
    col<T8>("${this.aliasName}.${aliasNames[7]}")

@JvmName("_1T1T2T3T4T5T6T7T8T9")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any> SelectQuery<Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>>._1() =
    col<T1>("${this.aliasName}.${aliasNames[0]}")

@JvmName("_2T1T2T3T4T5T6T7T8T9")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any> SelectQuery<Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>>._2() =
    col<T2>("${this.aliasName}.${aliasNames[1]}")

@JvmName("_3T1T2T3T4T5T6T7T8T9")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any> SelectQuery<Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>>._3() =
    col<T3>("${this.aliasName}.${aliasNames[2]}")

@JvmName("_4T1T2T3T4T5T6T7T8T9")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any> SelectQuery<Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>>._4() =
    col<T4>("${this.aliasName}.${aliasNames[3]}")

@JvmName("_5T1T2T3T4T5T6T7T8T9")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any> SelectQuery<Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>>._5() =
    col<T5>("${this.aliasName}.${aliasNames[4]}")

@JvmName("_6T1T2T3T4T5T6T7T8T9")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any> SelectQuery<Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>>._6() =
    col<T6>("${this.aliasName}.${aliasNames[5]}")

@JvmName("_7T1T2T3T4T5T6T7T8T9")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any> SelectQuery<Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>>._7() =
    col<T7>("${this.aliasName}.${aliasNames[6]}")

@JvmName("_8T1T2T3T4T5T6T7T8T9")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any> SelectQuery<Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>>._8() =
    col<T8>("${this.aliasName}.${aliasNames[7]}")

@JvmName("_9T1T2T3T4T5T6T7T8T9")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any> SelectQuery<Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>>._9() =
    col<T9>("${this.aliasName}.${aliasNames[8]}")

@JvmName("_1T1T2T3T4T5T6T7T8T9T10")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any> SelectQuery<Tuple10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>>._1() =
    col<T1>("${this.aliasName}.${aliasNames[0]}")

@JvmName("_2T1T2T3T4T5T6T7T8T9T10")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any> SelectQuery<Tuple10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>>._2() =
    col<T2>("${this.aliasName}.${aliasNames[1]}")

@JvmName("_3T1T2T3T4T5T6T7T8T9T10")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any> SelectQuery<Tuple10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>>._3() =
    col<T3>("${this.aliasName}.${aliasNames[2]}")

@JvmName("_4T1T2T3T4T5T6T7T8T9T10")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any> SelectQuery<Tuple10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>>._4() =
    col<T4>("${this.aliasName}.${aliasNames[3]}")

@JvmName("_5T1T2T3T4T5T6T7T8T9T10")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any> SelectQuery<Tuple10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>>._5() =
    col<T5>("${this.aliasName}.${aliasNames[4]}")

@JvmName("_6T1T2T3T4T5T6T7T8T9T10")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any> SelectQuery<Tuple10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>>._6() =
    col<T6>("${this.aliasName}.${aliasNames[5]}")

@JvmName("_7T1T2T3T4T5T6T7T8T9T10")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any> SelectQuery<Tuple10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>>._7() =
    col<T7>("${this.aliasName}.${aliasNames[6]}")

@JvmName("_8T1T2T3T4T5T6T7T8T9T10")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any> SelectQuery<Tuple10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>>._8() =
    col<T8>("${this.aliasName}.${aliasNames[7]}")

@JvmName("_9T1T2T3T4T5T6T7T8T9T10")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any> SelectQuery<Tuple10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>>._9() =
    col<T9>("${this.aliasName}.${aliasNames[8]}")

@JvmName("_10T1T2T3T4T5T6T7T8T9T10")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any> SelectQuery<Tuple10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>>._10() =
    col<T10>("${this.aliasName}.${aliasNames[9]}")

@JvmName("_1T1T2T3T4T5T6T7T8T9T10T11")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any> SelectQuery<Tuple11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>>._1() =
    col<T1>("${this.aliasName}.${aliasNames[0]}")

@JvmName("_2T1T2T3T4T5T6T7T8T9T10T11")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any> SelectQuery<Tuple11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>>._2() =
    col<T2>("${this.aliasName}.${aliasNames[1]}")

@JvmName("_3T1T2T3T4T5T6T7T8T9T10T11")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any> SelectQuery<Tuple11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>>._3() =
    col<T3>("${this.aliasName}.${aliasNames[2]}")

@JvmName("_4T1T2T3T4T5T6T7T8T9T10T11")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any> SelectQuery<Tuple11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>>._4() =
    col<T4>("${this.aliasName}.${aliasNames[3]}")

@JvmName("_5T1T2T3T4T5T6T7T8T9T10T11")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any> SelectQuery<Tuple11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>>._5() =
    col<T5>("${this.aliasName}.${aliasNames[4]}")

@JvmName("_6T1T2T3T4T5T6T7T8T9T10T11")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any> SelectQuery<Tuple11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>>._6() =
    col<T6>("${this.aliasName}.${aliasNames[5]}")

@JvmName("_7T1T2T3T4T5T6T7T8T9T10T11")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any> SelectQuery<Tuple11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>>._7() =
    col<T7>("${this.aliasName}.${aliasNames[6]}")

@JvmName("_8T1T2T3T4T5T6T7T8T9T10T11")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any> SelectQuery<Tuple11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>>._8() =
    col<T8>("${this.aliasName}.${aliasNames[7]}")

@JvmName("_9T1T2T3T4T5T6T7T8T9T10T11")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any> SelectQuery<Tuple11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>>._9() =
    col<T9>("${this.aliasName}.${aliasNames[8]}")

@JvmName("_10T1T2T3T4T5T6T7T8T9T10T11")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any> SelectQuery<Tuple11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>>._10() =
    col<T10>("${this.aliasName}.${aliasNames[9]}")

@JvmName("_11T1T2T3T4T5T6T7T8T9T10T11")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any> SelectQuery<Tuple11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>>._11() =
    col<T11>("${this.aliasName}.${aliasNames[10]}")

@JvmName("_1T1T2T3T4T5T6T7T8T9T10T11T12")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any> SelectQuery<Tuple12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>>._1() =
    col<T1>("${this.aliasName}.${aliasNames[0]}")

@JvmName("_2T1T2T3T4T5T6T7T8T9T10T11T12")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any> SelectQuery<Tuple12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>>._2() =
    col<T2>("${this.aliasName}.${aliasNames[1]}")

@JvmName("_3T1T2T3T4T5T6T7T8T9T10T11T12")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any> SelectQuery<Tuple12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>>._3() =
    col<T3>("${this.aliasName}.${aliasNames[2]}")

@JvmName("_4T1T2T3T4T5T6T7T8T9T10T11T12")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any> SelectQuery<Tuple12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>>._4() =
    col<T4>("${this.aliasName}.${aliasNames[3]}")

@JvmName("_5T1T2T3T4T5T6T7T8T9T10T11T12")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any> SelectQuery<Tuple12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>>._5() =
    col<T5>("${this.aliasName}.${aliasNames[4]}")

@JvmName("_6T1T2T3T4T5T6T7T8T9T10T11T12")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any> SelectQuery<Tuple12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>>._6() =
    col<T6>("${this.aliasName}.${aliasNames[5]}")

@JvmName("_7T1T2T3T4T5T6T7T8T9T10T11T12")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any> SelectQuery<Tuple12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>>._7() =
    col<T7>("${this.aliasName}.${aliasNames[6]}")

@JvmName("_8T1T2T3T4T5T6T7T8T9T10T11T12")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any> SelectQuery<Tuple12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>>._8() =
    col<T8>("${this.aliasName}.${aliasNames[7]}")

@JvmName("_9T1T2T3T4T5T6T7T8T9T10T11T12")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any> SelectQuery<Tuple12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>>._9() =
    col<T9>("${this.aliasName}.${aliasNames[8]}")

@JvmName("_10T1T2T3T4T5T6T7T8T9T10T11T12")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any> SelectQuery<Tuple12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>>._10() =
    col<T10>("${this.aliasName}.${aliasNames[9]}")

@JvmName("_11T1T2T3T4T5T6T7T8T9T10T11T12")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any> SelectQuery<Tuple12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>>._11() =
    col<T11>("${this.aliasName}.${aliasNames[10]}")

@JvmName("_12T1T2T3T4T5T6T7T8T9T10T11T12")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any> SelectQuery<Tuple12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>>._12() =
    col<T12>("${this.aliasName}.${aliasNames[11]}")

@JvmName("_1T1T2T3T4T5T6T7T8T9T10T11T12T13")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any> SelectQuery<Tuple13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>>._1() =
    col<T1>("${this.aliasName}.${aliasNames[0]}")

@JvmName("_2T1T2T3T4T5T6T7T8T9T10T11T12T13")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any> SelectQuery<Tuple13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>>._2() =
    col<T2>("${this.aliasName}.${aliasNames[1]}")

@JvmName("_3T1T2T3T4T5T6T7T8T9T10T11T12T13")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any> SelectQuery<Tuple13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>>._3() =
    col<T3>("${this.aliasName}.${aliasNames[2]}")

@JvmName("_4T1T2T3T4T5T6T7T8T9T10T11T12T13")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any> SelectQuery<Tuple13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>>._4() =
    col<T4>("${this.aliasName}.${aliasNames[3]}")

@JvmName("_5T1T2T3T4T5T6T7T8T9T10T11T12T13")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any> SelectQuery<Tuple13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>>._5() =
    col<T5>("${this.aliasName}.${aliasNames[4]}")

@JvmName("_6T1T2T3T4T5T6T7T8T9T10T11T12T13")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any> SelectQuery<Tuple13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>>._6() =
    col<T6>("${this.aliasName}.${aliasNames[5]}")

@JvmName("_7T1T2T3T4T5T6T7T8T9T10T11T12T13")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any> SelectQuery<Tuple13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>>._7() =
    col<T7>("${this.aliasName}.${aliasNames[6]}")

@JvmName("_8T1T2T3T4T5T6T7T8T9T10T11T12T13")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any> SelectQuery<Tuple13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>>._8() =
    col<T8>("${this.aliasName}.${aliasNames[7]}")

@JvmName("_9T1T2T3T4T5T6T7T8T9T10T11T12T13")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any> SelectQuery<Tuple13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>>._9() =
    col<T9>("${this.aliasName}.${aliasNames[8]}")

@JvmName("_10T1T2T3T4T5T6T7T8T9T10T11T12T13")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any> SelectQuery<Tuple13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>>._10() =
    col<T10>("${this.aliasName}.${aliasNames[9]}")

@JvmName("_11T1T2T3T4T5T6T7T8T9T10T11T12T13")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any> SelectQuery<Tuple13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>>._11() =
    col<T11>("${this.aliasName}.${aliasNames[10]}")

@JvmName("_12T1T2T3T4T5T6T7T8T9T10T11T12T13")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any> SelectQuery<Tuple13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>>._12() =
    col<T12>("${this.aliasName}.${aliasNames[11]}")

@JvmName("_13T1T2T3T4T5T6T7T8T9T10T11T12T13")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any> SelectQuery<Tuple13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>>._13() =
    col<T13>("${this.aliasName}.${aliasNames[12]}")

@JvmName("_1T1T2T3T4T5T6T7T8T9T10T11T12T13T14")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any> SelectQuery<Tuple14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>>._1() =
    col<T1>("${this.aliasName}.${aliasNames[0]}")

@JvmName("_2T1T2T3T4T5T6T7T8T9T10T11T12T13T14")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any> SelectQuery<Tuple14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>>._2() =
    col<T2>("${this.aliasName}.${aliasNames[1]}")

@JvmName("_3T1T2T3T4T5T6T7T8T9T10T11T12T13T14")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any> SelectQuery<Tuple14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>>._3() =
    col<T3>("${this.aliasName}.${aliasNames[2]}")

@JvmName("_4T1T2T3T4T5T6T7T8T9T10T11T12T13T14")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any> SelectQuery<Tuple14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>>._4() =
    col<T4>("${this.aliasName}.${aliasNames[3]}")

@JvmName("_5T1T2T3T4T5T6T7T8T9T10T11T12T13T14")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any> SelectQuery<Tuple14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>>._5() =
    col<T5>("${this.aliasName}.${aliasNames[4]}")

@JvmName("_6T1T2T3T4T5T6T7T8T9T10T11T12T13T14")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any> SelectQuery<Tuple14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>>._6() =
    col<T6>("${this.aliasName}.${aliasNames[5]}")

@JvmName("_7T1T2T3T4T5T6T7T8T9T10T11T12T13T14")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any> SelectQuery<Tuple14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>>._7() =
    col<T7>("${this.aliasName}.${aliasNames[6]}")

@JvmName("_8T1T2T3T4T5T6T7T8T9T10T11T12T13T14")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any> SelectQuery<Tuple14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>>._8() =
    col<T8>("${this.aliasName}.${aliasNames[7]}")

@JvmName("_9T1T2T3T4T5T6T7T8T9T10T11T12T13T14")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any> SelectQuery<Tuple14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>>._9() =
    col<T9>("${this.aliasName}.${aliasNames[8]}")

@JvmName("_10T1T2T3T4T5T6T7T8T9T10T11T12T13T14")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any> SelectQuery<Tuple14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>>._10() =
    col<T10>("${this.aliasName}.${aliasNames[9]}")

@JvmName("_11T1T2T3T4T5T6T7T8T9T10T11T12T13T14")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any> SelectQuery<Tuple14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>>._11() =
    col<T11>("${this.aliasName}.${aliasNames[10]}")

@JvmName("_12T1T2T3T4T5T6T7T8T9T10T11T12T13T14")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any> SelectQuery<Tuple14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>>._12() =
    col<T12>("${this.aliasName}.${aliasNames[11]}")

@JvmName("_13T1T2T3T4T5T6T7T8T9T10T11T12T13T14")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any> SelectQuery<Tuple14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>>._13() =
    col<T13>("${this.aliasName}.${aliasNames[12]}")

@JvmName("_14T1T2T3T4T5T6T7T8T9T10T11T12T13T14")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any> SelectQuery<Tuple14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>>._14() =
    col<T14>("${this.aliasName}.${aliasNames[13]}")

@JvmName("_1T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any> SelectQuery<Tuple15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>>._1() =
    col<T1>("${this.aliasName}.${aliasNames[0]}")

@JvmName("_2T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any> SelectQuery<Tuple15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>>._2() =
    col<T2>("${this.aliasName}.${aliasNames[1]}")

@JvmName("_3T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any> SelectQuery<Tuple15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>>._3() =
    col<T3>("${this.aliasName}.${aliasNames[2]}")

@JvmName("_4T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any> SelectQuery<Tuple15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>>._4() =
    col<T4>("${this.aliasName}.${aliasNames[3]}")

@JvmName("_5T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any> SelectQuery<Tuple15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>>._5() =
    col<T5>("${this.aliasName}.${aliasNames[4]}")

@JvmName("_6T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any> SelectQuery<Tuple15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>>._6() =
    col<T6>("${this.aliasName}.${aliasNames[5]}")

@JvmName("_7T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any> SelectQuery<Tuple15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>>._7() =
    col<T7>("${this.aliasName}.${aliasNames[6]}")

@JvmName("_8T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any> SelectQuery<Tuple15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>>._8() =
    col<T8>("${this.aliasName}.${aliasNames[7]}")

@JvmName("_9T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any> SelectQuery<Tuple15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>>._9() =
    col<T9>("${this.aliasName}.${aliasNames[8]}")

@JvmName("_10T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any> SelectQuery<Tuple15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>>._10() =
    col<T10>("${this.aliasName}.${aliasNames[9]}")

@JvmName("_11T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any> SelectQuery<Tuple15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>>._11() =
    col<T11>("${this.aliasName}.${aliasNames[10]}")

@JvmName("_12T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any> SelectQuery<Tuple15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>>._12() =
    col<T12>("${this.aliasName}.${aliasNames[11]}")

@JvmName("_13T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any> SelectQuery<Tuple15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>>._13() =
    col<T13>("${this.aliasName}.${aliasNames[12]}")

@JvmName("_14T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any> SelectQuery<Tuple15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>>._14() =
    col<T14>("${this.aliasName}.${aliasNames[13]}")

@JvmName("_15T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any> SelectQuery<Tuple15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>>._15() =
    col<T15>("${this.aliasName}.${aliasNames[14]}")

@JvmName("_1T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any> SelectQuery<Tuple16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>>._1() =
    col<T1>("${this.aliasName}.${aliasNames[0]}")

@JvmName("_2T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any> SelectQuery<Tuple16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>>._2() =
    col<T2>("${this.aliasName}.${aliasNames[1]}")

@JvmName("_3T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any> SelectQuery<Tuple16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>>._3() =
    col<T3>("${this.aliasName}.${aliasNames[2]}")

@JvmName("_4T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any> SelectQuery<Tuple16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>>._4() =
    col<T4>("${this.aliasName}.${aliasNames[3]}")

@JvmName("_5T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any> SelectQuery<Tuple16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>>._5() =
    col<T5>("${this.aliasName}.${aliasNames[4]}")

@JvmName("_6T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any> SelectQuery<Tuple16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>>._6() =
    col<T6>("${this.aliasName}.${aliasNames[5]}")

@JvmName("_7T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any> SelectQuery<Tuple16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>>._7() =
    col<T7>("${this.aliasName}.${aliasNames[6]}")

@JvmName("_8T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any> SelectQuery<Tuple16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>>._8() =
    col<T8>("${this.aliasName}.${aliasNames[7]}")

@JvmName("_9T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any> SelectQuery<Tuple16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>>._9() =
    col<T9>("${this.aliasName}.${aliasNames[8]}")

@JvmName("_10T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any> SelectQuery<Tuple16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>>._10() =
    col<T10>("${this.aliasName}.${aliasNames[9]}")

@JvmName("_11T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any> SelectQuery<Tuple16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>>._11() =
    col<T11>("${this.aliasName}.${aliasNames[10]}")

@JvmName("_12T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any> SelectQuery<Tuple16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>>._12() =
    col<T12>("${this.aliasName}.${aliasNames[11]}")

@JvmName("_13T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any> SelectQuery<Tuple16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>>._13() =
    col<T13>("${this.aliasName}.${aliasNames[12]}")

@JvmName("_14T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any> SelectQuery<Tuple16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>>._14() =
    col<T14>("${this.aliasName}.${aliasNames[13]}")

@JvmName("_15T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any> SelectQuery<Tuple16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>>._15() =
    col<T15>("${this.aliasName}.${aliasNames[14]}")

@JvmName("_16T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any> SelectQuery<Tuple16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>>._16() =
    col<T16>("${this.aliasName}.${aliasNames[15]}")

@JvmName("_1T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any> SelectQuery<Tuple17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>>._1() =
    col<T1>("${this.aliasName}.${aliasNames[0]}")

@JvmName("_2T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any> SelectQuery<Tuple17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>>._2() =
    col<T2>("${this.aliasName}.${aliasNames[1]}")

@JvmName("_3T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any> SelectQuery<Tuple17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>>._3() =
    col<T3>("${this.aliasName}.${aliasNames[2]}")

@JvmName("_4T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any> SelectQuery<Tuple17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>>._4() =
    col<T4>("${this.aliasName}.${aliasNames[3]}")

@JvmName("_5T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any> SelectQuery<Tuple17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>>._5() =
    col<T5>("${this.aliasName}.${aliasNames[4]}")

@JvmName("_6T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any> SelectQuery<Tuple17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>>._6() =
    col<T6>("${this.aliasName}.${aliasNames[5]}")

@JvmName("_7T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any> SelectQuery<Tuple17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>>._7() =
    col<T7>("${this.aliasName}.${aliasNames[6]}")

@JvmName("_8T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any> SelectQuery<Tuple17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>>._8() =
    col<T8>("${this.aliasName}.${aliasNames[7]}")

@JvmName("_9T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any> SelectQuery<Tuple17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>>._9() =
    col<T9>("${this.aliasName}.${aliasNames[8]}")

@JvmName("_10T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any> SelectQuery<Tuple17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>>._10() =
    col<T10>("${this.aliasName}.${aliasNames[9]}")

@JvmName("_11T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any> SelectQuery<Tuple17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>>._11() =
    col<T11>("${this.aliasName}.${aliasNames[10]}")

@JvmName("_12T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any> SelectQuery<Tuple17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>>._12() =
    col<T12>("${this.aliasName}.${aliasNames[11]}")

@JvmName("_13T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any> SelectQuery<Tuple17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>>._13() =
    col<T13>("${this.aliasName}.${aliasNames[12]}")

@JvmName("_14T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any> SelectQuery<Tuple17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>>._14() =
    col<T14>("${this.aliasName}.${aliasNames[13]}")

@JvmName("_15T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any> SelectQuery<Tuple17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>>._15() =
    col<T15>("${this.aliasName}.${aliasNames[14]}")

@JvmName("_16T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any> SelectQuery<Tuple17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>>._16() =
    col<T16>("${this.aliasName}.${aliasNames[15]}")

@JvmName("_17T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any> SelectQuery<Tuple17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>>._17() =
    col<T17>("${this.aliasName}.${aliasNames[16]}")

@JvmName("_1T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any> SelectQuery<Tuple18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>>._1() =
    col<T1>("${this.aliasName}.${aliasNames[0]}")

@JvmName("_2T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any> SelectQuery<Tuple18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>>._2() =
    col<T2>("${this.aliasName}.${aliasNames[1]}")

@JvmName("_3T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any> SelectQuery<Tuple18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>>._3() =
    col<T3>("${this.aliasName}.${aliasNames[2]}")

@JvmName("_4T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any> SelectQuery<Tuple18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>>._4() =
    col<T4>("${this.aliasName}.${aliasNames[3]}")

@JvmName("_5T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any> SelectQuery<Tuple18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>>._5() =
    col<T5>("${this.aliasName}.${aliasNames[4]}")

@JvmName("_6T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any> SelectQuery<Tuple18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>>._6() =
    col<T6>("${this.aliasName}.${aliasNames[5]}")

@JvmName("_7T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any> SelectQuery<Tuple18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>>._7() =
    col<T7>("${this.aliasName}.${aliasNames[6]}")

@JvmName("_8T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any> SelectQuery<Tuple18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>>._8() =
    col<T8>("${this.aliasName}.${aliasNames[7]}")

@JvmName("_9T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any> SelectQuery<Tuple18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>>._9() =
    col<T9>("${this.aliasName}.${aliasNames[8]}")

@JvmName("_10T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any> SelectQuery<Tuple18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>>._10() =
    col<T10>("${this.aliasName}.${aliasNames[9]}")

@JvmName("_11T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any> SelectQuery<Tuple18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>>._11() =
    col<T11>("${this.aliasName}.${aliasNames[10]}")

@JvmName("_12T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any> SelectQuery<Tuple18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>>._12() =
    col<T12>("${this.aliasName}.${aliasNames[11]}")

@JvmName("_13T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any> SelectQuery<Tuple18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>>._13() =
    col<T13>("${this.aliasName}.${aliasNames[12]}")

@JvmName("_14T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any> SelectQuery<Tuple18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>>._14() =
    col<T14>("${this.aliasName}.${aliasNames[13]}")

@JvmName("_15T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any> SelectQuery<Tuple18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>>._15() =
    col<T15>("${this.aliasName}.${aliasNames[14]}")

@JvmName("_16T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any> SelectQuery<Tuple18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>>._16() =
    col<T16>("${this.aliasName}.${aliasNames[15]}")

@JvmName("_17T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any> SelectQuery<Tuple18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>>._17() =
    col<T17>("${this.aliasName}.${aliasNames[16]}")

@JvmName("_18T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any> SelectQuery<Tuple18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>>._18() =
    col<T18>("${this.aliasName}.${aliasNames[17]}")

@JvmName("_1T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any> SelectQuery<Tuple19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>>._1() =
    col<T1>("${this.aliasName}.${aliasNames[0]}")

@JvmName("_2T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any> SelectQuery<Tuple19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>>._2() =
    col<T2>("${this.aliasName}.${aliasNames[1]}")

@JvmName("_3T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any> SelectQuery<Tuple19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>>._3() =
    col<T3>("${this.aliasName}.${aliasNames[2]}")

@JvmName("_4T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any> SelectQuery<Tuple19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>>._4() =
    col<T4>("${this.aliasName}.${aliasNames[3]}")

@JvmName("_5T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any> SelectQuery<Tuple19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>>._5() =
    col<T5>("${this.aliasName}.${aliasNames[4]}")

@JvmName("_6T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any> SelectQuery<Tuple19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>>._6() =
    col<T6>("${this.aliasName}.${aliasNames[5]}")

@JvmName("_7T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any> SelectQuery<Tuple19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>>._7() =
    col<T7>("${this.aliasName}.${aliasNames[6]}")

@JvmName("_8T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any> SelectQuery<Tuple19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>>._8() =
    col<T8>("${this.aliasName}.${aliasNames[7]}")

@JvmName("_9T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any> SelectQuery<Tuple19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>>._9() =
    col<T9>("${this.aliasName}.${aliasNames[8]}")

@JvmName("_10T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any> SelectQuery<Tuple19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>>._10() =
    col<T10>("${this.aliasName}.${aliasNames[9]}")

@JvmName("_11T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any> SelectQuery<Tuple19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>>._11() =
    col<T11>("${this.aliasName}.${aliasNames[10]}")

@JvmName("_12T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any> SelectQuery<Tuple19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>>._12() =
    col<T12>("${this.aliasName}.${aliasNames[11]}")

@JvmName("_13T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any> SelectQuery<Tuple19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>>._13() =
    col<T13>("${this.aliasName}.${aliasNames[12]}")

@JvmName("_14T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any> SelectQuery<Tuple19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>>._14() =
    col<T14>("${this.aliasName}.${aliasNames[13]}")

@JvmName("_15T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any> SelectQuery<Tuple19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>>._15() =
    col<T15>("${this.aliasName}.${aliasNames[14]}")

@JvmName("_16T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any> SelectQuery<Tuple19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>>._16() =
    col<T16>("${this.aliasName}.${aliasNames[15]}")

@JvmName("_17T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any> SelectQuery<Tuple19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>>._17() =
    col<T17>("${this.aliasName}.${aliasNames[16]}")

@JvmName("_18T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any> SelectQuery<Tuple19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>>._18() =
    col<T18>("${this.aliasName}.${aliasNames[17]}")

@JvmName("_19T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any> SelectQuery<Tuple19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>>._19() =
    col<T19>("${this.aliasName}.${aliasNames[18]}")

@JvmName("_1T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any> SelectQuery<Tuple20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>>._1() =
    col<T1>("${this.aliasName}.${aliasNames[0]}")

@JvmName("_2T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any> SelectQuery<Tuple20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>>._2() =
    col<T2>("${this.aliasName}.${aliasNames[1]}")

@JvmName("_3T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any> SelectQuery<Tuple20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>>._3() =
    col<T3>("${this.aliasName}.${aliasNames[2]}")

@JvmName("_4T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any> SelectQuery<Tuple20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>>._4() =
    col<T4>("${this.aliasName}.${aliasNames[3]}")

@JvmName("_5T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any> SelectQuery<Tuple20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>>._5() =
    col<T5>("${this.aliasName}.${aliasNames[4]}")

@JvmName("_6T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any> SelectQuery<Tuple20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>>._6() =
    col<T6>("${this.aliasName}.${aliasNames[5]}")

@JvmName("_7T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any> SelectQuery<Tuple20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>>._7() =
    col<T7>("${this.aliasName}.${aliasNames[6]}")

@JvmName("_8T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any> SelectQuery<Tuple20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>>._8() =
    col<T8>("${this.aliasName}.${aliasNames[7]}")

@JvmName("_9T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any> SelectQuery<Tuple20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>>._9() =
    col<T9>("${this.aliasName}.${aliasNames[8]}")

@JvmName("_10T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any> SelectQuery<Tuple20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>>._10() =
    col<T10>("${this.aliasName}.${aliasNames[9]}")

@JvmName("_11T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any> SelectQuery<Tuple20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>>._11() =
    col<T11>("${this.aliasName}.${aliasNames[10]}")

@JvmName("_12T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any> SelectQuery<Tuple20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>>._12() =
    col<T12>("${this.aliasName}.${aliasNames[11]}")

@JvmName("_13T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any> SelectQuery<Tuple20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>>._13() =
    col<T13>("${this.aliasName}.${aliasNames[12]}")

@JvmName("_14T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any> SelectQuery<Tuple20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>>._14() =
    col<T14>("${this.aliasName}.${aliasNames[13]}")

@JvmName("_15T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any> SelectQuery<Tuple20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>>._15() =
    col<T15>("${this.aliasName}.${aliasNames[14]}")

@JvmName("_16T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any> SelectQuery<Tuple20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>>._16() =
    col<T16>("${this.aliasName}.${aliasNames[15]}")

@JvmName("_17T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any> SelectQuery<Tuple20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>>._17() =
    col<T17>("${this.aliasName}.${aliasNames[16]}")

@JvmName("_18T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any> SelectQuery<Tuple20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>>._18() =
    col<T18>("${this.aliasName}.${aliasNames[17]}")

@JvmName("_19T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any> SelectQuery<Tuple20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>>._19() =
    col<T19>("${this.aliasName}.${aliasNames[18]}")

@JvmName("_20T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any> SelectQuery<Tuple20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>>._20() =
    col<T20>("${this.aliasName}.${aliasNames[19]}")

@JvmName("_1T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20T21")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any, T21 : Any> SelectQuery<Tuple21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>>._1() =
    col<T1>("${this.aliasName}.${aliasNames[0]}")

@JvmName("_2T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20T21")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any, T21 : Any> SelectQuery<Tuple21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>>._2() =
    col<T2>("${this.aliasName}.${aliasNames[1]}")

@JvmName("_3T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20T21")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any, T21 : Any> SelectQuery<Tuple21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>>._3() =
    col<T3>("${this.aliasName}.${aliasNames[2]}")

@JvmName("_4T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20T21")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any, T21 : Any> SelectQuery<Tuple21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>>._4() =
    col<T4>("${this.aliasName}.${aliasNames[3]}")

@JvmName("_5T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20T21")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any, T21 : Any> SelectQuery<Tuple21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>>._5() =
    col<T5>("${this.aliasName}.${aliasNames[4]}")

@JvmName("_6T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20T21")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any, T21 : Any> SelectQuery<Tuple21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>>._6() =
    col<T6>("${this.aliasName}.${aliasNames[5]}")

@JvmName("_7T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20T21")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any, T21 : Any> SelectQuery<Tuple21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>>._7() =
    col<T7>("${this.aliasName}.${aliasNames[6]}")

@JvmName("_8T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20T21")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any, T21 : Any> SelectQuery<Tuple21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>>._8() =
    col<T8>("${this.aliasName}.${aliasNames[7]}")

@JvmName("_9T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20T21")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any, T21 : Any> SelectQuery<Tuple21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>>._9() =
    col<T9>("${this.aliasName}.${aliasNames[8]}")

@JvmName("_10T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20T21")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any, T21 : Any> SelectQuery<Tuple21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>>._10() =
    col<T10>("${this.aliasName}.${aliasNames[9]}")

@JvmName("_11T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20T21")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any, T21 : Any> SelectQuery<Tuple21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>>._11() =
    col<T11>("${this.aliasName}.${aliasNames[10]}")

@JvmName("_12T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20T21")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any, T21 : Any> SelectQuery<Tuple21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>>._12() =
    col<T12>("${this.aliasName}.${aliasNames[11]}")

@JvmName("_13T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20T21")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any, T21 : Any> SelectQuery<Tuple21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>>._13() =
    col<T13>("${this.aliasName}.${aliasNames[12]}")

@JvmName("_14T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20T21")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any, T21 : Any> SelectQuery<Tuple21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>>._14() =
    col<T14>("${this.aliasName}.${aliasNames[13]}")

@JvmName("_15T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20T21")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any, T21 : Any> SelectQuery<Tuple21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>>._15() =
    col<T15>("${this.aliasName}.${aliasNames[14]}")

@JvmName("_16T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20T21")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any, T21 : Any> SelectQuery<Tuple21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>>._16() =
    col<T16>("${this.aliasName}.${aliasNames[15]}")

@JvmName("_17T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20T21")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any, T21 : Any> SelectQuery<Tuple21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>>._17() =
    col<T17>("${this.aliasName}.${aliasNames[16]}")

@JvmName("_18T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20T21")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any, T21 : Any> SelectQuery<Tuple21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>>._18() =
    col<T18>("${this.aliasName}.${aliasNames[17]}")

@JvmName("_19T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20T21")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any, T21 : Any> SelectQuery<Tuple21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>>._19() =
    col<T19>("${this.aliasName}.${aliasNames[18]}")

@JvmName("_20T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20T21")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any, T21 : Any> SelectQuery<Tuple21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>>._20() =
    col<T20>("${this.aliasName}.${aliasNames[19]}")

@JvmName("_21T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20T21")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any, T21 : Any> SelectQuery<Tuple21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>>._21() =
    col<T21>("${this.aliasName}.${aliasNames[20]}")

@JvmName("_1T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20T21T22")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any, T21 : Any, T22 : Any> SelectQuery<Tuple22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>>._1() =
    col<T1>("${this.aliasName}.${aliasNames[0]}")

@JvmName("_2T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20T21T22")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any, T21 : Any, T22 : Any> SelectQuery<Tuple22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>>._2() =
    col<T2>("${this.aliasName}.${aliasNames[1]}")

@JvmName("_3T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20T21T22")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any, T21 : Any, T22 : Any> SelectQuery<Tuple22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>>._3() =
    col<T3>("${this.aliasName}.${aliasNames[2]}")

@JvmName("_4T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20T21T22")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any, T21 : Any, T22 : Any> SelectQuery<Tuple22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>>._4() =
    col<T4>("${this.aliasName}.${aliasNames[3]}")

@JvmName("_5T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20T21T22")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any, T21 : Any, T22 : Any> SelectQuery<Tuple22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>>._5() =
    col<T5>("${this.aliasName}.${aliasNames[4]}")

@JvmName("_6T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20T21T22")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any, T21 : Any, T22 : Any> SelectQuery<Tuple22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>>._6() =
    col<T6>("${this.aliasName}.${aliasNames[5]}")

@JvmName("_7T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20T21T22")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any, T21 : Any, T22 : Any> SelectQuery<Tuple22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>>._7() =
    col<T7>("${this.aliasName}.${aliasNames[6]}")

@JvmName("_8T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20T21T22")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any, T21 : Any, T22 : Any> SelectQuery<Tuple22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>>._8() =
    col<T8>("${this.aliasName}.${aliasNames[7]}")

@JvmName("_9T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20T21T22")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any, T21 : Any, T22 : Any> SelectQuery<Tuple22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>>._9() =
    col<T9>("${this.aliasName}.${aliasNames[8]}")

@JvmName("_10T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20T21T22")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any, T21 : Any, T22 : Any> SelectQuery<Tuple22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>>._10() =
    col<T10>("${this.aliasName}.${aliasNames[9]}")

@JvmName("_11T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20T21T22")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any, T21 : Any, T22 : Any> SelectQuery<Tuple22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>>._11() =
    col<T11>("${this.aliasName}.${aliasNames[10]}")

@JvmName("_12T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20T21T22")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any, T21 : Any, T22 : Any> SelectQuery<Tuple22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>>._12() =
    col<T12>("${this.aliasName}.${aliasNames[11]}")

@JvmName("_13T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20T21T22")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any, T21 : Any, T22 : Any> SelectQuery<Tuple22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>>._13() =
    col<T13>("${this.aliasName}.${aliasNames[12]}")

@JvmName("_14T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20T21T22")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any, T21 : Any, T22 : Any> SelectQuery<Tuple22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>>._14() =
    col<T14>("${this.aliasName}.${aliasNames[13]}")

@JvmName("_15T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20T21T22")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any, T21 : Any, T22 : Any> SelectQuery<Tuple22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>>._15() =
    col<T15>("${this.aliasName}.${aliasNames[14]}")

@JvmName("_16T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20T21T22")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any, T21 : Any, T22 : Any> SelectQuery<Tuple22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>>._16() =
    col<T16>("${this.aliasName}.${aliasNames[15]}")

@JvmName("_17T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20T21T22")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any, T21 : Any, T22 : Any> SelectQuery<Tuple22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>>._17() =
    col<T17>("${this.aliasName}.${aliasNames[16]}")

@JvmName("_18T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20T21T22")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any, T21 : Any, T22 : Any> SelectQuery<Tuple22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>>._18() =
    col<T18>("${this.aliasName}.${aliasNames[17]}")

@JvmName("_19T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20T21T22")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any, T21 : Any, T22 : Any> SelectQuery<Tuple22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>>._19() =
    col<T19>("${this.aliasName}.${aliasNames[18]}")

@JvmName("_20T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20T21T22")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any, T21 : Any, T22 : Any> SelectQuery<Tuple22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>>._20() =
    col<T20>("${this.aliasName}.${aliasNames[19]}")

@JvmName("_21T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20T21T22")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any, T21 : Any, T22 : Any> SelectQuery<Tuple22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>>._21() =
    col<T21>("${this.aliasName}.${aliasNames[20]}")

@JvmName("_22T1T2T3T4T5T6T7T8T9T10T11T12T13T14T15T16T17T18T19T20T21T22")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6  : Any, T7 : Any, T8 : Any, T9 : Any, T10  : Any, T11 : Any, T12 : Any, T13 : Any, T14 : Any, T15 : Any, T16 : Any, T17 : Any, T18 : Any, T19 : Any, T20 : Any, T21 : Any, T22 : Any> SelectQuery<Tuple22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>>._22() =
    col<T22>("${this.aliasName}.${aliasNames[21]}")