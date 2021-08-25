package com.example.data.entity

import com.example.domain.entity.VisitorTeam
import com.google.gson.annotations.SerializedName

data class VisitorTeamData(
    @SerializedName("id")
    val visitorTeamId : Int,
    @SerializedName("city")
    val visitorTeamCityName : String
)

fun VisitorTeamData.toEntity() =
    VisitorTeam(
        visitorId = visitorTeamId,
        visitorCityName = visitorTeamCityName
    )