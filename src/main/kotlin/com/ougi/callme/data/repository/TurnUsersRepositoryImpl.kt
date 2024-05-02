package com.ougi.callme.data.repository

import com.ougi.callme.data.model.dto.CreateUserDto
import com.ougi.callme.data.model.table.TurnUsers
import com.ougi.callme.domain.repository.TurnUsersRepository
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.update

class TurnUsersRepositoryImpl : TurnUsersRepository {

    override suspend fun createOrUpdate(user: CreateUserDto) {
        dbQuery {
            val isUserExits = TurnUsers.selectAll()
                .where { TurnUsers.name eq user.name }
                .count() > 0
            if (isUserExits) update(user.name, user.key)
            else TurnUsers.insert { column ->
                column[realm] = user.realm
                column[name] = user.name
                column[hmacKey] = user.key
            }[TurnUsers.name]
        }
    }

    override suspend fun update(
        login: String,
        newKey: String
    ) {
        dbQuery {
            TurnUsers.update({ TurnUsers.name eq login }) { column ->
                column[hmacKey] = newKey
            }
        }
    }


    private suspend fun <T> dbQuery(query: suspend () -> T): T =
        newSuspendedTransaction(Dispatchers.IO) { query() }
}