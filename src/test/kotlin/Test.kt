import org.easysql.database.DB
import org.easysql.database.TableEntity
import org.easysql.dsl.*
import org.easysql.query.select.Select
import org.easysql.query.select._1
import org.easysql.query.select._2
import org.easysql.visitor.visitExpr

object Test {
    @JvmStatic
    fun main(args: Array<String>) {
//        val u1 = user alias "u1"
//        val u2 = user alias "u2"
//
//        val s = select(u1, u2) from u1 join u2 on (u1.id eq u2.id)
//        println(s.sql(DB.MYSQL))

        val sub = select(user.id alias "col1", user.name alias "col2") from user alias "sub"
        val s = select(sub._2(), sub._1()) from sub
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

//fun print(i: Int) {
//    (1 .. i).forEach {
//        print("@JvmName(\"_$it")
//        (1 .. i).forEach { n ->
//            print("T$n")
//        }
//        println("\")")
//        print("fun <")
//        (1 until i).forEach { n ->
//            print("T$n, ")
//        }
//        print("T$i> SelectQuery<Tuple$i<")
//        (1 until i).forEach { n ->
//            print("T$n, ")
//        }
//        print("T$i>>._$it() = ")
//        println("col<T$it>(\"\${this.aliasName}.\${aliasNames[${it - 1}]}\")")
//    }
//}

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