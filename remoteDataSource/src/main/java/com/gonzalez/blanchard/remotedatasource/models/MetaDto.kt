package com.gonzalez.blanchard.remotedatasource.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MetaDto(
    @Json(name = "page") val page: Int?,
    @Json(name = "pages") val pages: Int?,
    @Json(name = "page_size") val pageSize: Int?,
    @Json(name = "records") val records: Int?,
)
