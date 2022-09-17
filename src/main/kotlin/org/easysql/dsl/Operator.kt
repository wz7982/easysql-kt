package org.easysql.dsl

import com.sun.org.apache.xpath.internal.operations.Bool
import org.easysql.ast.expr.SqlBinaryOperator
import java.math.BigDecimal
import java.util.*

infix fun Int.alias(name: String) = ConstExpr(this, name)
infix fun String.alias(name: String) = ConstExpr(this, name)
infix fun Long.alias(name: String) = ConstExpr(this, name)
infix fun Float.alias(name: String) = ConstExpr(this, name)
infix fun Double.alias(name: String) = ConstExpr(this, name)
infix fun Boolean.alias(name: String) = ConstExpr(this, name)
infix fun Date.alias(name: String) = ConstExpr(this, name)
infix fun BigDecimal.alias(name: String) = ConstExpr(this, name)

operator fun <T : Number> Number.plus(e: Expr<T>) = BinaryExpr<Number>(ConstExpr(this), SqlBinaryOperator.ADD, e)
operator fun <T : Number> Number.minus(e: Expr<T>) = BinaryExpr<Number>(ConstExpr(this), SqlBinaryOperator.SUB, e)
operator fun <T : Number> Number.times(e: Expr<T>) = BinaryExpr<Number>(ConstExpr(this), SqlBinaryOperator.MUL, e)
operator fun <T : Number> Number.div(e: Expr<T>) = BinaryExpr<Number>(ConstExpr(this), SqlBinaryOperator.DIV, e)
operator fun <T : Number> Number.rem(e: Expr<T>) = BinaryExpr<Number>(ConstExpr(this), SqlBinaryOperator.MOD, e)

infix fun <T : Int?> Int.eq(e: Expr<T>) = BinaryExpr<T>(ConstExpr(this), SqlBinaryOperator.EQ, e)
infix fun <T : String?> String.eq(e: Expr<T>) = BinaryExpr<T>(ConstExpr(this), SqlBinaryOperator.EQ, e)
infix fun <T : Long?> Long.eq(e: Expr<T>) = BinaryExpr<T>(ConstExpr(this), SqlBinaryOperator.EQ, e)
infix fun <T : Float?> Float.eq(e: Expr<T>) = BinaryExpr<T>(ConstExpr(this), SqlBinaryOperator.EQ, e)
infix fun <T : Double?> Double.eq(e: Expr<T>) = BinaryExpr<T>(ConstExpr(this), SqlBinaryOperator.EQ, e)
infix fun <T : Boolean?> Boolean.eq(e: Expr<T>) = BinaryExpr<T>(ConstExpr(this), SqlBinaryOperator.EQ, e)
infix fun <T : Date?> Date.eq(e: Expr<T>) = BinaryExpr<T>(ConstExpr(this), SqlBinaryOperator.EQ, e)
infix fun <T : BigDecimal?> BigDecimal.eq(e: Expr<T>) = BinaryExpr<T>(ConstExpr(this), SqlBinaryOperator.EQ, e)

infix fun <T : Int?> Int.ne(e: Expr<T>) = BinaryExpr<T>(ConstExpr(this), SqlBinaryOperator.NE, e)
infix fun <T : String?> String.ne(e: Expr<T>) = BinaryExpr<T>(ConstExpr(this), SqlBinaryOperator.NE, e)
infix fun <T : Long?> Long.ne(e: Expr<T>) = BinaryExpr<T>(ConstExpr(this), SqlBinaryOperator.NE, e)
infix fun <T : Float?> Float.ne(e: Expr<T>) = BinaryExpr<T>(ConstExpr(this), SqlBinaryOperator.NE, e)
infix fun <T : Double?> Double.ne(e: Expr<T>) = BinaryExpr<T>(ConstExpr(this), SqlBinaryOperator.NE, e)
infix fun <T : Boolean?> Boolean.ne(e: Expr<T>) = BinaryExpr<T>(ConstExpr(this), SqlBinaryOperator.NE, e)
infix fun <T : Date?> Date.ne(e: Expr<T>) = BinaryExpr<T>(ConstExpr(this), SqlBinaryOperator.NE, e)
infix fun <T : BigDecimal?> BigDecimal.ne(e: Expr<T>) = BinaryExpr<T>(ConstExpr(this), SqlBinaryOperator.NE, e)

infix fun <T : Int?> Int.gt(e: Expr<T>) = BinaryExpr<T>(ConstExpr(this), SqlBinaryOperator.GT, e)
infix fun <T : String?> String.gt(e: Expr<T>) = BinaryExpr<T>(ConstExpr(this), SqlBinaryOperator.GT, e)
infix fun <T : Long?> Long.gt(e: Expr<T>) = BinaryExpr<T>(ConstExpr(this), SqlBinaryOperator.GT, e)
infix fun <T : Float?> Float.gt(e: Expr<T>) = BinaryExpr<T>(ConstExpr(this), SqlBinaryOperator.GT, e)
infix fun <T : Double?> Double.gt(e: Expr<T>) = BinaryExpr<T>(ConstExpr(this), SqlBinaryOperator.GT, e)
infix fun <T : Boolean?> Boolean.gt(e: Expr<T>) = BinaryExpr<T>(ConstExpr(this), SqlBinaryOperator.GT, e)
infix fun <T : Date?> Date.gt(e: Expr<T>) = BinaryExpr<T>(ConstExpr(this), SqlBinaryOperator.GT, e)
infix fun <T : BigDecimal?> BigDecimal.gt(e: Expr<T>) = BinaryExpr<T>(ConstExpr(this), SqlBinaryOperator.GT, e)

infix fun <T : Int?> Int.ge(e: Expr<T>) = BinaryExpr<T>(ConstExpr(this), SqlBinaryOperator.GE, e)
infix fun <T : String?> String.ge(e: Expr<T>) = BinaryExpr<T>(ConstExpr(this), SqlBinaryOperator.GE, e)
infix fun <T : Long?> Long.ge(e: Expr<T>) = BinaryExpr<T>(ConstExpr(this), SqlBinaryOperator.GE, e)
infix fun <T : Float?> Float.ge(e: Expr<T>) = BinaryExpr<T>(ConstExpr(this), SqlBinaryOperator.GE, e)
infix fun <T : Double?> Double.ge(e: Expr<T>) = BinaryExpr<T>(ConstExpr(this), SqlBinaryOperator.GE, e)
infix fun <T : Boolean?> Boolean.ge(e: Expr<T>) = BinaryExpr<T>(ConstExpr(this), SqlBinaryOperator.GE, e)
infix fun <T : Date?> Date.ge(e: Expr<T>) = BinaryExpr<T>(ConstExpr(this), SqlBinaryOperator.GE, e)
infix fun <T : BigDecimal?> BigDecimal.ge(e: Expr<T>) = BinaryExpr<T>(ConstExpr(this), SqlBinaryOperator.GE, e)

infix fun <T : Int?> Int.lt(e: Expr<T>) = BinaryExpr<T>(ConstExpr(this), SqlBinaryOperator.LT, e)
infix fun <T : String?> String.lt(e: Expr<T>) = BinaryExpr<T>(ConstExpr(this), SqlBinaryOperator.LT, e)
infix fun <T : Long?> Long.lt(e: Expr<T>) = BinaryExpr<T>(ConstExpr(this), SqlBinaryOperator.LT, e)
infix fun <T : Float?> Float.lt(e: Expr<T>) = BinaryExpr<T>(ConstExpr(this), SqlBinaryOperator.LT, e)
infix fun <T : Double?> Double.lt(e: Expr<T>) = BinaryExpr<T>(ConstExpr(this), SqlBinaryOperator.LT, e)
infix fun <T : Boolean?> Boolean.lt(e: Expr<T>) = BinaryExpr<T>(ConstExpr(this), SqlBinaryOperator.LT, e)
infix fun <T : Date?> Date.lt(e: Expr<T>) = BinaryExpr<T>(ConstExpr(this), SqlBinaryOperator.LT, e)
infix fun <T : BigDecimal?> BigDecimal.lt(e: Expr<T>) = BinaryExpr<T>(ConstExpr(this), SqlBinaryOperator.LT, e)

infix fun <T : Int?> Int.le(e: Expr<T>) = BinaryExpr<T>(ConstExpr(this), SqlBinaryOperator.LE, e)
infix fun <T : String?> String.le(e: Expr<T>) = BinaryExpr<T>(ConstExpr(this), SqlBinaryOperator.LE, e)
infix fun <T : Long?> Long.le(e: Expr<T>) = BinaryExpr<T>(ConstExpr(this), SqlBinaryOperator.LE, e)
infix fun <T : Float?> Float.le(e: Expr<T>) = BinaryExpr<T>(ConstExpr(this), SqlBinaryOperator.LE, e)
infix fun <T : Double?> Double.le(e: Expr<T>) = BinaryExpr<T>(ConstExpr(this), SqlBinaryOperator.LE, e)
infix fun <T : Boolean?> Boolean.le(e: Expr<T>) = BinaryExpr<T>(ConstExpr(this), SqlBinaryOperator.LE, e)
infix fun <T : Date?> Date.le(e: Expr<T>) = BinaryExpr<T>(ConstExpr(this), SqlBinaryOperator.LE, e)
infix fun <T : BigDecimal?> BigDecimal.le(e: Expr<T>) = BinaryExpr<T>(ConstExpr(this), SqlBinaryOperator.LE, e)

infix fun Boolean.and(e: Expr<*>) = BinaryExpr<Boolean>(ConstExpr(this), SqlBinaryOperator.AND, e)
infix fun Boolean.or(e: Expr<*>) = BinaryExpr<Boolean>(ConstExpr(this), SqlBinaryOperator.OR, e)
infix fun Boolean.xor(e: Expr<*>) = BinaryExpr<Boolean>(ConstExpr(this), SqlBinaryOperator.XOR, e)