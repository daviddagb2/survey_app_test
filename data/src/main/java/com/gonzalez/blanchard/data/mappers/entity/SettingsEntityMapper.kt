package com.gonzalez.blanchard.data.mappers.entity

import com.gonzalez.blanchard.domain.models.SettingsBO
import com.gonzalez.blanchard.localdatasource.entity.SettingsEntity

fun SettingsEntity.toSettingsBO(): SettingsBO = SettingsBO(
    key = this.keyVal,
    value = this.value,
)

fun SettingsBO.toEntity(): SettingsEntity = SettingsEntity(
    keyVal = this.key,
    value = this.value,
)
