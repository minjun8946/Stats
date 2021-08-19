package com.example.data.entity

import com.example.domain.entity.PlayerSeasonAverages
import com.google.gson.annotations.SerializedName

data class PlayerSeasonAveragesData(
    @SerializedName("games_played")
    val gamesPlayed : Int,
    @SerializedName("player_id")
    val playerId : Int,
    @SerializedName("season")
    val season : Int,
    @SerializedName("min")
    val min : String,
    @SerializedName("fgm")
    val fieldGoalMade : Double,
    @SerializedName("fga")
    val fieldGoalAttempted : Double,
    @SerializedName("fg3m")
    val threePointGoalMade : Double,
    @SerializedName("fg3a")
    val threePointGoalAttempted : Double,
    @SerializedName("ftm")
    val freeThrowMode : Double,
    @SerializedName("fta")
    val freeThrowAttempted : Double,
    @SerializedName("oreb")
    val offensiveRebound : Double,
    @SerializedName("dreb")
    val deffensiveRebound : Double,
    @SerializedName("reb")
    val rebound : Double,
    @SerializedName("ast")
    val assist : Double,
    @SerializedName("stl")
    val steal : Double,
    @SerializedName("blk")
    val block : Double,
    @SerializedName("turnover")
    val turnover : Double,
    @SerializedName("pf")
    val personalFoul : Double,
    @SerializedName("pts")
    val points : Double,
    @SerializedName("fg_pct")
    val fieldGoalSuccessRate : Double,
    @SerializedName("fg3_pct")
    val threePointSuccessRate : Double,
    @SerializedName("ft_pct")
    val freeThrowSuccessRate : Double
)

fun PlayerSeasonAveragesData.toEntity() =
    PlayerSeasonAverages(
        gamesPlayed, playerId, season, min, fieldGoalMade, fieldGoalAttempted, threePointGoalMade, threePointGoalAttempted, freeThrowMode, freeThrowAttempted, offensiveRebound, deffensiveRebound, rebound, assist, steal, block, turnover, personalFoul, points, fieldGoalSuccessRate, threePointSuccessRate, freeThrowSuccessRate
    )
