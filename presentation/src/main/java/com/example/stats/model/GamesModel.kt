package com.example.stats.model

import android.media.Image
import com.example.domain.entity.Games
import com.example.domain.entity.HomeTeam
import com.example.stats.R

data class GamesModel(
    val gameId : Int,
    val homeTeamScore : String,
    val visitorTeamScore : String,
    val period : String,
    val postSeason : Boolean,
    val homeTeam : HomeTeamModel,
    val visitorTeam : VisitorTeamModel
)

fun Games.toEntity() =
    GamesModel(
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
        4 -> "Final"
        5 -> "Final/OT"
        else -> "Final/${period-4}OT"
    }
}
