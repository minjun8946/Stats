package com.example.data.entity

import com.example.domain.entity.BasicPlayer
import com.example.domain.entity.BasicTeam
import com.example.domain.entity.PlayerStats
import com.google.gson.annotations.SerializedName

data class PlayerStatsData(

    @SerializedName("id")
    val gamesId: Int,

    @SerializedName("ast")
    val assist: Int,

    @SerializedName("blk")
    val block: Double,

    @SerializedName("dreb")
    val deffensiveRebound: Double,

    @SerializedName("fg3_pct")
    val threePointSuccessRate: Double,

    @SerializedName("fg3a")
    val threePointGoalAttempted: Double,

    @SerializedName("fg3m")
    val threePointGoalMade: Double,

    @SerializedName("fg_pct")
    val fieldGoalSuccessRate: Double,

    @SerializedName("fga")
    val fieldGoalAttempted: Double,

    @SerializedName("fgm")
    val fieldGoalMade: Double,

    @SerializedName("ft_pct")
    val freeThrowSuccessRate: Double,

    @SerializedName("fta")
    val freeThrowAttempted: Double,

    @SerializedName("ftm")
    val freeThrowMade: Double,

    @SerializedName("game")
    val gameInfo: GamesData,

    @SerializedName("min")
    val min: Double,

    @SerializedName("oreb")
    val offenceRebound: Double,

    @SerializedName("pf")
    val personalFoul: Double,

    @SerializedName("player")
    val playerInfo: BasicData,

    @SerializedName("pts")
    val points: Double,

    @SerializedName("reb")
    val rebound: Double,

    @SerializedName("stl")
    val steal: Int,

    @SerializedName("team")
    val teamInfo: BasicTeamData,


    @SerializedName("turnover")
    val turnover: Int
)

fun PlayerStatsData.toEntity() =
    PlayerStats(
        gamesId = gamesId,
        assist = assist,
        block = block,
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
        gameInfo = gameInfo.toEntity(),
        min = min,
        offenceRebound = offenceRebound,
        personalFoul = personalFoul,
        playerInfo = playerInfo.toEntity(),
        points = points,
        rebound = rebound,
        steal = steal,
        teamInfo = teamInfo.toEntity(),
        turnover = turnover
    )