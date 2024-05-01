package com.ougi.callme.presentation.routing

import com.ougi.callme.domain.usecase.UpdateKeyUseCase
import com.ougi.callme.presentation.model.UserRequest
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.updateUserKey() {
    val updateKeyUseCase by inject<UpdateKeyUseCase>()
    post("/update") {
        val request = call.receive<UserRequest>()
        updateKeyUseCase.updateUserKey(
            login = request.login,
            password = request.password
        )
        call.respond(HttpStatusCode.OK)
    }
}