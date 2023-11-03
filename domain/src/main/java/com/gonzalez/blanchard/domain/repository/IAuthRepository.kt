package com.gonzalez.blanchard.domain.repository

interface IAuthRepository {
    suspend fun login(user: String, password: String)
    suspend fun logout()
    suspend fun refreshToken()
}
