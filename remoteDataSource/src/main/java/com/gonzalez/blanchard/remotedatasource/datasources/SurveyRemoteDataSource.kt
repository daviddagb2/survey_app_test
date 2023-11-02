package com.gonzalez.blanchard.remotedatasource.datasources

import com.gonzalez.blanchard.extensions.parseResponse
import com.gonzalez.blanchard.remotedatasource.api.SurveyApi
import com.gonzalez.blanchard.remotedatasource.models.LoginResponseDto
import com.gonzalez.blanchard.remotedatasource.models.input.LoginDto
import javax.inject.Inject

class SurveyRemoteDataSource @Inject constructor(
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
