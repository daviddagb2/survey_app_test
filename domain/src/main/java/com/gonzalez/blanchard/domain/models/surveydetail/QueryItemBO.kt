package com.gonzalez.blanchard.domain.models.surveydetail

data class QueryItemBO(
    val id: String,
    val type: String,
    val attributes: IncludedAttributesBO,
    val relationships: RelationshipBO,
)
