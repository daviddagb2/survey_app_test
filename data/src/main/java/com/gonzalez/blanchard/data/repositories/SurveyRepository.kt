package com.gonzalez.blanchard.data.repositories

import com.gonzalez.blanchard.data.mappers.bo.toSurveyResponseRequestDto
import com.gonzalez.blanchard.data.mappers.dto.surveydetail.toSurveyDetailBO
import com.gonzalez.blanchard.data.mappers.dto.toSurveyResponseBO
import com.gonzalez.blanchard.domain.models.surveydetail.SurveyDetailBO
import com.gonzalez.blanchard.domain.models.surveylist.SurveyResponseBO
import com.gonzalez.blanchard.domain.models.surveyresponses.SurveyResponseRequestBO
import com.gonzalez.blanchard.domain.repository.ISurveyRepository
import com.gonzalez.blanchard.remotedatasource.datasources.AuthRemoteDataSource
import com.gonzalez.blanchard.remotedatasource.datasources.SurveyRemoteDataSource
import javax.inject.Inject

class SurveyRepository @Inject constructor(
    private val surveyRemoteDataSource: SurveyRemoteDataSource,
    private val authRemoteDataSource: AuthRemoteDataSource,
) : ISurveyRepository {
        override suspend fun fetchSurveyList(pageNumber: Int, pageSize: Int): SurveyResponseBO {
            val response = surveyRemoteDataSource.getSurveyList(pageNumber, pageSize)
            return response.toSurveyResponseBO()
        }

        override suspend fun getSurveyDetail(surveyId: String): SurveyDetailBO {
            val response = surveyRemoteDataSource.getSurveyDetail(surveyId)
            return response.toSurveyDetailBO()
        }

        override suspend fun postSurveyResponse(request: SurveyResponseRequestBO) {
            surveyRemoteDataSource.postSurveyResponse(request.toSurveyResponseRequestDto())
        }
    }
