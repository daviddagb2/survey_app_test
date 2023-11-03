package com.gonzalez.blanchard.domain.usecases

import com.gonzalez.blanchard.domain.models.input.PageInputBO
import com.gonzalez.blanchard.domain.models.surveylist.SurveyResponseBO
import com.gonzalez.blanchard.domain.repository.ISurveyRepository
import javax.inject.Inject

class GetSurveyListUseCase @Inject constructor(
    private val surveyRepository: ISurveyRepository,
) : UseCase<PageInputBO, SurveyResponseBO>() {

    override suspend fun useCaseFunction(input: PageInputBO): SurveyResponseBO {
        return surveyRepository.fetchSurveyList(input.number, input.size)
    }
}
