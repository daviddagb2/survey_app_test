package com.gonzalez.blanchard.data.mappers.dto

import com.gonzalez.blanchard.domain.models.surveylist.MetaBO
import com.gonzalez.blanchard.remotedatasource.models.MetaDto

fun MetaDto.toMetaBO() : MetaBO = MetaBO(
    page = this.page ?: 0,
    pages = this.pages ?: 0,
    pageSize = this.pageSize ?: 0,
    records = this.records ?: 0,
)