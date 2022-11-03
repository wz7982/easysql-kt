package org.easysql.database

data class Page<T>(val totalPage: Long = 0, val totalCount: Long = 0, val data: List<T> = listOf()) {
    fun <R> map(f: (T) -> R): Page<R> = Page(totalPage, totalCount, data.map(f))
}