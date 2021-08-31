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
    val block: Int,

    @SerializedName("dreb")
    val deffensiveRebound: Int,

    @SerializedName("fg3_pct")
    val threePointSuccessRate: Double,

    @SerializedName("fg3a")
    val threePointGoalAttempted: Int,

    @SerializedName("fg3m")
    val threePointGoalMade: Int,

    @SerializedName("fg_pct")
    val fieldGoalSuccessRate: Double,

    @SerializedName("fga")
    val fieldGoalAttempted: Int,

    @SerializedName("fgm")
    val fieldGoalMade: Int,

    @SerializedName("ft_pct")
    val freeThrowSuccessRate: Double,

    @SerializedName("fta")
    val freeThrowAttempted: Int,

    @SerializedName("ftm")
    val freeThrowMade: Int,

    @SerializedName("game")
    val gameInfo: StatsGameData,

    @SerializedName("min")
    val minute: String?,

    @SerializedName("oreb")
    val offenceRebound: Int,

    @SerializedName("pf")
    val personalFoul: Int,

    @SerializedName("player")
    val playerInfo: StatsPlayerData,

    @SerializedName("pts")
    val points: Int,

    @SerializedName("reb")
    val rebound: Int,

    @SerializedName("stl")
    val steal: Int,

    @SerializedName("team")
    val teamInfo: StatsTeamData,


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
        minute = minute,
        offenceRebound = offenceRebound,
        personalFoul = personalFoul,
        playerInfo = playerInfo.toEntity(),
        points = points,
        rebound = rebound,
        steal = steal,
        teamInfo = teamInfo.toEntity(),
        turnover = turnover
    )