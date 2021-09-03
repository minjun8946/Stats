package com.example.stats.model

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.domain.entity.StatsGame
import com.example.stats.base.koreanDay
import java.io.Serializable

data class StatsGameModel(
    val homeTeamId : Int,
    val homeTeamScore : Int,
    val visitorTeamId : Int,
    val visitorTeamScore : Int,
    val gameDate : String
) : Serializable

@RequiresApi(Build.VERSION_CODES.O)
fun StatsGame.toEntity() =
    StatsGameModel(
        homeTeamId = homeTeamId,
        homeTeamScore = homeTeamScore,
        visitorTeamId = visitorTeamId,
        visitorTeamScore = visitorTeamScore,
        gameDate = koreanDay(date.substring(0,10))
    )