package com.gonzalez.blanchard.domain.models.login

data class LoginResponseAttributesBO(
    val accessToken: String,
    val tokenType: String,
    val expiresIn: Int,
    val refreshToken: String,
    val createdAt: String,
)
