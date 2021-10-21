package com.example.data.entity

import com.example.domain.entity.Games
import com.google.gson.annotations.SerializedName

data class GamesData(
    @SerializedName("date")
    val gameDate : String,
    @SerializedName("id")
    val gameId : Int,
    @SerializedName("home_team_score")
    val homeTeamScore : Int,
    @SerializedName("visitor_team_score")
    val visitorTeamScore : Int,
    @SerializedName("season")
    val season : Int,
    @SerializedName("period")
    val period : Int,
    @SerializedName("status")
    val status : String,
    @SerializedName("postseason")
    val postSeason : Boolean,
    @SerializedName("visitor_team")
    val visitorTeam: VisitorTeamData,
    @SerializedName("home_team")
    val homeTeam: HomeTeamData
)

fun GamesData.toEntity() =
    Games(
        gameDate = gameDate,
        gameId = gameId,
        homeTeamScore = homeTeamScore,
        visitorTeamScore = visitorTeamScore,
        season = season,
        period = period,
        status = status,
        postSeason = postSeason,
        visitorTeam = visitorTeam.toEntity(),
        homeTeam = homeTeam.toEntity()
    )
