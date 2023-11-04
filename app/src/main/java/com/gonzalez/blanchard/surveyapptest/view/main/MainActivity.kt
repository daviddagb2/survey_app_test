package com.gonzalez.blanchard.surveyapptest.view.main

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.gonzalez.blanchard.domain.models.surveylist.SurveyBO
import com.gonzalez.blanchard.surveyapptest.R
import com.gonzalez.blanchard.surveyapptest.constants.ITEM_SURVEY_CLICKED
import com.gonzalez.blanchard.surveyapptest.databinding.ActivityMainBinding
import com.gonzalez.blanchard.surveyapptest.extensions.launchAndCollect
import com.gonzalez.blanchard.surveyapptest.view.main.carousel.SurveyAdapter
import com.gonzalez.blanchard.surveyapptest.view.survey.SurveyDetailActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainActivityViewModel by viewModels<MainActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Init Method
        mainActivityViewModel.viewCreated()

        initActionsListener()
        initStatusListener()
        initButtonsListeners()

        hideLoader()
    }

    private fun initActionsListener() {
        this.launchAndCollect(mainActivityViewModel.actions) { actions ->
            when (actions) {
                MainActivityActions.StopLoading -> hideLoader()
                is MainActivityActions.GoToSurveyDetail -> goToSurveyDetail(actions.survey)
                is MainActivityActions.ShowSurveys -> initViewPager(actions.response.surveys)
                else -> {}
            }
        }
    }

    private fun initStatusListener() {
        this.launchAndCollect(mainActivityViewModel.status) { status ->
            when (status) {
                MainActivityStatus.IsLoading -> showLoader()
                MainActivityStatus.Error -> showError()
                else -> {}
            }
        }
    }

    private fun initViewPager(surveyList: List<SurveyBO>) {
       binding.surveyViewPager.adapter = SurveyAdapter(surveyList, ::onSurveyClicked)
    }

    private fun onSurveyClicked(survey: SurveyBO) {
        mainActivityViewModel.onSurveyClicked(survey)
    }

    private fun goToSurveyDetail(survey: SurveyBO) {
        Intent(this, SurveyDetailActivity::class.java).apply {
            putExtra(ITEM_SURVEY_CLICKED, survey.id)
        }.let {
            startActivity(it)
        }
    }

    private fun showLoader() {
        binding.loaderIndicator.isVisible = true
        binding.surveyViewPager.isVisible = false
    }

    private fun hideLoader() {
        binding.loaderIndicator.isVisible = false
        binding.surveyViewPager.isVisible = true
    }

    private fun initButtonsListeners() {
        binding.imageAvatar.setOnClickListener() {
            // mainActivityViewModel.onProfileClicked()
            Toast.makeText(applicationContext, "Avatar Clicked", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showError() {
        Toast.makeText(applicationContext, getString(R.string.error_main), Toast.LENGTH_SHORT)
            .show()
    }
}
