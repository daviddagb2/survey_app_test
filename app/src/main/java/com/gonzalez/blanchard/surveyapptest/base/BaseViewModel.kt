package com.gonzalez.blanchard.surveyapptest.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    protected fun executeUseCase(
        action: suspend CoroutineScope.() -> Unit,
        exceptionHandler: suspend (Throwable) -> Unit,
        finallyHandler: (suspend () -> Unit)? = null,
    ) {
        viewModelScope.launch {
            try {
                action.invoke(this)
            } catch (e: Throwable) {
                exceptionHandler.invoke(e)
            } finally {
                finallyHandler?.invoke()
            }
        }
    }
}
