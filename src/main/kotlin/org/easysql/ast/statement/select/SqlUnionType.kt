package org.easysql.ast.statement.select

enum class SqlUnionType(val unionType: String) {
    UNION("UNION"),
    UNION_ALL("UNION ALL"),
    EXCEPT("EXCEPT"),
    EXCEPT_ALL("EXCEPT ALL"),
    INTERSECT("INTERSECT"),
    INTERSECT_ALL("INTERSECT ALL")
}
