package com.example.data.entity

import com.example.domain.entity.GamesInfo

data class GamesInfoResponse(
    val data : List<GamesData>,
    val meta: MetaData
)

fun GamesInfoResponse.toEntity() =
    GamesInfo(
        data = data.map { it.toEntity() },
        meta = meta.toEntity()
    )