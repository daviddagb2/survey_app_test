package com.gonzalez.blanchard.remotedatasource.datasources

import com.gonzalez.blanchard.extensions.parseResponse
import com.gonzalez.blanchard.remotedatasource.api.SurveyApi
import com.gonzalez.blanchard.remotedatasource.models.input.LoginDto
import com.gonzalez.blanchard.remotedatasource.models.login.LoginResponseDto
import javax.inject.Inject

class UserRemoteDataSource @Inject constructor(
    private val surveyApi: SurveyApi,
) {
    suspend fun login(
        loginDto: LoginDto,
    ): LoginResponseDto {
        return surveyApi.loginWithEmail(
            loginDto.grantType,
            loginDto.email,
            loginDto.password,
            loginDto.clientId,
            loginDto.clientSecret,
        ).parseResponse()
    }
}
