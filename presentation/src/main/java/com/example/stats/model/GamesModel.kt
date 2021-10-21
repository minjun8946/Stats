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
    val season : String,
    val period : Int,
    val status : String,
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
        season = "$season - ${season+1}",
        period = period,
        status = overTime(period, status),
        postSeason = postSeason,
        homeTeam = homeTeam.toEntity(),
        visitorTeam = visitorTeam.toEntity()
    )

fun overTime(period : Int, status: String) : String{
    return when(period){
        0,1,2,3,4 -> status
        else ->{
            if(status != "Final") "OT${period-4} Qtr"
            else "Final/OT${period-4}"
        }
    }
}