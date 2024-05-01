package com.ougi.callme.domain.usecase

import com.ougi.callme.data.model.dto.CreateUserDto
import com.ougi.callme.domain.constants.DatabaseConstants
import com.ougi.callme.domain.repository.TurnUsersRepository
import com.ougi.callme.domain.utils.generateKey

interface CreateUserUseCase {

    suspend fun create(
        login: String,
        password: String,
    )

}

class CreateUserUseCaseImpl(
    private val turnUsersRepository: TurnUsersRepository,
) : CreateUserUseCase {

    override suspend fun create(
        login: String,
        password: String,
    ) {
        turnUsersRepository.create(
            CreateUserDto(
                realm = DatabaseConstants.defaultRealm,
                name = login,
                key = generateKey(login, password)
            )
        )
    }

}