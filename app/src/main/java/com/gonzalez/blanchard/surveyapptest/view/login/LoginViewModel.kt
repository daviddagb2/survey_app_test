package com.gonzalez.blanchard.surveyapptest.view.login

import androidx.lifecycle.viewModelScope
import com.gonzalez.blanchard.domain.models.input.LoginInputBO
import com.gonzalez.blanchard.domain.usecases.LoginUseCase
import com.gonzalez.blanchard.surveyapptest.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
) : BaseViewModel() {

    private val _status = Channel<LoginStatus>()
    val status = _status.receiveAsFlow()

    private val _action = Channel<LoginActions>()
    val action = _action.receiveAsFlow()

    fun viewCreated() {
        viewModelScope.launch {
            _action.send(LoginActions.StopLoading)
        }
    }

    fun doLogin(email: String, password: String) {
        executeUseCase(action = {
            _status.send(LoginStatus.IsLoading)
            loginUseCase.execute(LoginInputBO(email, password))
            _action.send(LoginActions.GoToMain)
        }, exceptionHandler = {
            _status.send(LoginStatus.ErrorLogin)
        }, finallyHandler = {
            _action.send(LoginActions.StopLoading)
        })
    }
}
