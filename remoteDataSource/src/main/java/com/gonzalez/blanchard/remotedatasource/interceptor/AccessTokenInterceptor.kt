package com.gonzalez.blanchard.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject

class AccessTokenInterceptor @Inject constructor() : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val accessToken = getUserAccessToken()

        // Adds the Bearer token to the Authorization header
        val newRequest = originalRequest.newBuilder()
            .header("Authorization", "Bearer $accessToken")
            .build()

        return chain.proceed(newRequest)
    }

    private fun getUserAccessToken(): String {
        // TODO: Change this to get the real acces token
        return "6whcvBsM6ks3WOGVWjT-y_4QVXDTlM4aeiQsozsZya8"
    }
}
