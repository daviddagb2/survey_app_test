package com.gonzalez.blanchard.domain.models

data class AuthTokenBO(
    val id: String,
    val type: String,
    val accessToken: String,
    val tokenType: String,
    val expiresIn: Int,
    val refreshToken: String,
    val createdAt: String,
)
