package org.easysql.query.select

import org.easysql.ast.statement.select.SqlUnionSelect
import org.easysql.ast.statement.select.SqlUnionType
import org.easysql.dsl.Tuple

class UnionSelect<T : Tuple>(val left: SelectQuery<*>, val unionType: SqlUnionType, val right: SelectQuery<*>) : SelectQuery<T>() {
    private val ast = SqlUnionSelect(left.getAst(), unionType, right.getAst())

    override fun getAst(): SqlUnionSelect = ast
}