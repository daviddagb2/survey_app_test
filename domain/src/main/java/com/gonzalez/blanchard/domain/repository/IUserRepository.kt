package com.gonzalez.blanchard.domain.repository

import com.gonzalez.blanchard.domain.models.UserBO

interface IUserRepository {
    suspend fun getUser(): UserBO

}
