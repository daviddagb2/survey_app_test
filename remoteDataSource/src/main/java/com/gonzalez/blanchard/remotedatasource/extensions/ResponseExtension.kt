package com.gonzalez.blanchard.extensions

import androidx.annotation.VisibleForTesting
import com.gonzalez.blanchard.exceptions.BusinessException
import com.gonzalez.blanchard.exceptions.ErrorType
import okhttp3.ResponseBody
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response

fun <T> Response<T>.parseResponse(): T {
    val body = this.body()
    if (this.isSuccessful && body != null) {
        return body
    } else {
        throw BusinessException(
            getErrorType(this.code(), this.errorBody()),
            "$this.code() $this.message()",
        )
    }
}

fun <T> Response<T>.parseEmptyResponse() {
    if (!this.isSuccessful) {
        throw BusinessException(
            getErrorType(
                this.code(),
                this.errorBody(),
            ),
            "$this.code() $this.message()",
        )
    }
}

@VisibleForTesting
fun getErrorType(code: Int, errorBody: ResponseBody?): ErrorType {
    return when (code) {
        401 -> ErrorType.UNAUTHORIZED
        403 -> get403Type(errorBody)
        409 -> ErrorType.CONFLICT
        else -> ErrorType.UNEXPECTED
    }
}

private fun get403Type(errorBody: ResponseBody?): ErrorType {
    return try {
        val jsonObject = JSONObject(errorBody?.string() ?: "")
        when (jsonObject.getString("reason").lowercase()) {
            else -> ErrorType.UNEXPECTED
        }
    } catch (e: JSONException) {
        ErrorType.UNEXPECTED
    }
}
