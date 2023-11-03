package com.gonzalez.blanchard.domain.models // ktlint-disable filename

data class UserBO(
    val id: String,
    val type: String,
    val email: String,
    val name: String,
    val avatarUrl: String,
)

