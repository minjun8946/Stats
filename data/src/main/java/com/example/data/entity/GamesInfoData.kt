package com.example.data.entity

import com.example.domain.entity.GamesInfo

data class GamesInfoData(
    val data : List<GamesData>,
)

fun GamesInfoData.toEntity() =
    GamesInfo(
        data = data.map { it.toEntity() }
    )