package com.gonzalez.blanchard.remotedatasource.datasources

import com.gonzalez.blanchard.extensions.parseResponse
import com.gonzalez.blanchard.remotedatasource.api.SurveyApi
import com.gonzalez.blanchard.remotedatasource.models.UserDto
import javax.inject.Inject

class UserRemoteDataSource @Inject constructor(
    private val surveyApi: SurveyApi,
) {
    suspend fun getUser(): UserDto {
       return surveyApi.getUserProfile().parseResponse()
    }
}
