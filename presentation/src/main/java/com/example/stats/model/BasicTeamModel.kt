package com.example.stats.model

import com.example.domain.entity.BasicTeam
import com.example.stats.base.teamImage

data class BasicTeamModel(
    val teamId : Int,
    val teamName : String,
    val city : String,
    val conference : String,
    val division : String
)

fun BasicTeam.toEntity() =
    BasicTeamModel(
        teamId = teamImage(teamId),
        teamName = teamName,
        city = city,
        conference = conference,
        division = division
    )