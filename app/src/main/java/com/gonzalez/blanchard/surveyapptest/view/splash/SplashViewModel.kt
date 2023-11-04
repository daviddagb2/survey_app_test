package com.gonzalez.blanchard.surveyapptest.view.splash

import com.gonzalez.blanchard.domain.usecases.GetAuthUseCase
import com.gonzalez.blanchard.domain.usecases.GetUserUseCase
import com.gonzalez.blanchard.domain.usecases.RefreshTokenUseCase
import com.gonzalez.blanchard.surveyapptest.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase,
    private val getAuthUseCase: GetAuthUseCase,
    private val refreshTokenUseCase: RefreshTokenUseCase,
) : BaseViewModel() {

    private val _actions = Channel<SplashActions>()
    val action = _actions.receiveAsFlow()

    fun viewCreated() {
        checkAuth()
    }

    private fun checkAuth() {
        executeUseCase(
            action = {
                withContext(NonCancellable) {
                   val authToken = getAuthUseCase.execute(Unit)
                    if (authToken.accessToken.isEmpty()) {
                        _actions.send(SplashActions.GoToLogin)
                    } else {
                        refreshTokenUseCase.execute(Unit)
                        _actions.send(SplashActions.GoToMain)
                    }
                }
            },
            exceptionHandler = {
                _actions.send(SplashActions.GoToLogin)
            },
            finallyHandler = {
            },
        )
    }
}
