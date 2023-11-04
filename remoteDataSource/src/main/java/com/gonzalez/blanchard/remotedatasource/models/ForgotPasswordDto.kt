package com.gonzalez.blanchard.remotedatasource.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ForgotPasswordDto(
    @Json(name = "meta") val meta: ForgotPassMetaDto,
)

@JsonClass(generateAdapter = true)
data class ForgotPassMetaDto(
    @Json(name = "message") val message: String,
)
