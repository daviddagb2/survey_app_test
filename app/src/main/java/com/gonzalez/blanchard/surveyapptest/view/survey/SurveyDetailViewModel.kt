package com.gonzalez.blanchard.surveyapptest.view.survey

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.gonzalez.blanchard.domain.models.surveydetail.SurveyDetailBO
import com.gonzalez.blanchard.domain.usecases.GetSurveyDetailUseCase
import com.gonzalez.blanchard.surveyapptest.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SurveyDetailViewModel @Inject constructor(
    private val getSurveyDetailUseCase: GetSurveyDetailUseCase,
) : BaseViewModel() {

    private val _status = Channel<SurveyDetailStatus>()
    val status = _status.receiveAsFlow()

    private val _actions = Channel<SurveyDetailActions>()
    val actions = _actions.receiveAsFlow()

    private var _currentSurvey = MutableLiveData<SurveyDetailBO>()
    val characterItemState: MutableLiveData<SurveyDetailBO> = _currentSurvey

    fun viewCreated(surveyId: String) {
        viewModelScope.launch {
            _actions.send(SurveyDetailActions.StopLoading)
            getSurveyDetail(surveyId)
        }
    }

    fun getSurveyDetail(surveyId: String) {
        executeUseCase(action = {
            _status.send(SurveyDetailStatus.IsLoading)
            _currentSurvey.value = getSurveyDetailUseCase.execute(surveyId)
            if (_currentSurvey.value != null) {
                _actions.send(SurveyDetailActions.ShowSurveysDetail(_currentSurvey.value!!))
            }
            _actions.send(SurveyDetailActions.StopLoading)
        }, exceptionHandler = {
            _status.send(SurveyDetailStatus.Error)
        }, finallyHandler = {
            _actions.send(SurveyDetailActions.StopLoading)
        })
    }

    fun onSurveyCloseClicked() {
        viewModelScope.launch {
            _actions.send(SurveyDetailActions.ShowExitWarning)
        }
    }
}
