package com.example.domain.entity

data class PlayerStats(

    val gamesId: Int,

    val assist: Int,

    val block: Double,

    val deffensiveRebound : Double,

    val threePointSuccessRate : Double,

    val threePointGoalAttempted: Double,

    val threePointGoalMade: Double,

    val fieldGoalSuccessRate : Double,

    val fieldGoalAttempted : Double,

    val fieldGoalMade: Double,

    val freeThrowSuccessRate : Double,

    val freeThrowAttempted: Double,

    val freeThrowMade: Double,

    val gameInfo : Games,

    val min: Double,

    val offenceRebound: Double,

    val personalFoul: Double,

    val playerInfo : Basic,

    val points: Double,

    val rebound: Double,

    val steal : Int,

    val teamInfo: BasicTeam,

    val turnover : Int
)
