package tech.kotlinhero.autohelper.domain

import org.babyfish.jimmer.sql.GeneratedValue
import org.babyfish.jimmer.sql.GenerationType
import org.babyfish.jimmer.sql.Id
import org.babyfish.jimmer.sql.MappedSuperclass
import java.time.LocalTime

@MappedSuperclass
interface Persistent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long

    val createTime: LocalTime

    val updateTime: LocalTime?
}