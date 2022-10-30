package org.easysql.ast.expr

enum class SqlSubQueryPredicate(val predicate: String) {
    EXISTS("EXISTS"),
    NOT_EXISTS("NOT EXISTS"),
    ANY("ANY"),
    ALL("ALL"),
    SOME("SOME"),
}