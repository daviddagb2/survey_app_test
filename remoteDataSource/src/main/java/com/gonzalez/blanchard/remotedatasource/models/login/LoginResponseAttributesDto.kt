package com.gonzalez.blanchard.remotedatasource.models.login

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginResponseAttributesDto(
    @Json(name = "access_token") val accessToken: String?,
    @Json(name = "token_type") val tokenType: String?,
    @Json(name = "expires_in") val expiresIn: Int?,
    @Json(name = "refresh_token") val refreshToken: String?,
    @Json(name = "created_at") val createdAt: String?,
)
