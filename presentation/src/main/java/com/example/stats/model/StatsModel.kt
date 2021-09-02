package com.example.stats.model

import com.example.domain.entity.PlayerStats

data class StatsModel(
    val point : String,
    val assist : String,
    val rebound : String,
    val steal : Int,
    val block : Int,
    val gameInfo : StatsGameModel,
    val playerInfo : StatsPlayerModel
)

fun PlayerStats.toEntity() =
    StatsModel(
        point = " $points pts",
        assist = " $assist ast",
        rebound = " $rebound rebound",
        steal = steal,
        block = block,
        gameInfo = gameInfo.toEntity(),
        playerInfo = playerInfo.toEntity()
    )
