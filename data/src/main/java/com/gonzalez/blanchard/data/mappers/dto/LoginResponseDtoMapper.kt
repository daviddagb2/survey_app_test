package com.gonzalez.blanchard.data.mappers.dto

import com.gonzalez.blanchard.localdatasource.entity.AuthTokenEntity
import com.gonzalez.blanchard.remotedatasource.models.login.LoginResponseDto

fun LoginResponseDto.toTokenEntity(): AuthTokenEntity = AuthTokenEntity(
    fixedId = 1,
    id = this.data?.id ?: "",
    type = this.data?.type ?: "",
    accessToken = this.data?.attributes?.accessToken ?: "",
    tokenType = this.data?.attributes?.tokenType ?: "",
    expiresIn = this.data?.attributes?.expiresIn ?: 0,
    refreshToken = this.data?.attributes?.refreshToken ?: "",
    createdAt = this.data?.attributes?.createdAt ?: "0",
)
