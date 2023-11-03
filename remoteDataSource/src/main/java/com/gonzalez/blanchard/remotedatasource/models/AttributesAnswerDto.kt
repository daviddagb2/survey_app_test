package com.gonzalez.blanchard.remotedatasource.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AttributesAnswerDto(
    @Json(name = "text") val text: String?,
    @Json(name = "help_text") val helpText: String?,
    @Json(name = "input_mask_placeholder") val inputMaskPlaceholder: String?,
    @Json(name = "short_text") val shortText: String?,
    @Json(name = "is_mandatory") val isMandatory: Boolean?,
    @Json(name = "is_customer_first_name") val isCustomerFirstName: Boolean?,
    @Json(name = "is_customer_last_name") val isCustomerLastName: Boolean?,
    @Json(name = "is_customer_title") val isCustomerTitle: Boolean?,
    @Json(name = "is_customer_email") val isCustomerEmail: Boolean?,
    @Json(name = "prompt_custom_answer") val promptCustomAnswer: Boolean?,
    @Json(name = "weight") val weight: Double?,
    @Json(name = "display_order") val displayOrder: Int?,
    @Json(name = "display_type") val displayType: String?,
    @Json(name = "input_mask") val inputMask: String?,
    @Json(name = "date_constraint") val dateConstraint: String?,
    @Json(name = "default_value") val defaultValue: String?,
    @Json(name = "response_class") val responseClass: String?,
    @Json(name = "reference_identifier") val referenceIdentifier: String?,
    @Json(name = "score") val score: Int?,
    @Json(name = "alerts") val alerts: List<Any> = listOf(),
)
