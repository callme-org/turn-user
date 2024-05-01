package com.ougi.callme.data.model.table

import org.jetbrains.exposed.sql.Table

object TurnUsers : Table("turnusers_lt") {

    val realm = varchar("realm", 127).default("")
    val name = varchar("name", 512).uniqueIndex()
    val hmacKey = char("hmackey", 128)

    override val primaryKey = PrimaryKey(realm, name)
}