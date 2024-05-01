package com.ougi.callme.presentation.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class UserRequest(
    @SerialName("login")
    val login: String,
    @SerialName("password")
    val password: String,
)