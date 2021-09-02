package com.example.stats.model

import com.example.domain.entity.Games
import java.io.Serializable

data class GamesModel(
    val gameDate : String,
    val gameId : Int,
    val homeTeamScore : String,
    val visitorTeamScore : String,
    val period : String,
    val postSeason : Boolean,
    val homeTeam : HomeTeamModel,
    val visitorTeam : VisitorTeamModel
) : Serializable

fun Games.toEntity() =
    GamesModel(
        gameDate = gameDate.substring(0,10),
        gameId = gameId,
        homeTeamScore = "$homeTeamScore",
        visitorTeamScore = "$visitorTeamScore",
        period = status(period),
        postSeason = postSeason,
        homeTeam = homeTeam.toEntity(),
        visitorTeam = visitorTeam.toEntity()
    )

fun status(period : Int) :String{
    return when(period){
        0 -> "Final"
        1 -> "Final"
        2 -> "Final"
        3 -> "Final"
        4 -> "Final"
        5 -> "Final/OT"
        else -> "Final/${period-4}OT"
    }
}
