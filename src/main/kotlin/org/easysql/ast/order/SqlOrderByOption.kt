package org.easysql.ast.order

enum class SqlOrderByOption(val ord: String) {
    ASC("ASC"),
    DESC("DESC");

    fun turn(): SqlOrderByOption = if (this == ASC) DESC else ASC
}
