package org.easysql.dsl

import org.easysql.ast.expr.SqlBinaryOperator
import java.math.BigDecimal
import java.util.*

infix fun Number.alias(name: String) = ConstExpr(this, name)
infix fun String.alias(name: String) = ConstExpr(this, name)
infix fun Boolean.alias(name: String) = ConstExpr(this, name)
infix fun Date.alias(name: String) = ConstExpr(this, name)

operator fun <T : Number> Number.plus(e: Expr<T>) = BinaryExpr<Number>(ConstExpr(this), SqlBinaryOperator.ADD, e)
operator fun <T : Number> Number.minus(e: Expr<T>) = BinaryExpr<Number>(ConstExpr(this), SqlBinaryOperator.SUB, e)
operator fun <T : Number> Number.times(e: Expr<T>) = BinaryExpr<Number>(ConstExpr(this), SqlBinaryOperator.MUL, e)
operator fun <T : Number> Number.div(e: Expr<T>) = BinaryExpr<Number>(ConstExpr(this), SqlBinaryOperator.DIV, e)
operator fun <T : Number> Number.rem(e: Expr<T>) = BinaryExpr<Number>(ConstExpr(this), SqlBinaryOperator.MOD, e)

infix fun Number.eq(e: Expr<Int>) = BinaryExpr<Boolean>(ConstExpr(this), SqlBinaryOperator.EQ, e)
infix fun String.eq(e: Expr<String>) = BinaryExpr<Boolean>(ConstExpr(this), SqlBinaryOperator.EQ, e)
infix fun Boolean.eq(e: Expr<Boolean>) = BinaryExpr<Boolean>(ConstExpr(this), SqlBinaryOperator.EQ, e)
infix fun Date.eq(e: Expr<Date>) = BinaryExpr<Boolean>(ConstExpr(this), SqlBinaryOperator.EQ, e)

infix fun Number.ne(e: Expr<Number>) = BinaryExpr<Boolean>(ConstExpr(this), SqlBinaryOperator.NE, e)
infix fun String.ne(e: Expr<String>) = BinaryExpr<Boolean>(ConstExpr(this), SqlBinaryOperator.NE, e)
infix fun Boolean.ne(e: Expr<Boolean>) = BinaryExpr<Boolean>(ConstExpr(this), SqlBinaryOperator.NE, e)
infix fun Date.ne(e: Expr<Date>) = BinaryExpr<Boolean>(ConstExpr(this), SqlBinaryOperator.NE, e)

infix fun Number.gt(e: Expr<Number>) = BinaryExpr<Boolean>(ConstExpr(this), SqlBinaryOperator.GT, e)
infix fun String.gt(e: Expr<String>) = BinaryExpr<Boolean>(ConstExpr(this), SqlBinaryOperator.GT, e)
infix fun Boolean.gt(e: Expr<Boolean>) = BinaryExpr<Boolean>(ConstExpr(this), SqlBinaryOperator.GT, e)
infix fun Date.gt(e: Expr<Date>) = BinaryExpr<Boolean>(ConstExpr(this), SqlBinaryOperator.GT, e)

infix fun Number.ge(e: Expr<Number>) = BinaryExpr<Boolean>(ConstExpr(this), SqlBinaryOperator.GE, e)
infix fun String.ge(e: Expr<String>) = BinaryExpr<Boolean>(ConstExpr(this), SqlBinaryOperator.GE, e)
infix fun Boolean.ge(e: Expr<Boolean>) = BinaryExpr<Boolean>(ConstExpr(this), SqlBinaryOperator.GE, e)
infix fun Date.ge(e: Expr<Date>) = BinaryExpr<Boolean>(ConstExpr(this), SqlBinaryOperator.GE, e)

infix fun Number.lt(e: Expr<Number>) = BinaryExpr<Boolean>(ConstExpr(this), SqlBinaryOperator.LT, e)
infix fun String.lt(e: Expr<String>) = BinaryExpr<Boolean>(ConstExpr(this), SqlBinaryOperator.LT, e)
infix fun Boolean.lt(e: Expr<Boolean>) = BinaryExpr<Boolean>(ConstExpr(this), SqlBinaryOperator.LT, e)
infix fun Date.lt(e: Expr<Date>) = BinaryExpr<Boolean>(ConstExpr(this), SqlBinaryOperator.LT, e)

infix fun Number.le(e: Expr<Number>) = BinaryExpr<Boolean>(ConstExpr(this), SqlBinaryOperator.LE, e)
infix fun String.le(e: Expr<String>) = BinaryExpr<Boolean>(ConstExpr(this), SqlBinaryOperator.LE, e)
infix fun Boolean.le(e: Expr<Boolean>) = BinaryExpr<Boolean>(ConstExpr(this), SqlBinaryOperator.LE, e)
infix fun Date.le(e: Expr<Date>) = BinaryExpr<Boolean>(ConstExpr(this), SqlBinaryOperator.LE, e)

infix fun Boolean.and(e: Expr<*>) = BinaryExpr<Boolean>(ConstExpr(this), SqlBinaryOperator.AND, e)
infix fun Boolean.or(e: Expr<*>) = BinaryExpr<Boolean>(ConstExpr(this), SqlBinaryOperator.OR, e)
infix fun Boolean.xor(e: Expr<*>) = BinaryExpr<Boolean>(ConstExpr(this), SqlBinaryOperator.XOR, e)
