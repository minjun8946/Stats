package com.example.data.entity

import com.example.domain.entity.BasicTeam
import com.google.gson.annotations.SerializedName

data class BasicTeamData(
    @SerializedName("id")
    val teamId : Int,
    @SerializedName("name")
    val teamName : String
)

fun BasicTeamData.toEntity() =
    BasicTeam(
        teamId = teamId,
        teamName= teamName
    )
