package com.gonzalez.blanchard.remotedatasource.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserDto(
    @Json(name = "data") val data: UserData?,
)

@JsonClass(generateAdapter = true)
data class UserData(
    @Json(name = "id") val id: String?,
    @Json(name = "type") val type: String?,
    @Json(name = "attributes") val attributes: UserDataAttributes?,
)

@JsonClass(generateAdapter = true)
data class UserDataAttributes(
    @Json(name = "email") val email: String?,
    @Json(name = "name") val name: String?,
    @Json(name = "avatar_url") val avatarUrl: Int?,
)
