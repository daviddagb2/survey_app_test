package com.gonzalez.blanchard.data.di

import com.gonzalez.blanchard.data.repositories.AuthRepository
import com.gonzalez.blanchard.data.repositories.SettingsRepository
import com.gonzalez.blanchard.data.repositories.SurveyRepository
import com.gonzalez.blanchard.data.repositories.UserRepository
import com.gonzalez.blanchard.domain.repository.IAuthRepository
import com.gonzalez.blanchard.domain.repository.ISettingsRepository
import com.gonzalez.blanchard.domain.repository.ISurveyRepository
import com.gonzalez.blanchard.domain.repository.IUserRepository
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

    @Binds
    abstract fun bindUserRepository(
        userRepository: UserRepository,
    ): IUserRepository

    @Binds
    abstract fun bindAuthRepository(
        userRepository: AuthRepository,
    ): IAuthRepository

    @Binds
    abstract fun bindSurveyRepository(
        userRepository: SurveyRepository,
    ): ISurveyRepository
}
