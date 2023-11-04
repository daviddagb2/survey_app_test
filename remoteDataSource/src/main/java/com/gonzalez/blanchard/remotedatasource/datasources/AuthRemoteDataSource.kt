package com.gonzalez.blanchard.remotedatasource.datasources

import com.gonzalez.blanchard.extensions.parseResponse
import com.gonzalez.blanchard.remotedatasource.api.SurveyApi
import com.gonzalez.blanchard.remotedatasource.models.ForgotPasswordDto
import com.gonzalez.blanchard.remotedatasource.models.input.LoginDto
import com.gonzalez.blanchard.remotedatasource.models.input.LogoutRequestDto
import com.gonzalez.blanchard.remotedatasource.models.input.RefreshRequestDto
import com.gonzalez.blanchard.remotedatasource.models.input.RequestPasswordDto
import com.gonzalez.blanchard.remotedatasource.models.login.LoginResponseDto
import javax.inject.Inject

class AuthRemoteDataSource @Inject constructor(
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

    suspend fun logout(
        request: LogoutRequestDto,
    ) {
        surveyApi.logout(request)
    }

    suspend fun refreshToken(refreshRequestDto: RefreshRequestDto): LoginResponseDto {
        return surveyApi.refreshToken(refreshRequestDto).parseResponse()
    }

    suspend fun forgotPassword(requestPasswordDto: RequestPasswordDto): ForgotPasswordDto {
       return surveyApi.forgotPassword(requestPasswordDto).parseResponse()
    }
}
