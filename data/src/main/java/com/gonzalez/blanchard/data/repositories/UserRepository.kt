package com.gonzalez.blanchard.data.repositories

import com.gonzalez.blanchard.data.mappers.dto.toUserBO
import com.gonzalez.blanchard.domain.models.UserBO
import com.gonzalez.blanchard.domain.repository.IUserRepository
import com.gonzalez.blanchard.remotedatasource.datasources.UserRemoteDataSource
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userRemoteDataSource: UserRemoteDataSource,
) : IUserRepository {
    override suspend fun getUser(): UserBO {
        val userDto = userRemoteDataSource.getUser()
        return userDto.toUserBO()
    }
}
