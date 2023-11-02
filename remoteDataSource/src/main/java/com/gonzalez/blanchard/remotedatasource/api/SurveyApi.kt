package com.gonzalez.blanchard.remotedatasource.api

import com.gonzalez.blanchard.remotedatasource.models.LoginResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SurveyApi {
    @GET("/api/v1/oauth/token")
    suspend fun loginWithEmail(
        @Query("grant_type") grantType: String,
        @Query("email") email: String,
        @Query("password") password: String,
        @Query("client_id") clientId: String,
        @Query("client_secret") clientSecret: String,
    ): Response<LoginResponseDto>
}
