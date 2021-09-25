package com.example.stats.model

import com.example.domain.entity.PlayerStats
import java.io.Serializable

data class StatsModel(
    val point : String,

    val assist : String,

    val rebound : String,

    val steal : Int,

    val block : Int,

    val gamesId: Int,

    val deffensiveRebound : Int,

    val threePointSuccessRate : Double,

    val threePointGoalAttempted: Int,

    val threePointGoalMade: Int,

    val fieldGoalSuccessRate : Double,

    val fieldGoalAttempted : Int,

    val fieldGoalMade: Int,

    val freeThrowSuccessRate : Double,

    val freeThrowAttempted: Int,

    val freeThrowMade: Int,

    val minute: String?,

    val offenceRebound: Int,

    val personalFoul: Int,

    val teamInfo: StatsTeamModel,

    val turnover : Int,

    val gameInfo : StatsGameModel,

    val playerInfo : StatsPlayerModel,
) : Serializable

fun PlayerStats.toEntity() =
    StatsModel(
        point = " $points pts",
        assist = " $assist ast",
        rebound = " $rebound rebound",
        steal = steal,
        block = block,
        gamesId = gamesId,
        deffensiveRebound = deffensiveRebound,
        threePointSuccessRate = threePointSuccessRate,
        threePointGoalAttempted = threePointGoalAttempted,
        threePointGoalMade = threePointGoalMade,
        fieldGoalSuccessRate = fieldGoalSuccessRate,
        fieldGoalAttempted = fieldGoalAttempted,
        fieldGoalMade = fieldGoalMade,
        freeThrowSuccessRate = freeThrowSuccessRate,
        freeThrowAttempted = freeThrowAttempted,
        freeThrowMade = freeThrowMade,
        minute = minute,
        offenceRebound = offenceRebound,
        personalFoul = personalFoul,
        teamInfo = teamInfo.toEntity(),
        turnover = turnover,
        gameInfo = gameInfo.toEntity(),
        playerInfo = playerInfo.toEntity()
    )
