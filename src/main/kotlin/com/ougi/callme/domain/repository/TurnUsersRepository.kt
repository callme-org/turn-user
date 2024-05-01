package com.ougi.callme.domain.repository

import com.ougi.callme.data.model.dto.CreateUserDto

interface TurnUsersRepository {

    suspend fun create(user: CreateUserDto): String

    suspend fun update(
        login: String,
        newKey: String
    ): Int
}