package com.gonzalez.blanchard.data.mappers.entity

import com.gonzalez.blanchard.domain.models.AuthTokenBO
import com.gonzalez.blanchard.localdatasource.entity.AuthTokenEntity

fun AuthTokenEntity.toAuthTokenBO(): AuthTokenBO = AuthTokenBO(
    id = this.id,
    type = this.type,
    accessToken = this.accessToken,
    tokenType = this.tokenType,
    expiresIn = this.expiresIn,
    refreshToken = this.refreshToken,
    createdAt = this.createdAt,
)
