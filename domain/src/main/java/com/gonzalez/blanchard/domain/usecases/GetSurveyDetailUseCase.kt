package com.gonzalez.blanchard.domain.usecases

import com.gonzalez.blanchard.domain.models.surveydetail.SurveyDetailBO
import com.gonzalez.blanchard.domain.repository.ISurveyRepository
import javax.inject.Inject

class GetSurveyDetailUseCase @Inject constructor(
    private val surveyRepository: ISurveyRepository,
) : UseCase<String, SurveyDetailBO>() {

    override suspend fun useCaseFunction(input: String): SurveyDetailBO {
        return surveyRepository.getSurveyDetail(input)
    }
}
