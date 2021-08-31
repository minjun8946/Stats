package com.example.domain.entity

data class PlayerStats(

    val gamesId: Int,

    val assist: Int,

    val block: Int,

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

    val gameInfo : StatsGame,

    val minute: String?,

    val offenceRebound: Int,

    val personalFoul: Int,

    val playerInfo : StatsPlayer,

    val points: Int,

    val rebound: Int,

    val steal : Int,

    val teamInfo: StatsTeam,

    val turnover : Int
)
