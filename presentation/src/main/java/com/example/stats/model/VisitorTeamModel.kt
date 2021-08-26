package com.example.stats.model

import com.example.domain.entity.VisitorTeam
import com.example.stats.base.teamImage

data class VisitorTeamModel(
    val visitorId : Int,
    val visitorCityName : String
)

fun VisitorTeam.toEntity() =
    VisitorTeamModel(
        visitorId = teamImage(visitorId),
        visitorCityName = visitorCityName
    )
