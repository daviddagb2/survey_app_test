package com.gonzalez.blanchard.data.mappers.dto

import com.gonzalez.blanchard.domain.models.UserBO
import com.gonzalez.blanchard.remotedatasource.models.UserDto

fun UserDto.toUserBO(): UserBO = UserBO(
    id = this.data?.id ?: "",
    type = this.data?.type ?: "",
    email = this.data?.attributes?.email ?: "",
    name = this.data?.attributes?.name ?: "",
    avatarUrl = this.data?.attributes?.avatarUrl ?: "",
)
