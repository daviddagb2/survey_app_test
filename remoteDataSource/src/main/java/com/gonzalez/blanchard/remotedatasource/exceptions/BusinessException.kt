package com.gonzalez.blanchard.exceptions

open class BusinessException(
    val errorType: ErrorType = ErrorType.UNEXPECTED,
    message: String? = null,
    cause: Throwable? = null,
) : Exception(message, cause)
