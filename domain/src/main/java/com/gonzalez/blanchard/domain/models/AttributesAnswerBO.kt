package com.gonzalez.blanchard.domain.models

data class AttributesAnswerBO(
    val text: String,
    val helpText: String,
    val inputMaskPlaceholder: String,
    val shortText: String,
    val isMandatory: Boolean,
    val isCustomerFirstName: Boolean,
    val isCustomerLastName: Boolean,
    val isCustomerTitle: Boolean,
    val isCustomerEmail: Boolean,
    val promptCustomAnswer: Boolean,
    val weight: Double,
    val displayOrder: Int,
    val displayType: String,
    val inputMask: String,
    val dateConstraint: String,
    val defaultValue: String,
    val responseClass: String,
    val referenceIdentifier: String,
    val score: Int,
    val alerts: List<Any> = listOf(),
)
