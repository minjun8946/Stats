package com.example.stats.model

import com.example.domain.entity.VisitorTeam
import com.example.stats.base.teamImage
import java.io.Serializable

data class VisitorTeamModel(
    val visitorId : Int,
    val visitorCityName : String
) : Serializable

fun VisitorTeam.toEntity() =
    VisitorTeamModel(
        visitorId = visitorId,
        visitorCityName = visitorCityName
    )

fun VisitorTeamModel.toVisitorTeam() =
    VisitorTeam(
        visitorId = visitorId,
        visitorCityName = visitorCityName
    )
