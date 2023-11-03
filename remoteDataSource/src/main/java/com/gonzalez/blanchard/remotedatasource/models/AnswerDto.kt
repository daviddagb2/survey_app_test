package com.gonzalez.blanchard.remotedatasource.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AnswerDto(
    @Json(name = "data") val data: List<Any>?,
)
