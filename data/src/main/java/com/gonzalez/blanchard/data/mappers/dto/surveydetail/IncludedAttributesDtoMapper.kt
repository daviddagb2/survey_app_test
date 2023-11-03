package com.gonzalez.blanchard.data.mappers.dto.surveydetail

import com.gonzalez.blanchard.domain.models.surveydetail.IncludedAttributesBO
import com.gonzalez.blanchard.remotedatasource.models.surveydetail.IncludedAttributesDto

fun IncludedAttributesDto.toIncludedAttributesBO(): IncludedAttributesBO = IncludedAttributesBO(
    text = this.text ?: "",
    helpText = this.helpText ?: "",
    displayOrder = this.displayOrder ?: 0,
    shortText = this.shortText ?: "",
    pick = this.pick ?: "",
    displayType = this.displayType ?: "",
    isMandatory = this.isMandatory ?: false,
    correctAnswerId = this.correctAnswerId ?: "",
    facebookProfile = this.facebookProfile ?: "",
    twitterProfile = this.twitterProfile ?: "",
    imageUrl = this.imageUrl ?: "",
    coverImageUrl = this.coverImageUrl ?: "",
    coverImageOpacity = this.coverImageOpacity ?: 0.0,
    coverBackgroundColor = this.coverBackgroundColor ?: "",
    isShareableOnFacebook = this.isShareableOnFacebook ?: false,
    isShareableOnTwitter = this.isShareableOnTwitter ?: false,
    fontFace = this.fontFace ?: "",
    fontSize = this.fontSize ?: "",
    tagList = this.tagList ?: "",
)
