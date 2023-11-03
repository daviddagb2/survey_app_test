package com.gonzalez.blanchard.localdatasource.datasources

import com.gonzalez.blanchard.localdatasource.AppDatabase
import com.gonzalez.blanchard.localdatasource.entity.AuthTokenEntity
import io.reactivex.Flowable
import javax.inject.Inject

class AuthLocalDataSource @Inject constructor(appDatabase: AppDatabase) {

    private val authTokenEntityDao = appDatabase.authTokenDao()

    suspend fun getAuthToken(): AuthTokenEntity? {
        return authTokenEntityDao.getAuthToken()
    }

    fun getAuthTokenFlowable(): Flowable<AuthTokenEntity?> {
        return authTokenEntityDao.getAuthTokenFlowable()
    }

    suspend fun insertAuthToken(authTokenEntity: AuthTokenEntity) {
        authTokenEntityDao.insertAuthToken(authTokenEntity)
    }

    suspend fun updateAuthToken(authTokenEntity: AuthTokenEntity) {
        authTokenEntityDao.updateAuthToken(authTokenEntity)
    }

    suspend fun nukeTable() {
        authTokenEntityDao.nukeTable()
    }
}
