package com.example.data.entity

import com.example.domain.entity.Games
import com.google.gson.annotations.SerializedName

data class GamesData(
    @SerializedName("id")
    val gameId : Int,
    @SerializedName("home_team_score")
    val homeTeamScore : Int,
    @SerializedName("visitor_team_score")
    val visitorTeamScore : Int,
    @SerializedName("period")
    val period : Int,
    @SerializedName("postseason")
    val postSeason : Boolean,
    @SerializedName("visitor_team")
    val visitorTeam: VisitorTeamData,
    @SerializedName("home_team")
    val homeTeam: HomeTeamData
)

fun GamesData.toEntity() =
    Games(
        gameId = gameId,
        homeTeamScore = homeTeamScore,
        visitorTeamScore = visitorTeamScore,
        period = period,
        postSeason = postSeason,
        visitorTeam = visitorTeam.toEntity(),
        homeTeam = homeTeam.toEntity()
    )
