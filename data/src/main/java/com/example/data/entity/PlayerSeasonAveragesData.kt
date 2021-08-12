package com.example.data.entity

import com.google.gson.annotations.SerializedName

data class PlayerSeasonAveragesData(
    val games_played : Int,
    val player_id : Int,
    val season : Int,
    val min : String,
    @SerializedName("fgm")
    val fieldGoalMade : Double,
    @SerializedName("fga")
    val fieldGoalAttempted : Double,
    @SerializedName("fg3m")
    val ThreePointGoalMade : Double,
    @SerializedName("pg3a")
    val ThreePointGoalAttempted : Double,
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
    val black : Double,
    @SerializedName("turnover")
    val turnover : Double,
    @SerializedName("pf")
    val personalFoul : Double,
    @SerializedName("pts")
    val points : Double,
    @SerializedName("fg_pct")
    val fieldGoalSuccessRate : Double,
    @SerializedName("fg3_pct")
    val ThreePointSuccessRate : Double,
    @SerializedName("ft_pct")
    val FreeThrowSuccessRate : Double
)
