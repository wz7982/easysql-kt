package org.easysql.dsl

import kotlin.reflect.KClass

sealed class Tuple

object EmptyTuple : Tuple()

data class Tuple1<T1>(val _1: T1) : Tuple()

data class Tuple2<T1, T2>(val _1: T1, val _2: T2) : Tuple()

data class Tuple3<T1, T2, T3>(val _1: T1, val _2: T2, val _3: T3) : Tuple()

data class Tuple4<T1, T2, T3, T4>(val _1: T1, val _2: T2, val _3: T3, val _4: T4) : Tuple()

data class Tuple5<T1, T2, T3, T4, T5>(val _1: T1, val _2: T2, val _3: T3, val _4: T4, val _5: T5) : Tuple()

data class Tuple6<T1, T2, T3, T4, T5, T6>(
    val _1: T1,
    val _2: T2,
    val _3: T3,
    val _4: T4,
    val _5: T5,
    val _6: T6
) : Tuple()


data class Tuple7<T1, T2, T3, T4, T5, T6, T7>(
    val _1: T1,
    val _2: T2,
    val _3: T3,
    val _4: T4,
    val _5: T5,
    val _6: T6,
    val _7: T7
) : Tuple()

data class Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>(
    val _1: T1,
    val _2: T2,
    val _3: T3,
    val _4: T4,
    val _5: T5,
    val _6: T6,
    val _7: T7,
    val _8: T8
) : Tuple()

data class Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>(
    val _1: T1,
    val _2: T2,
    val _3: T3,
    val _4: T4,
    val _5: T5,
    val _6: T6,
    val _7: T7,
    val _8: T8,
    val _9: T9
) : Tuple()

data class Tuple10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>(
    val _1: T1,
    val _2: T2,
    val _3: T3,
    val _4: T4,
    val _5: T5,
    val _6: T6,
    val _7: T7,
    val _8: T8,
    val _9: T9,
    val _10: T10
) : Tuple()

data class Tuple11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>(
    val _1: T1,
    val _2: T2,
    val _3: T3,
    val _4: T4,
    val _5: T5,
    val _6: T6,
    val _7: T7,
    val _8: T8,
    val _9: T9,
    val _10: T10,
    val _11: T11
) : Tuple()

data class Tuple12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>(
    val _1: T1,
    val _2: T2,
    val _3: T3,
    val _4: T4,
    val _5: T5,
    val _6: T6,
    val _7: T7,
    val _8: T8,
    val _9: T9,
    val _10: T10,
    val _11: T11,
    val _12: T12
) : Tuple()

data class Tuple13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>(
    val _1: T1,
    val _2: T2,
    val _3: T3,
    val _4: T4,
    val _5: T5,
    val _6: T6,
    val _7: T7,
    val _8: T8,
    val _9: T9,
    val _10: T10,
    val _11: T11,
    val _12: T12,
    val _13: T13
) : Tuple()

data class Tuple14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>(
    val _1: T1,
    val _2: T2,
    val _3: T3,
    val _4: T4,
    val _5: T5,
    val _6: T6,
    val _7: T7,
    val _8: T8,
    val _9: T9,
    val _10: T10,
    val _11: T11,
    val _12: T12,
    val _13: T13,
    val _14: T14
) : Tuple()

data class Tuple15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>(
    val _1: T1,
    val _2: T2,
    val _3: T3,
    val _4: T4,
    val _5: T5,
    val _6: T6,
    val _7: T7,
    val _8: T8,
    val _9: T9,
    val _10: T10,
    val _11: T11,
    val _12: T12,
    val _13: T13,
    val _14: T14,
    val _15: T15
) : Tuple()

data class Tuple16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>(
    val _1: T1,
    val _2: T2,
    val _3: T3,
    val _4: T4,
    val _5: T5,
    val _6: T6,
    val _7: T7,
    val _8: T8,
    val _9: T9,
    val _10: T10,
    val _11: T11,
    val _12: T12,
    val _13: T13,
    val _14: T14,
    val _15: T15,
    val _16: T16
) : Tuple()

data class Tuple17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>(
    val _1: T1,
    val _2: T2,
    val _3: T3,
    val _4: T4,
    val _5: T5,
    val _6: T6,
    val _7: T7,
    val _8: T8,
    val _9: T9,
    val _10: T10,
    val _11: T11,
    val _12: T12,
    val _13: T13,
    val _14: T14,
    val _15: T15,
    val _16: T16,
    val _17: T17
) : Tuple()

data class Tuple18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>(
    val _1: T1,
    val _2: T2,
    val _3: T3,
    val _4: T4,
    val _5: T5,
    val _6: T6,
    val _7: T7,
    val _8: T8,
    val _9: T9,
    val _10: T10,
    val _11: T11,
    val _12: T12,
    val _13: T13,
    val _14: T14,
    val _15: T15,
    val _16: T16,
    val _17: T17,
    val _18: T18
) : Tuple()

data class Tuple19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>(
    val _1: T1,
    val _2: T2,
    val _3: T3,
    val _4: T4,
    val _5: T5,
    val _6: T6,
    val _7: T7,
    val _8: T8,
    val _9: T9,
    val _10: T10,
    val _11: T11,
    val _12: T12,
    val _13: T13,
    val _14: T14,
    val _15: T15,
    val _16: T16,
    val _17: T17,
    val _18: T18,
    val _19: T19
) : Tuple()

data class Tuple20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>(
    val _1: T1,
    val _2: T2,
    val _3: T3,
    val _4: T4,
    val _5: T5,
    val _6: T6,
    val _7: T7,
    val _8: T8,
    val _9: T9,
    val _10: T10,
    val _11: T11,
    val _12: T12,
    val _13: T13,
    val _14: T14,
    val _15: T15,
    val _16: T16,
    val _17: T17,
    val _18: T18,
    val _19: T19,
    val _20: T20
) : Tuple()

data class Tuple21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>(
    val _1: T1,
    val _2: T2,
    val _3: T3,
    val _4: T4,
    val _5: T5,
    val _6: T6,
    val _7: T7,
    val _8: T8,
    val _9: T9,
    val _10: T10,
    val _11: T11,
    val _12: T12,
    val _13: T13,
    val _14: T14,
    val _15: T15,
    val _16: T16,
    val _17: T17,
    val _18: T18,
    val _19: T19,
    val _20: T20,
    val _21: T21
) : Tuple()

data class Tuple22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>(
    val _1: T1,
    val _2: T2,
    val _3: T3,
    val _4: T4,
    val _5: T5,
    val _6: T6,
    val _7: T7,
    val _8: T8,
    val _9: T9,
    val _10: T10,
    val _11: T11,
    val _12: T12,
    val _13: T13,
    val _14: T14,
    val _15: T15,
    val _16: T16,
    val _17: T17,
    val _18: T18,
    val _19: T19,
    val _20: T20,
    val _21: T21,
    val _22: T22
) : Tuple()