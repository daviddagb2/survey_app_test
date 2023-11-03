package com.gonzalez.blanchard.localdatasource.datasources

import com.gonzalez.blanchard.localdatasource.AppDatabase
import com.gonzalez.blanchard.localdatasource.entity.UserEntity
import io.reactivex.Flowable
import javax.inject.Inject

class UserLocalDataSource @Inject constructor(appDatabase: AppDatabase) {

    private val userDao = appDatabase.userDao()

    suspend fun getUser(): UserEntity? {
        return userDao.getUser()
    }

    fun getUserFlowable(): Flowable<UserEntity?> {
        return userDao.getUserFlowable()
    }

    suspend fun insertUser(user: UserEntity) {
        userDao.insertUser(user)
    }

    suspend fun updateUser(user: UserEntity) {
        userDao.updateUser(user)
    }

    suspend fun nukeTable() {
        userDao.nukeTable()
    }
}
