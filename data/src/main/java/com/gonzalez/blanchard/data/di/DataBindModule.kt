package com.gonzalez.blanchard.data.di

import com.gonzalez.blanchard.data.repositories.SettingsRepository
import com.gonzalez.blanchard.domain.repository.ISettingsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataBindModule {

    @Binds
    abstract fun bindSettingsRepository(
        settingsRepository: SettingsRepository,
    ): ISettingsRepository
}
