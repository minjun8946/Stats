package com.example.data.entity

import com.example.domain.entity.StatsGame
import com.google.gson.annotations.SerializedName

data class StatsGameData(
    @SerializedName("id")
    val gameId : Int,
    @SerializedName("date")
    val date : String,
    @SerializedName("home_team_id")
    val homeTeamId : Int,
    @SerializedName("home_team_score")
    val homeTeamScore : Int,
    @SerializedName("season")
    val season : Int,
    @SerializedName("visitor_team_id")
    val visitorTeamId: Int,
    @SerializedName("visitor_team_score")
    val visitorTeamScore: Int
)

fun StatsGameData.toEntity() =
    StatsGame(
        gameId = gameId,
        date = date,
        homeTeamId = homeTeamId,
        homeTeamScore = homeTeamScore,
        season = season,
        visitorTeamId = visitorTeamId,
        visitorTeamScore = visitorTeamScore
    )