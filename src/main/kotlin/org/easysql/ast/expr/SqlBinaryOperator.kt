package org.easysql.ast.expr

enum class SqlBinaryOperator(val operator: String) {
    IS("IS"),
    IS_NOT("IS NOT"),
    EQ("="),
    NE("<>"),
    LIKE("LIKE"),
    NOT_LIKE("NOT LIKE"),
    GT(">"),
    GE(">="),
    LT("<"),
    LE("<="),
    AND("AND"),
    OR("OR"),
    XOR("XOR"),
    ADD("+"),
    SUB("-"),
    MUL("*"),
    DIV("/"),
    MOD("%"),
    SUB_GT("->"),
    SUB_GT_GT("->>"),
    CONCAT("||")
}