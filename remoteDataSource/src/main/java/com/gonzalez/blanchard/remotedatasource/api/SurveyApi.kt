package com.gonzalez.blanchard.remotedatasource.api

import com.gonzalez.blanchard.remotedatasource.models.surveylist.SurveyResponseDto
import com.gonzalez.blanchard.remotedatasource.models.UserDto
import com.gonzalez.blanchard.remotedatasource.models.input.LogoutRequestDto
import com.gonzalez.blanchard.remotedatasource.models.input.UserRequestDto
import com.gonzalez.blanchard.remotedatasource.models.login.LoginResponseDto
import com.gonzalez.blanchard.remotedatasource.models.surveydetail.SurveyDetailDto
import com.gonzalez.blanchard.remotedatasource.models.surveyresponses.SurveyResponseRequestDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface SurveyApi {
    @POST("/api/v1/oauth/token")
    suspend fun loginWithEmail(
        @Query("grant_type") grantType: String,
        @Query("email") email: String,
        @Query("password") password: String,
        @Query("client_id") clientId: String,
        @Query("client_secret") clientSecret: String,
    ): Response<LoginResponseDto>

    @POST("/api/v1/oauth/revoke")
    suspend fun logout(
        @Body request: LogoutRequestDto,
    )

    @POST("/api/v1/passwords")
    suspend fun forgotPassword(
        @Body request: UserRequestDto,
    )

    @GET("/api/v1/me")
    suspend fun getUserProfile(): Response<UserDto>

    @GET("api/v1/surveys")
    suspend fun getSurveyList(
        @Query("page[number]") pageNumber: Int,
        @Query("page[size]") pageSize: Int,
    ): Response<SurveyResponseDto>

    @GET("/api/v1/surveys/{surveyId}")
    suspend fun getSurvey(@Path("surveyId") surveyId: String): Response<SurveyDetailDto>

    @POST("/api/v1/responses")
    suspend fun postSurveyResponse(@Body request: SurveyResponseRequestDto)
}
