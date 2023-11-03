package com.gonzalez.blanchard.domain.models.login

data class LoginResponseDataBO(
    val id: String,
    val type: String,
    val attributes: LoginResponseAttributesBO,
)
