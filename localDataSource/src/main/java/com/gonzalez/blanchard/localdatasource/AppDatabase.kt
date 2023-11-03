package com.gonzalez.blanchard.localdatasource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gonzalez.blanchard.localdatasource.dao.SettingsDao
import com.gonzalez.blanchard.localdatasource.entity.SettingsEntity
@Database(
    entities = [
        SettingsEntity::class,
    ],
    version = 1,
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun settingsDao(): SettingsDao
}
