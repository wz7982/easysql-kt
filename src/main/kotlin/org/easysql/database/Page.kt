package org.easysql.database

data class Page<T>(val totalPage: Int = 0, val totalCount: Int = 0, val data: List<T> = listOf())