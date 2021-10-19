package com.example.stats.model

import com.example.domain.entity.StatsPlayer
import com.example.stats.base.teamImage
import java.io.Serializable

data class StatsPlayerModel(
    val playerId :Int,
    val teamName : String,
    val teamId : Int,
    val position : String
) : Serializable

fun StatsPlayer.toEntity() =
    StatsPlayerModel(
        playerId = playerId,
        teamName = lastName,
        teamId = teamId.toInt(),
        position = position
    )