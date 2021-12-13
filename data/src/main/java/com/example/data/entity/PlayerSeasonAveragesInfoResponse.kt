package com.example.data.entity

import com.example.domain.entity.PlayerSeasonAveragesInfo

data class PlayerSeasonAveragesInfoResponse(
    val data : List<PlayerSeasonAveragesData>
)

fun PlayerSeasonAveragesInfoResponse.toEntity() =
    PlayerSeasonAveragesInfo(
        playerSeasonAveragesInfo = data.map { it.toEntity() }
    )
