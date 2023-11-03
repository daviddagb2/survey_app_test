package com.gonzalez.blanchard.domain.models.surveydetail

data class IncludedAttributesBO(
    val text: String,
    val helpText: String,
    val displayOrder: Int,
    val shortText: String,
    val pick: String,
    val displayType: String,
    val isMandatory: Boolean,
    val correctAnswerId: String,
    val facebookProfile: String,
    val twitterProfile: String,
    val imageUrl: String,
    val coverImageUrl: String,
    val coverImageOpacity: Double,
    val coverBackgroundColor: String,
    val isShareableOnFacebook: Boolean,
    val isShareableOnTwitter: Boolean,
    val fontFace: String,
    val fontSize: String,
    val tagList: String
)
