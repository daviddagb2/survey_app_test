package com.gonzalez.blanchard.surveyapptest.view.resetpassword

import androidx.lifecycle.viewModelScope
import com.gonzalez.blanchard.domain.usecases.RecoverPasswordUseCase
import com.gonzalez.blanchard.surveyapptest.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ResetPasswordViewModel @Inject constructor(
    private val recoverPasswordUseCase: RecoverPasswordUseCase,
    ) : BaseViewModel() {

    private val _status = Channel<ResetPasswordStatus>()
    val status = _status.receiveAsFlow()

    private val _action = Channel<ResetPasswordActions>()
    val action = _action.receiveAsFlow()

    fun viewCreated() {
        viewModelScope.launch {
            _action.send(ResetPasswordActions.StopLoading)
        }
    }

    fun resendPassword(email: String) {
        executeUseCase(action = {
            _status.send(ResetPasswordStatus.IsLoading)
            val response = recoverPasswordUseCase.execute(email)
            _action.send(ResetPasswordActions.ShowAlert(response))
        }, exceptionHandler = {
            _status.send(ResetPasswordStatus.Error)
        }, finallyHandler = {
            _action.send(ResetPasswordActions.StopLoading)
        })
    }

    fun onBackToLogin() {
        viewModelScope.launch {
            _action.send(ResetPasswordActions.GoToLogin)
        }
    }
}
