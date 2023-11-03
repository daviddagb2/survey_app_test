package com.gonzalez.blanchard.domain.repository

import com.gonzalez.blanchard.domain.models.SettingsBO

interface ISettingsRepository {
    suspend fun fetchSettings(): List<SettingsBO>
    suspend fun getSetting(key: String): SettingsBO
    suspend fun setSetting(setting: SettingsBO)
}
