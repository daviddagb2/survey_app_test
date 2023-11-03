package com.gonzalez.blanchard.domain.models.input

data class UserRequestBO(
    val user: UserEmailBO,
    val clientId: String,
    val clientSecret: String,
)
