package com.gonzalez.blanchard.domain

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

/**
 * Base class to handle user case execution
 * @param I Input. Must be the model object that the use case can use to make the request
 * @param O Output.Must be the model object that the use case must return
 */

abstract class UseCase<I, O> {
    suspend fun execute(input: I): O {
        return withContext(dispatcher) { useCaseFunction(input) }
    }

    fun executeSyncInDispatcher(input: I): O {
        return runBlocking {
            withContext(dispatcher) {
                useCaseFunction(input)
            }
        }
    }

    fun executeSyncInCurrentThread(input: I): O {
        return runBlocking {
            useCaseFunction(input)
        }
    }

    protected abstract suspend fun useCaseFunction(input: I): O

    open val dispatcher: CoroutineDispatcher = Dispatchers.IO
}
