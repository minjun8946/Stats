package com.example.domain.entity


data class Games(
    val gameDate : String,
    val gameId : Int,
    val homeTeamScore : Int,
    val visitorTeamScore : Int,
    val period : Int,
    val postSeason : Boolean,
    val visitorTeam: VisitorTeam,
    val homeTeam: HomeTeam
)