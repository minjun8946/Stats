package com.example.stats.model

import com.example.domain.entity.PlayerSeasonId

data class PlayerSeasonIdModel(
    val season : Int,
    val playerId : Int
)

fun PlayerSeasonIdModel.toEntity() =
    PlayerSeasonId(
        season = season,
        playerId = playerId
    )
