package com.gonzalez.blanchard.surveyapptest.view.main

import androidx.lifecycle.viewModelScope
import com.gonzalez.blanchard.domain.models.input.PageInputBO
import com.gonzalez.blanchard.domain.models.surveylist.SurveyBO
import com.gonzalez.blanchard.domain.usecases.GetSurveyListUseCase
import com.gonzalez.blanchard.domain.usecases.GetUserUseCase
import com.gonzalez.blanchard.domain.usecases.LogoutUseCase
import com.gonzalez.blanchard.surveyapptest.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val getSurveyListUseCase: GetSurveyListUseCase,
    private val getUserUseCase: GetUserUseCase,
    private val logoutUseCase: LogoutUseCase,
) : BaseViewModel() {

    private val _actions = Channel<MainActivityActions>()
    val actions = _actions.receiveAsFlow()

    private val _status = Channel<MainActivityStatus>()
    val status = _status.receiveAsFlow()

    fun viewCreated() {
        viewModelScope.launch {
            getSurveyList()
            getUserDetail()
        }
    }

    fun getSurveyList() {
        executeUseCase(action = {
            _status.send(MainActivityStatus.IsLoading)
            val pageInputBO = PageInputBO(1, 10)
            val result = getSurveyListUseCase.execute(pageInputBO)
            if (result.surveys.isNotEmpty()) {
                _actions.send(MainActivityActions.ShowSurveys(result))
            }
        }, exceptionHandler = {
            _status.send(MainActivityStatus.Error)
        }, finallyHandler = {
            _actions.send(MainActivityActions.StopLoading)
        })
    }

    private fun getUserDetail() {
        executeUseCase(action = {
            val result = getUserUseCase.execute(Unit)
            if (result != null) {
                _actions.send(MainActivityActions.LoadUserData(result))
            }
        }, exceptionHandler = {
        })
    }

    fun onSurveyClicked(survey: SurveyBO) {
        viewModelScope.launch {
            _actions.send(MainActivityActions.GoToSurveyDetail(survey))
        }
    }

    fun logoutClicked() {
        viewModelScope.launch {
            executeUseCase(action = {
                _status.send(MainActivityStatus.IsLoading)
                logoutUseCase.execute(Unit)
                _actions.send(MainActivityActions.Logout)
            }, exceptionHandler = {
            }, finallyHandler = {
                _actions.send(MainActivityActions.StopLoading)
            })
        }
    }
}
