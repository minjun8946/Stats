package com.example.domain.entity

data class PlayerSeasonAverages(
    val gamesPlayed : Int,
    val playerId : Int,
    val season : Int,
    val min : String,
    val fieldGoalMade : Double,
    val fieldGoalAttempted : Double,
    val threePointGoalMade : Double,
    val threePointGoalAttempted : Double,
    val freeThrowMode : Double,
    val freeThrowAttempted : Double,
    val offensiveRebound : Double,
    val deffensiveRebound : Double,
    val rebound : Double,
    val assist : Double,
    val steal : Double,
    val block : Double,
    val turnover : Double,
    val personalFoul : Double,
    val points : Double,
    val fieldGoalSuccessRate : Double,
    val threePointSuccessRate : Double,
    val freeThrowSuccessRate : Double
)
