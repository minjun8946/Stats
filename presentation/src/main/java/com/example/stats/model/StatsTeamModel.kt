package com.example.stats.model

import com.example.domain.entity.StatsTeam
import com.example.stats.base.teamImage
import java.io.Serializable

data class StatsTeamModel(
    val teamId : Int,
    val abbreviation : String,
    val city : String,
    val conference : String,
    val division : String,
    val fullName: String,
    val name: String
) : Serializable

fun StatsTeam.toEntity() =
    StatsTeamModel(
        teamId = teamId,
        abbreviation = abbreviation,
        city = city,
        conference = conference,
        division = division,
        fullName = fullName,
        name = name
    )