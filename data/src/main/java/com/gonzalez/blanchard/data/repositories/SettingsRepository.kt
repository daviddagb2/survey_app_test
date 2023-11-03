package com.gonzalez.blanchard.data.repositories

import com.gonzalez.blanchard.data.mappers.entity.toEntity
import com.gonzalez.blanchard.data.mappers.entity.toSettingsBO
import com.gonzalez.blanchard.domain.models.SettingsBO
import com.gonzalez.blanchard.domain.repository.ISettingsRepository
import com.gonzalez.blanchard.localdatasource.datasources.SettingsLocalDataSource
import javax.inject.Inject

class SettingsRepository @Inject constructor(
    private val settingsLocalDataSource: SettingsLocalDataSource,
) : ISettingsRepository {
    override suspend fun fetchSettings(): List<SettingsBO> {
        return settingsLocalDataSource.getAllSettings().map { it.toSettingsBO() }
    }

    override suspend fun getSetting(key: String): SettingsBO {
        return settingsLocalDataSource.getSettings(key)?.toSettingsBO()
            ?: SettingsBO("", "")
    }

    override suspend fun setSetting(setting: SettingsBO) {
        settingsLocalDataSource.insertSettings(setting.toEntity())
    }
}
