package com.gonzalez.blanchard.domain.repository

import com.gonzalez.blanchard.domain.models.surveydetail.SurveyDetailBO
import com.gonzalez.blanchard.domain.models.surveylist.SurveyResponseBO
import com.gonzalez.blanchard.domain.models.surveyresponses.SurveyResponseRequestBO

interface ISurveyRepository {
    suspend fun fetchSurveyList(pageNumber: Int, pageSize: Int): SurveyResponseBO
    suspend fun getSurveyDetail(surveyId: String): SurveyDetailBO
    suspend fun postSurveyResponse(request: SurveyResponseRequestBO)
}
