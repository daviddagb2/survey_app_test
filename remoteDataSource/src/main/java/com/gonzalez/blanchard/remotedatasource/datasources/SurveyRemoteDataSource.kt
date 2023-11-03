package com.gonzalez.blanchard.remotedatasource.datasources

import com.gonzalez.blanchard.remotedatasource.api.SurveyApi
import javax.inject.Inject

class SurveyRemoteDataSource @Inject constructor(
    private val surveyApi: SurveyApi,
) {

}
