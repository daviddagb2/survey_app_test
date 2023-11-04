package com.gonzalez.blanchard.surveyapptest.view.login

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.gonzalez.blanchard.surveyapptest.R
import com.gonzalez.blanchard.surveyapptest.databinding.ActivityLoginBinding
import com.gonzalez.blanchard.surveyapptest.extensions.launchAndCollect
import com.gonzalez.blanchard.surveyapptest.view.main.MainActivity
import com.gonzalez.blanchard.surveyapptest.view.resetpassword.ResetPasswordActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val loginViewModel by viewModels<LoginViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loginViewModel.viewCreated()
        initActionsListener()
        initStatusListener()
        initButtonsListeners()
        initTextWatchers()

        // Initial validation
        validateInputs(binding.edtEmail.text.toString(), binding.edtPassword.text.toString())
    }

    private fun initActionsListener() {
        this.launchAndCollect(loginViewModel.action) { action ->
            when (action) {
                LoginActions.GoToMain -> goToMain()
                LoginActions.StopLoading -> hideLoader()
                LoginActions.GoToForgotPassword -> goToForgot()
            }
        }
    }

    private fun initStatusListener() {
        this.launchAndCollect(loginViewModel.status) { status ->
            when (status) {
                LoginStatus.IsLoading -> showLoader()
                LoginStatus.ErrorLogin -> showError()
            }
        }
    }

    private fun showError() {
        Toast.makeText(applicationContext, getString(R.string.error_login), Toast.LENGTH_SHORT)
            .show()
    }

    private fun showLoader() {
        binding.progresLoader.isVisible = true
        binding.edtEmail.isEnabled = false
        binding.edtPassword.isEnabled = false
        binding.loginBtn.isEnabled = false
        binding.loginBtn.isVisible = false
    }

    private fun hideLoader() {
        binding.progresLoader.isVisible = false
        binding.edtEmail.isEnabled = true
        binding.edtPassword.isEnabled = true
        binding.loginBtn.isEnabled = true
        binding.loginBtn.isVisible = true
    }

    private fun goToMain() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    private fun goToForgot() {
        startActivity(Intent(this, ResetPasswordActivity::class.java))
        finish()
    }

    private fun initButtonsListeners() {
        binding.loginBtn.setOnClickListener {
            loginViewModel.doLogin(
                binding.edtEmail.text.toString(),
                binding.edtPassword.text.toString(),
            )
        }

        binding.txtForgot.setOnClickListener() {
            loginViewModel.forgotPassword()
        }
    }

    private fun initTextWatchers() {
        binding.edtEmail.addTextChangedListener(emailTextWatcher)
        binding.edtPassword.addTextChangedListener(passwordTextWatcher)
    }

    private val emailTextWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            val email = s.toString()
            val password = binding.edtPassword.text.toString()
            validateInputs(email, password)
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
    }

    private val passwordTextWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            val email = binding.edtEmail.text.toString()
            val password = s.toString()
            validateInputs(email, password)
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
    }

    private fun validateInputs(email: String, password: String) {
        val isEmailValid = android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
        val isPasswordValid = password.length >= 6
        binding.loginBtn.isEnabled = isEmailValid && isPasswordValid
    }
}
