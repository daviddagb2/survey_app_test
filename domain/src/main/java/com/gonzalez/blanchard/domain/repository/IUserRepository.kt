package com.gonzalez.blanchard.domain.repository

interface IUserRepository {
    suspend fun login(user: String, password: String)
}
