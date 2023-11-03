package com.gonzalez.blanchard.domain.models.input

data class LoginBO(
    val grantType: String,
    val email: String,
    val password: String,
    val clientId: String,
    val clientSecret: String,
)
