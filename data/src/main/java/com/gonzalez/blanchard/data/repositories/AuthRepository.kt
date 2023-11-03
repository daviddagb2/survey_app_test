package com.gonzalez.blanchard.data.repositories

import com.gonzalez.blanchard.data.constants.CLIENT_ID
import com.gonzalez.blanchard.data.constants.CLIENT_SECRET
import com.gonzalez.blanchard.data.constants.GRANT_TYPE
import com.gonzalez.blanchard.data.mappers.dto.toTokenEntity
import com.gonzalez.blanchard.domain.repository.IAuthRepository
import com.gonzalez.blanchard.localdatasource.datasources.AuthLocalDataSource
import com.gonzalez.blanchard.localdatasource.datasources.UserLocalDataSource
import com.gonzalez.blanchard.remotedatasource.datasources.AuthRemoteDataSource
import com.gonzalez.blanchard.remotedatasource.models.input.LoginDto
import com.gonzalez.blanchard.remotedatasource.models.input.LogoutRequestDto
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val authLocalDataSource: AuthLocalDataSource,
    private val userLocalDataSource: UserLocalDataSource,
    private val authRemoteDataSource: AuthRemoteDataSource,
) : IAuthRepository {

    override suspend fun login(email: String, password: String) {
        val loginRequest = LoginDto(
            grantType = GRANT_TYPE,
            email = email,
            password = password,
            clientId = CLIENT_ID,
            clientSecret = CLIENT_SECRET,
        )

        val tokenEntity = authRemoteDataSource.login(loginRequest)
        authLocalDataSource.insertAuthToken(tokenEntity.toTokenEntity())
    }

    override suspend fun logout() {
        val logoutRequestDto = LogoutRequestDto(
            token = authLocalDataSource.getAuthToken()!!.accessToken,
            clientId = CLIENT_ID,
            clientSecret = CLIENT_SECRET,
        )
        authRemoteDataSource.logout(logoutRequestDto)
        userLocalDataSource.nukeTable()
        userLocalDataSource.nukeTable()
    }

    override suspend fun refreshToken() {
        TODO("Implement refresh token")
    }
}
