package com.gonzalez.blanchard.remotedatasource.models.input

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserRequestDto(
    @Json(name = "user") val user: UserEmailDto,
    @Json(name = "client_id") val clientId: String,
    @Json(name = "client_secret") val clientSecret: String,
)
