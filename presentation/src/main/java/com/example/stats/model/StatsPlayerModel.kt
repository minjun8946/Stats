package com.example.stats.model

import com.example.domain.entity.StatsPlayer
import com.example.stats.base.teamImage

data class StatsPlayerModel(
    val playerId :Int,
    val teamName : String,
    val teamId : Int
)

fun StatsPlayer.toEntity() =
    StatsPlayerModel(
        playerId = playerId,
        teamName = lastName,
        teamId = teamImage(teamId.toInt())
    )