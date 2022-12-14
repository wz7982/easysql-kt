package org.easysql.dsl

import org.easysql.ast.table.SqlJoinType
import java.math.BigDecimal
import java.util.*

sealed interface AnyTable {
    infix fun join(right: AnyTable): JoinTable = JoinTable(this, SqlJoinType.JOIN, right)
    infix fun leftJoin(right: AnyTable): JoinTable = JoinTable(this, SqlJoinType.LEFT_JOIN, right)
    infix fun rightJoin(right: AnyTable): JoinTable = JoinTable(this, SqlJoinType.RIGHT_JOIN, right)
    infix fun innerJoin(right: AnyTable): JoinTable = JoinTable(this, SqlJoinType.INNER_JOIN, right)
    infix fun fullJoin(right: AnyTable): JoinTable = JoinTable(this, SqlJoinType.FULL_JOIN, right)
    infix fun crossJoin(right: AnyTable): JoinTable = JoinTable(this, SqlJoinType.CROSS_JOIN, right)
}

abstract class TableSchema<T>(
    val tableName_: String,
    var aliasName_: String? = null,
    val cols_: MutableList<Column<*>> = mutableListOf()
) : AnyTable, Selectable<T> {
    private fun <T : Any> column(name: String): Column<T> {
        val col = aliasName_?.let { Column<T>(it, name, this) } ?: Column(tableName_, name, this)
        cols_.add(col)
        return col
    }

    fun intColumn(name: String) = column<Int>(name)
    fun longColumn(name: String) = column<Long>(name)
    fun floatColumn(name: String) = column<Float>(name)
    fun doubleColumn(name: String) = column<Double>(name)
    fun decimalColumn(name: String) = column<BigDecimal>(name)
    fun stringColumn(name: String) = column<String>(name)
    fun booleanColumn(name: String) = column<Boolean>(name)
    fun dateColumn(name: String) = column<Date>(name)
}

inline infix fun <reified T : TableSchema<*>> T.alias(name: String): T {
    val clazz = T::class
    val constructors = clazz.constructors
    val table = constructors.first().call()
    table.aliasName_ = name

    return table
}

data class JoinTable(
    val left: AnyTable,
    val joinType: SqlJoinType,
    val right: AnyTable,
    var on: Expr<*>? = null
) : AnyTable {
    infix fun on(expr: Expr<*>): JoinTable {
        this.on = expr
        return this
    }
}