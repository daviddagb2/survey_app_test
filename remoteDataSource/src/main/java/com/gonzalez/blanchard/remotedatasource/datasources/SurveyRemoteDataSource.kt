package com.gonzalez.blanchard.remotedatasource.datasources

import com.gonzalez.blanchard.extensions.parseResponse
import com.gonzalez.blanchard.remotedatasource.api.SurveyApi
import com.gonzalez.blanchard.remotedatasource.models.surveylist.SurveyResponseDto
import com.gonzalez.blanchard.remotedatasource.models.surveydetail.SurveyDetailDto
import com.gonzalez.blanchard.remotedatasource.models.surveyresponses.SurveyResponseRequestDto
import javax.inject.Inject

class SurveyRemoteDataSource @Inject constructor(
    private val surveyApi: SurveyApi,
) {

    suspend fun getSurveyList(pageNumber: Int, pageSize: Int): SurveyResponseDto {
        return surveyApi.getSurveyList(pageNumber, pageSize).parseResponse()
    }

    suspend fun getSurveyDetail(surveyId: String): SurveyDetailDto {
        return surveyApi.getSurvey(surveyId).parseResponse()
    }

    suspend fun postSurveyResponse(request: SurveyResponseRequestDto) {
        return surveyApi.postSurveyResponse(request)
    }
}
