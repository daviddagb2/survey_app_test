package com.gonzalez.blanchard.domain.models.input

data class LogoutRequestBO(
    val token: String,
    val clientId: String,
    val clientSecret: String,
)
