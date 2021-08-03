package com.example.data.entity

import com.example.domain.entity.Basic
import com.example.domain.entity.BasicPlayer
import com.example.domain.entity.StatsBasicInfo
import com.google.gson.annotations.SerializedName

data class BasicData(
    val id : Int?,
    val first_name : String?,
    val last_name : String?,
    val team : BasicTeamData
)

fun BasicData.toEntity() =
    Basic (
        personId= id,
        firstName = first_name,
        lastName = last_name,
        teamId = team.teamId,
        teamName = team.teamName
    )