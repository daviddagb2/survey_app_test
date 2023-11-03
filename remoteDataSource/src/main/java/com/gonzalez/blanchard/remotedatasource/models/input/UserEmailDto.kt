package com.gonzalez.blanchard.remotedatasource.models.input

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserEmailDto(
    @Json(name = "email") val email: String,
)
