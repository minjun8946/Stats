package com.example.stats.model

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.domain.entity.GameResult
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

fun GamesModel.toGameResult() =
    GameResult(
        gameId = gameId,
        gameDate = gameDate,
        homeTeamScore = homeTeamScore,
        visitorTeamScore = visitorTeamScore,
        season = season,
        period = period,
        status = status,
        postSeason = postSeason,
        homeTeam = homeTeam.toHomeTeam(),
        visitorTeam =  visitorTeam.toVisitorTeam()
    )


@RequiresApi(Build.VERSION_CODES.O)
fun Games.toEntity() =
    GamesModel(
        gameDate = koreanDay(gameDate.substring(0,10)),
        gameId = gameId,
        homeTeamScore = "$homeTeamScore",
        visitorTeamScore = "$visitorTeamScore",
        season = "$season - ${season+1}",
        period = period,
        status = time(period, status),
        postSeason = postSeason,
        homeTeam = homeTeam.toEntity(),
        visitorTeam = visitorTeam.toEntity()
    )

fun time(period : Int, status: String) : String{
    return when(period){
        0 -> {
            val time = status.split(" ",":")
            try {
                val hour = if(time[0].toInt() >=10){
                    "${time[0].toInt() +2} : ${time[1]} PM"
                }else{
                    "${time[0].toInt() +2} : ${time[1]} AM"
                }
                return hour
            }catch (e : Throwable){
                status
            }

        }
        1,2,3,4 -> status
        else ->{
            if(status != "Final") "OT${period-4} Qtr"
            else "Final/OT${period-4}"
        }
    }
}