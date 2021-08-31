package com.example.domain.entity

data class StatsGame(
    val gameId : Int,
    val date : String,
    val homeTeamId : Int,
    val homeTeamScore : Int,
    val season : Int,
    val visitorTeamId: Int,
    val visitorTeamScore: Int
)