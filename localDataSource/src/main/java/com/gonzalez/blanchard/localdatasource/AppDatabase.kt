package com.gonzalez.blanchard.localdatasource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gonzalez.blanchard.localdatasource.dao.AuthTokenEntityDao
import com.gonzalez.blanchard.localdatasource.dao.SettingsDao
import com.gonzalez.blanchard.localdatasource.dao.UserEntityDao
import com.gonzalez.blanchard.localdatasource.entity.AuthTokenEntity
import com.gonzalez.blanchard.localdatasource.entity.SettingsEntity
import com.gonzalez.blanchard.localdatasource.entity.UserEntity

@Database(
    entities = [
        SettingsEntity::class,
        AuthTokenEntity::class,
        UserEntity::class,
    ],
    version = 1,
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun settingsDao(): SettingsDao

    abstract fun authTokenDao(): AuthTokenEntityDao

    abstract fun userDao(): UserEntityDao
}
