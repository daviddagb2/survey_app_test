package com.gonzalez.blanchard.remotedatasource.models.surveylist

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SurveyAttributesDto(
    @Json(name = "title") val title: String?,
    @Json(name = "description") val description: String?,
    @Json(name = "thank_email_above_threshold") val thankEmailAboveThreshold: String?,
    @Json(name = "thank_email_below_threshold") val thankEmailBelowThreshold: String?,
    @Json(name = "is_active") val isActive: Boolean?,
    @Json(name = "cover_image_url") val coverImageUrl: String?,
    @Json(name = "created_at") val createdAt: String?,
    @Json(name = "active_at") val activeAt: String?,
    @Json(name = "inactive_at") val inactiveAt: String?,
    @Json(name = "survey_type") val surveyType: String?,
)
