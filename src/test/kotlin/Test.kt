import org.easysql.database.DB
import org.easysql.database.TableEntity
import org.easysql.dsl.*
import org.easysql.query.select.Select

object Test {
    @JvmStatic
    fun main(args: Array<String>) {
        val u1 = user alias "u1"
        val u2 = user alias "u2"

        val s = select(u1, u2) from u1 join u2 on (u1.id eq u2.id)
        println(s.sql(DB.MYSQL))

//        val ur = UserRow(1, null)
//
//        val i = insert(ur)
//        println(i.sql(DB.MYSQL))
//
//        val u = update(ur, false)
//        println(u.sql(DB.MYSQL))
    }
}

class A : TableSchema<Nothing>("a") {
    val id = intColumn("id")
}

val a by lazy { A() }

class B : TableSchema<Nothing>("b") {
    val id = intColumn("id")
}

val b by lazy { B() }

class C : TableSchema<Nothing>("c") {
    val id = intColumn("id")
}

val c by lazy { C() }

data class UserRow(val id: Int, val name: String?) : TableEntity {
    override val table_ = user
}

class User : TableSchema<UserRow>("user") {
    val id = intColumn("id").incr()
    val name = stringColumn("name").nullable()
}

val user by lazy { User() }