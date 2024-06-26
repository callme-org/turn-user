package com.ougi.callme.di

import com.ougi.callme.data.repository.DatabaseRepositoryImpl
import com.ougi.callme.data.repository.TurnUsersRepositoryImpl
import com.ougi.callme.domain.repository.DatabaseRepository
import com.ougi.callme.domain.repository.TurnUsersRepository
import com.ougi.callme.domain.usecase.*
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

private val dataModule = module {
    singleOf(::TurnUsersRepositoryImpl) { bind<TurnUsersRepository>() }
    singleOf(::DatabaseRepositoryImpl) { bind<DatabaseRepository>() }
}

private val domainUseCase = module {
    singleOf(::DatabaseInitializerImpl) { bind<DatabaseInitializer>() }
    singleOf(::CreateUserUseCaseImpl) { bind<CreateUserUseCase>() }
    singleOf(::UpdateKeyUseCaseImpl) { bind<UpdateKeyUseCase>() }
}

val appModule = module {
    includes(
        dataModule,
        domainUseCase,
    )
}