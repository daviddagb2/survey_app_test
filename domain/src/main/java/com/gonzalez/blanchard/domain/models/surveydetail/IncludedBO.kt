package com.gonzalez.blanchard.domain.models.surveydetail

data class IncludedBO(
    val id: String,
    val type: String,
    val attributes: IncludedAttributesBO,
    val relationships: RelationshipBO,
)
