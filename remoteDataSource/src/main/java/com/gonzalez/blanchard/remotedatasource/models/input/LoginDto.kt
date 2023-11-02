package com.gonzalez.blanchard.remotedatasource.models.input

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginDto(
    @Json(name = "grant_type") val grantType: String,
    @Json(name = "email") val email: String,
    @Json(name = "password") val password: String,
    @Json(name = "client_id") val clientId: String,
    @Json(name = "client_secret") val clientSecret: String,
)
