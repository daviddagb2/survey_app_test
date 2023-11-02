package com.gonzalez.blanchard.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CurrentWeatherResponse(
    @Json(name = "observation_time") val observationTime: String?,
    @Json(name = "temperature") val temperature: Int?,
    @Json(name = "weather_code") val weatherCode: Int?,
    @Json(name = "weather_icons") val weatherIcons: List<String>?,
    @Json(name = "weather_descriptions") val weatherDescriptions: List<String>?,
    @Json(name = "wind_speed") val windSpeed: Int?,
    @Json(name = "wind_degree") val windDegree: Int?,
    @Json(name = "wind_dir") val windDirection: String?,
    @Json(name = "pressure") val pressure: Int?,
    @Json(name = "precip") val precipitation: Double?,
    @Json(name = "humidity") val humidity: Int?,
    @Json(name = "cloudcover") val cloudCover: Int?,
    @Json(name = "feelslike") val feelsLike: Int?,
    @Json(name = "uv_index") val uvIndex: Int?,
    @Json(name = "visibility") val visibility: Int?,
    @Json(name = "is_day") val isDay: String?,
)
