package com.gonzalez.blanchard.surveyapptest.view.main

import androidx.lifecycle.viewModelScope
import com.gonzalez.blanchard.surveyapptest.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor() : BaseViewModel() {

    private val _actions = Channel<MainActivityActions>()
    val actions = _actions.receiveAsFlow()

    fun viewCreated() {
        viewModelScope.launch {
            _actions.send(MainActivityActions.LoadContent)
        }
    }
}
