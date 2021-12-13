package com.example.data.local

import com.example.data.entity.VisitorTeamData
import com.example.domain.entity.VisitorTeam
import com.google.gson.annotations.SerializedName

data class ResultVisitorTeamData(
    val visitorTeamId : Int,

    val visitorTeamCityName : String
)

fun VisitorTeam.toResultVisitorTeamData() =
    ResultVisitorTeamData(
        visitorTeamId=visitorId,
        visitorTeamCityName= visitorCityName
    )

fun ResultVisitorTeamData.toVisitorTeam() =
    VisitorTeam(
        visitorId = visitorTeamId,
        visitorCityName = visitorTeamCityName
    )