package com.gonzalez.blanchard.surveyapptest.view.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.isVisible
import com.gonzalez.blanchard.domain.models.UserBO
import com.gonzalez.blanchard.domain.models.surveylist.SurveyBO
import com.gonzalez.blanchard.surveyapptest.R
import com.gonzalez.blanchard.surveyapptest.constants.ITEM_SURVEY_CLICKED
import com.gonzalez.blanchard.surveyapptest.databinding.ActivityMainBinding
import com.gonzalez.blanchard.surveyapptest.extensions.launchAndCollect
import com.gonzalez.blanchard.surveyapptest.view.main.carousel.SurveyAdapter
import com.gonzalez.blanchard.surveyapptest.view.survey.SurveyDetailActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import jp.wasabeef.picasso.transformations.CropCircleTransformation
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

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

        setCurrentDate()

        hideLoader()
        configureDrawer()
    }

    private fun initActionsListener() {
        this.launchAndCollect(mainActivityViewModel.actions) { actions ->
            when (actions) {
                MainActivityActions.StopLoading -> hideLoader()
                is MainActivityActions.GoToSurveyDetail -> goToSurveyDetail(actions.survey)
                is MainActivityActions.ShowSurveys -> initViewPager(actions.response.surveys)
                is MainActivityActions.LoadUserData -> loadUserData(actions.userBO)
                MainActivityActions.Logout -> finish()
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

        // Dots for viewpager
        TabLayoutMediator(binding.tabDots, binding.surveyViewPager) { tab, position -> }.attach()
        binding.tabDots.touchables.forEach { it.isEnabled = false }
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
            binding.drawerLayout.openDrawer(GravityCompat.END)
        }
    }

    private fun setCurrentDate() {
        val dateFormat = SimpleDateFormat("EEEE, MMMM d", Locale.getDefault())
        val date = Date()
        val todayDate = dateFormat.format(date)
        binding.datetime.text = todayDate.uppercase()
    }

    private fun loadUserData(userBO: UserBO) {
        if (userBO.avatarUrl.isEmpty()) return
        Picasso.get().load(userBO.avatarUrl)
            .transform(CropCircleTransformation())
            .into(binding.imageAvatar)
        binding.navView.getHeaderView(0).findViewById<com.google.android.material.textview.MaterialTextView>(R.id.txtUserName).text = userBO.name

        Picasso.get().load(userBO.avatarUrl)
            .transform(CropCircleTransformation())
            .into(binding.navView.getHeaderView(0).findViewById<ImageView>(R.id.profileImage))
    }

    private fun showError() {
        Toast.makeText(applicationContext, getString(R.string.error_main), Toast.LENGTH_SHORT)
            .show()
    }

    private fun configureDrawer() {
        binding.navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_logout -> {
                    showLogoutWarning(this)
                }
            }
            binding.drawerLayout.closeDrawer(GravityCompat.END)
            true
        }
    }

    private fun showLogoutWarning(context: Context) {
        AlertDialog.Builder(context)
            .setTitle("Warning")
            .setMessage(getString(R.string.exit_logout))
            .setPositiveButton("Logout") { _, _ ->
                mainActivityViewModel.logoutClicked()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
            .setCancelable(false)
            .show()
    }

    override fun onStart() {
        super.onStart()
        binding.drawerLayout.closeDrawer(GravityCompat.END)
    }
}
