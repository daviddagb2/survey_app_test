package com.gonzalez.blanchard.domain.repository

import com.gonzalez.blanchard.domain.models.AuthTokenBO

interface IAuthRepository {
    suspend fun login(user: String, password: String)
    suspend fun logout()
    suspend fun refreshToken()
    suspend fun getAuth(): AuthTokenBO
}
