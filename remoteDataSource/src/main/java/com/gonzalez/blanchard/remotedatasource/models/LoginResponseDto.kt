package com.gonzalez.blanchard.remotedatasource.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginResponseDto(
    @Json(name = "data") val data: Data,
) {
    @JsonClass(generateAdapter = true)
    data class Data(
        @Json(name = "id") val id: String,
        @Json(name = "type") val type: String,
        @Json(name = "attributes") val attributes: Attributes,
    ) {
        @JsonClass(generateAdapter = true)
        data class Attributes(
            @Json(name = "access_token") val accessToken: String,
            @Json(name = "token_type") val tokenType: String,
            @Json(name = "expires_in") val expiresIn: Int,
            @Json(name = "refresh_token") val refreshToken: String,
            @Json(name = "created_at") val createdAt: Long,
        )
    }
}
