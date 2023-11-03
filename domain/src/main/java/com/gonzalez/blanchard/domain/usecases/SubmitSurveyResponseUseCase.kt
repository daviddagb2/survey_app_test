package com.gonzalez.blanchard.domain.usecases

import com.gonzalez.blanchard.domain.models.surveyresponses.SurveyResponseRequestBO
import com.gonzalez.blanchard.domain.repository.ISurveyRepository
import javax.inject.Inject

class SubmitSurveyResponseUseCase @Inject constructor(
    private val surveyRepository: ISurveyRepository,
) : UseCase<SurveyResponseRequestBO, Unit>() {

    override suspend fun useCaseFunction(request: SurveyResponseRequestBO) {
        return surveyRepository.postSurveyResponse(request)
    }
}
