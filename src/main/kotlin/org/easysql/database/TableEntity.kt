package org.easysql.database

import org.easysql.dsl.TableSchema

interface TableEntity {
    val table_: TableSchema<*>
}