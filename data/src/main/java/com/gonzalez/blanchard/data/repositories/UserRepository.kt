package com.gonzalez.blanchard.data.repositories


import com.gonzalez.blanchard.domain.repository.IUserRepository
import com.gonzalez.blanchard.remotedatasource.datasources.UserRemoteDataSource
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userRemoteDataSource: UserRemoteDataSource,
    private val userLocalDataSource: UserLocalDataSource
) : IUserRepository {

    override suspend fun login(user: String, password: String) {
        val loginDto = userRemoteDataSource.login(user, password)
        userLocalDataSource.insertUser(loginDto.toUserEntity())
    }
}
