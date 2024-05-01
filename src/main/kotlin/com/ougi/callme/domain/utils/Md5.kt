package com.ougi.callme.domain.utils

import com.ougi.callme.domain.constants.DatabaseConstants
import java.security.MessageDigest

fun generateKey(
    login: String,
    password: String
): String {
    val md = MessageDigest.getInstance("MD5")
    val inputBytes = listOf(login, DatabaseConstants.defaultRealm, password)
        .joinToString(":")
        .toByteArray()
    val digest = md.digest(inputBytes)
    return digest.joinToString("") { "%02x".format(it) }
}