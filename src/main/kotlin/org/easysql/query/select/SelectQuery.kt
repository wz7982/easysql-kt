package org.easysql.query.select

import org.easysql.ast.statement.select.SqlSelectQuery
import org.easysql.ast.statement.select.SqlUnionType
import org.easysql.dsl.SubQueryExpr
import org.easysql.dsl.Tuple
import org.easysql.dsl.Tuple1
import org.easysql.query.BaseQuery

abstract class SelectQuery<T : Tuple> : BaseQuery<SqlSelectQuery> {
    var aliasName: String? = null

    infix fun alias(name: String): SelectQuery<T> {
        this.aliasName = name
        return this
    }

    infix fun union(unionSelect: SelectQuery<T>): UnionSelect<T> = UnionSelect(this, SqlUnionType.UNION, unionSelect)

    infix fun unionAll(unionSelect: SelectQuery<T>): UnionSelect<T> = UnionSelect(this, SqlUnionType.UNION_ALL, unionSelect)

    infix fun except(unionSelect: SelectQuery<T>): UnionSelect<T> = UnionSelect(this, SqlUnionType.EXCEPT, unionSelect)

    infix fun exceptAll(unionSelect: SelectQuery<T>): UnionSelect<T> = UnionSelect(this, SqlUnionType.EXCEPT_ALL, unionSelect)

    infix fun intersect(unionSelect: SelectQuery<T>): UnionSelect<T> = UnionSelect(this, SqlUnionType.INTERSECT, unionSelect)

    infix fun intersectAll(unionSelect: SelectQuery<T>): UnionSelect<T> = UnionSelect(this, SqlUnionType.INTERSECT_ALL, unionSelect)
}

fun <T> SelectQuery<Tuple1<T>>.toExpr() = SubQueryExpr(this, aliasName)