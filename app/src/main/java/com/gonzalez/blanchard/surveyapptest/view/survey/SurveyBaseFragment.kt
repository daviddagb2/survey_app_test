package com.gonzalez.blanchard.surveyapptest.view.survey

import androidx.fragment.app.Fragment

class SurveyBaseFragment : Fragment() {

    private lateinit var questionTitle: String
    private lateinit var questionDescription: String

    fun setQuestion(title: String, description: String) {
        questionTitle = title
        questionDescription = description
    }
}
