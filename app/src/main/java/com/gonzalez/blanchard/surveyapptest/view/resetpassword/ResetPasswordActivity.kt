package com.gonzalez.blanchard.surveyapptest.view.resetpassword

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.gonzalez.blanchard.surveyapptest.R
import com.gonzalez.blanchard.surveyapptest.databinding.ActivityResetPasswordBinding
import com.gonzalez.blanchard.surveyapptest.extensions.launchAndCollect
import com.gonzalez.blanchard.surveyapptest.view.login.LoginActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResetPasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResetPasswordBinding
    private val resetPasswordViewModel by viewModels<ResetPasswordViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResetPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        resetPasswordViewModel.viewCreated()
        initActionsListener()
        initStatusListener()
        initButtonsListeners()
    }

    private fun initActionsListener() {
        this.launchAndCollect(resetPasswordViewModel.action) { action ->
            when (action) {
                ResetPasswordActions.GoToLogin -> goToLogin()
                ResetPasswordActions.StopLoading -> hideLoader()
                is ResetPasswordActions.ShowAlert -> showPasswordRecoveryAlert(action.message)
            }
        }
    }

    private fun initStatusListener() {
        this.launchAndCollect(resetPasswordViewModel.status) { status ->
            when (status) {
                ResetPasswordStatus.IsLoading -> showLoader()
                ResetPasswordStatus.Error -> showError()
            }
        }
    }

    private fun initButtonsListeners() {
        binding.resetBtn.setOnClickListener {
            resetPasswordViewModel.resendPassword(binding.edtEmail.text.toString())
        }

        binding.imgBack.setOnClickListener {
            resetPasswordViewModel.onBackToLogin()
        }
    }

    private fun showError() {
        Toast.makeText(applicationContext, getString(R.string.error_login), Toast.LENGTH_SHORT)
            .show()
    }

    private fun showLoader() {
        binding.progresLoader.isVisible = true
        binding.resetBtn.isEnabled = false
        binding.resetBtn.isVisible = false
    }

    private fun hideLoader() {
        binding.progresLoader.isVisible = false
        binding.resetBtn.isEnabled = true
        binding.resetBtn.isVisible = true
    }

    private fun goToLogin() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

    private fun showPasswordRecoveryAlert(message: String) {
        AlertDialog.Builder(this).apply {
            setTitle(getString(R.string.password_recovery)) // Set your alert dialog title here
            setMessage(message)
            setPositiveButton(android.R.string.ok) { dialog, which ->
            }
            setCancelable(false)
            show()
        }
    }
}
