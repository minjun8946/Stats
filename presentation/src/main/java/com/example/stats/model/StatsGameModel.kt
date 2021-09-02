package com.example.stats.model

import com.example.domain.entity.StatsGame

data class StatsGameModel(
    val homeTeamId : Int,
    val homeTeamScore : Int,
    val visitorTeamId : Int,
    val visitorTeamScore : Int
)

fun StatsGame.toEntity() =
    StatsGameModel(
        homeTeamId = homeTeamId,
        homeTeamScore = homeTeamScore,
        visitorTeamId = visitorTeamId,
        visitorTeamScore = visitorTeamScore
    )