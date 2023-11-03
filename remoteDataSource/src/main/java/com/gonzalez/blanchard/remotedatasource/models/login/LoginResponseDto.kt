package com.gonzalez.blanchard.remotedatasource.models.login

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginResponseDto(
    @Json(name = "data") val data: LoginResponseDataDto?,
)
