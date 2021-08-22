package com.example.stats.model

import com.example.domain.entity.PlayerSeasonAverages
import kotlin.math.*

data class PlayerSeasonAveragesModel(
    val gamesPlayed : String,
    val playerId : String,
    val season : String,
    val min : String,
    val fieldGoalMade : String,
    val fieldGoalAttempted : String,
    val threePointGoalMade : String,
    val threePointGoalAttempted : String,
    val freeThrowMode : String,
    val freeThrowAttempted : String,
    val offensiveRebound : String,
    val deffensiveRebound : String,
    val rebound : String,
    val assist : String,
    val steal : String,
    val block : String,
    val turnover : String,
    val personalFoul : String,
    val points : String,
    val fieldGoalSuccessRate : String,
    val threePointSuccessRate : String,
    val freeThrowSuccessRate : String
)

fun PlayerSeasonAverages.toEntity() =
    PlayerSeasonAveragesModel(
        gamesPlayed = "GAMES\n$gamesPlayed",
        playerId = "$playerId",
        season = "$season - ${season+1}",
        min = "MIN\n$min",
        fieldGoalMade = "FGM\n$fieldGoalMade",
        fieldGoalAttempted = "FGA\n$fieldGoalAttempted",
        fieldGoalSuccessRate = "FG%\n${doubleToRate(fieldGoalSuccessRate)}%",
        threePointGoalMade = "3PM\n$threePointGoalMade",
        threePointGoalAttempted = "3PA\n$threePointGoalAttempted",
        threePointSuccessRate = "3P%\n${doubleToRate(threePointSuccessRate)}%",
        freeThrowMode = "FTM\n$freeThrowMode",
        freeThrowAttempted = "FTA\n$freeThrowAttempted",
        freeThrowSuccessRate = "FT%\n${doubleToRate(freeThrowSuccessRate)}%",
        offensiveRebound = "OREB\n$offensiveRebound",
        deffensiveRebound = "DREB\n$deffensiveRebound",
        rebound = "REB\n$rebound",
        assist = "AST\n$assist",
        steal = "STL\n$steal",
        block = "BLK\n$block",
        turnover = "TOV\n$turnover",
        personalFoul = "P.F\n$personalFoul",
        points = "PTS\n$points",
    )

fun doubleToRate(double: Double) : Float{
    val rate = double *100
    return (rate * 10).roundToInt()/10f
}
