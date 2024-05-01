package com.ougi.callme.domain.usecase

import com.ougi.callme.domain.repository.TurnUsersRepository
import com.ougi.callme.domain.utils.generateKey

interface UpdateKeyUseCase {

    suspend fun updateUserKey(
        login: String,
        password: String,
    )

}

class UpdateKeyUseCaseImpl(
    private val turnUsersRepository: TurnUsersRepository,
) : UpdateKeyUseCase {

    override suspend fun updateUserKey(
        login: String,
        password: String,
    ) {
        turnUsersRepository.update(
            login = login,
            newKey = generateKey(login, password)
        )
    }

}