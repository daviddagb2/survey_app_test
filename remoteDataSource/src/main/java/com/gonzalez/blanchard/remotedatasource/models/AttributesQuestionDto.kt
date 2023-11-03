package com.gonzalez.blanchard.remotedatasource.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AttributesQuestionDto(
    @Json(name = "text") val text: String,
    @Json(name = "help_text") val helpText: String?,
    @Json(name = "display_order") val displayOrder: Int,
    @Json(name = "short_text") val shortText: String,
    @Json(name = "pick") val pick: String,
    @Json(name = "display_type") val displayType: String,
    @Json(name = "is_mandatory") val isMandatory: Boolean,
    @Json(name = "correct_answer_id") val correctAnswerId: String?,
    @Json(name = "facebook_profile") val facebookProfile: String?,
    @Json(name = "twitter_profile") val twitterProfile: String?,
    @Json(name = "image_url") val imageUrl: String?,
    @Json(name = "cover_image_url") val coverImageUrl: String?,
    @Json(name = "cover_image_opacity") val coverImageOpacity: Double,
    @Json(name = "cover_background_color") val coverBackgroundColor: String?,
    @Json(name = "is_shareable_on_facebook") val isShareableOnFacebook: Boolean,
    @Json(name = "is_shareable_on_twitter") val isShareableOnTwitter: Boolean,
    @Json(name = "font_face") val fontFace: String?,
    @Json(name = "font_size") val fontSize: String?,
    @Json(name = "tag_list") val tagList: String,
)
