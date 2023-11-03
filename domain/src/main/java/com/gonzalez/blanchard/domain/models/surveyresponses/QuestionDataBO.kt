package com.gonzalez.blanchard.domain.models.surveyresponses

data class QuestionDataBO(
    val id: String,
    val answers: List<AnswerDataBO>,
)
