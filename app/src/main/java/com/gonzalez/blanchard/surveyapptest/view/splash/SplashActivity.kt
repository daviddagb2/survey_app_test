package com.gonzalez.blanchard.surveyapptest.view.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.gonzalez.blanchard.surveyapptest.databinding.ActivitySplashBinding
import com.gonzalez.blanchard.surveyapptest.extensions.launchAndCollect
import com.gonzalez.blanchard.surveyapptest.view.login.LoginActivity
import com.gonzalez.blanchard.surveyapptest.view.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    private val splashViewModel by viewModels<SplashViewModel>()
    private val splashDuration: Long = 2000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initActionsListener()

        // Delay to show splash
        Handler(Looper.getMainLooper()).postDelayed({
            splashViewModel.viewCreated()
        }, splashDuration)
    }

    private fun initActionsListener() {
        this.launchAndCollect(splashViewModel.action) { action ->
            when (action) {
                SplashActions.GoToMain -> goToMain()
                SplashActions.GoToLogin -> goToLogin()
            }
        }
    }

    private fun goToMain() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    private fun goToLogin() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}
