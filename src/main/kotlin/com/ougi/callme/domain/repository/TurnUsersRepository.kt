package com.ougi.callme.domain.repository

import com.ougi.callme.data.model.dto.CreateUserDto

interface TurnUsersRepository {

    suspend fun createOrUpdate(user: CreateUserDto)

    suspend fun update(
        login: String,
        newKey: String
    )
}