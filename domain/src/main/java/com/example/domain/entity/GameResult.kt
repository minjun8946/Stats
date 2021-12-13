package com.example.domain.entity

data class GameResult(
    val gameId: Int,

    val gameDate: String,

    val homeTeamScore: String,

    val visitorTeamScore: String,

    val season: String,

    val period: Int,

    val status: String,

    val postSeason: Boolean,

    val visitorTeam: VisitorTeam,

    val homeTeam: HomeTeam
)