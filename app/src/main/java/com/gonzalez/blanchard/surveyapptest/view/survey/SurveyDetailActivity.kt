package com.gonzalez.blanchard.surveyapptest.view.survey

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.gonzalez.blanchard.domain.models.surveydetail.QueryItemBO
import com.gonzalez.blanchard.domain.models.surveydetail.SurveyDetailBO
import com.gonzalez.blanchard.surveyapptest.R
import com.gonzalez.blanchard.surveyapptest.constants.ITEM_SURVEY_CLICKED
import com.gonzalez.blanchard.surveyapptest.databinding.ActivitySurveyDetailBinding
import com.gonzalez.blanchard.surveyapptest.extensions.launchAndCollect
import com.gonzalez.blanchard.surveyapptest.extensions.serializable
import com.gonzalez.blanchard.surveyapptest.view.survey.carousel.QuestionAdapter
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SurveyDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySurveyDetailBinding
    private val surveyDetailViewModel by viewModels<SurveyDetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySurveyDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent?.extras?.serializable<String>(ITEM_SURVEY_CLICKED)?.let { surveyId ->
            surveyDetailViewModel.viewCreated(surveyId)
        } ?: run {
            val toast = Toast.makeText(applicationContext, "Unknown Error", Toast.LENGTH_SHORT)
            toast.show()
            finish()
        }

        initActionsListener()
        initStatusListener()
        initButtonsListeners()
    }

    private fun initActionsListener() {
        this.launchAndCollect(surveyDetailViewModel.actions) { actions ->
            when (actions) {
                SurveyDetailActions.StopLoading -> hideLoader()
                is SurveyDetailActions.ShowSurveysDetail -> initSurveyQuestions(actions.response)
                SurveyDetailActions.ShowExitWarning -> showExitWarning(this, ::onConfirmExit)
            }
        }
    }

    private fun initStatusListener() {
        this.launchAndCollect(surveyDetailViewModel.status) { status ->
            when (status) {
                SurveyDetailStatus.IsLoading -> showLoader()
                SurveyDetailStatus.Error -> showError()
                else -> {}
            }
        }
    }

    private fun showLoader() {
       // binding.loaderIndicator.isVisible = true
       // binding.surveyViewPager.isVisible = false
    }

    private fun hideLoader() {
      //  binding.loaderIndicator.isVisible = false
      //  binding.surveyViewPager.isVisible = true
    }

    private fun showError() {
        Toast.makeText(applicationContext, getString(R.string.error_detail), Toast.LENGTH_SHORT)
            .show()
    }

    private fun initSurveyQuestions(response: SurveyDetailBO) {
        Picasso.get().load(response.data.attributes.coverImageUrl).into(binding.backgroundImage)
        val queryList = response.included
            .filter { it.type == "question" }
            .sortedBy { it.attributes.displayOrder }
        binding.surveyQuestionsViewPager.adapter = QuestionAdapter(queryList, ::onQueryItemClicked)
    }

    private fun onQueryItemClicked(queryItem: QueryItemBO) {
        val nextItem = binding.surveyQuestionsViewPager.currentItem + 1
        if (nextItem < binding.surveyQuestionsViewPager.adapter!!.itemCount) {
            binding.surveyQuestionsViewPager.currentItem = nextItem
        } else {
            Toast.makeText(applicationContext, "End of Survey", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initButtonsListeners() {
        binding.imageClose.setOnClickListener() {
            surveyDetailViewModel.onSurveyCloseClicked()
        }

        binding.surveyQuestionsViewPager.apply {
            this.setOnTouchListener { _, _ ->
                true
            }
        }

        binding.surveyQuestionsViewPager.setOnTouchListener { _, _ ->
            true
        }
    }

    fun showExitWarning(context: Context, onConfirmExit: () -> Unit) {
        AlertDialog.Builder(context)
            .setTitle("Warning")
            .setMessage(getString(R.string.exit_warning))
            .setPositiveButton("Yes") { _, _ ->
                onConfirmExit()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
            .setCancelable(false)
            .show()
    }

    private fun onConfirmExit() {
        finish()
    }
}
