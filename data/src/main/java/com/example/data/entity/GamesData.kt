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
    val visitorTeamData: VisitorTeamData,
    @SerializedName("home_team")
    val homeTeamData: HomeTeamData
)

fun GamesData.toEntity() =
    Games(
        gameId = gameId,
        homeTeamScore = homeTeamScore,
        visitorTeamScore = visitorTeamScore,
        period = period,
        postSeason = postSeason,
        visitorTeamData = visitorTeamData.toEntity(),
        homeTeamData = homeTeamData.toEntity()
    )
