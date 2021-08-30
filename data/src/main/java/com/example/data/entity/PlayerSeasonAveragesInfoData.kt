package com.example.data.entity

import com.example.domain.entity.PlayerSeasonAveragesInfo

data class PlayerSeasonAveragesInfoData(
    val data : List<PlayerSeasonAveragesData>
)

fun PlayerSeasonAveragesInfoData.toEntity() =
    PlayerSeasonAveragesInfo(
        playerSeasonAveragesInfo = data.map { it.toEntity() }
    )
