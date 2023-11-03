package com.gonzalez.blanchard.localdatasource.datasources

import com.gonzalez.blanchard.localdatasource.AppDatabase
import com.gonzalez.blanchard.localdatasource.entity.SettingsEntity
import javax.inject.Inject

class SettingsLocalDataSource @Inject constructor(appDatabase: AppDatabase) {

    private val settingsDao = appDatabase.settingsDao()

    suspend fun getAllSettings(): List<SettingsEntity> {
        return settingsDao.getAll()
    }

    suspend fun insertSettings(entity: SettingsEntity) {
        settingsDao.insert(entity)
    }

    suspend fun getSettings(key: String): SettingsEntity? {
        val settings = settingsDao.getDetail(key)

        if (settings.isEmpty()) return SettingsEntity(keyVal = key, value = "")
        return settings.first()
    }

    suspend fun deleteAllSettings() {
        settingsDao.deleteAll()
    }
}
