package com.example.stats.model

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.domain.entity.Games
import com.example.stats.base.koreanDay
import java.io.Serializable

data class GamesModel(
    val gameDate : String,
    val gameId : Int,
    var homeTeamScore : String,
    var visitorTeamScore : String,
    val period : String,
    val postSeason : Boolean,
    var homeTeam : HomeTeamModel,
    var visitorTeam : VisitorTeamModel
) : Serializable


@RequiresApi(Build.VERSION_CODES.O)
fun Games.toEntity() =
    GamesModel(
        gameDate = koreanDay(gameDate.substring(0,10)),
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
