package com.example.data.entity

import com.example.domain.entity.PlayerSeasonId

data class PlayerSeasonIdData(
    val season : Int,
    val playerId : Int
)

fun PlayerSeasonId.toEntity() =
    PlayerSeasonIdData(
        season = season,
        playerId = playerId
    )
