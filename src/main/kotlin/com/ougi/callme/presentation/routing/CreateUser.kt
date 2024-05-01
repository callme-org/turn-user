package com.ougi.callme.presentation.routing

import com.ougi.callme.domain.usecase.CreateUserUseCase
import com.ougi.callme.presentation.model.UserRequest
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.createUser() {
    val createUserUseCase by inject<CreateUserUseCase>()
    post("/create") {
        val request = call.receive<UserRequest>()
        createUserUseCase.create(
            login = request.login,
            password = request.password
        )
        call.respond(HttpStatusCode.OK)
    }
}