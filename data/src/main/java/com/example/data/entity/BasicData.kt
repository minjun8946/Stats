package com.example.data.entity

import com.example.domain.entity.Basic

data class BasicData(
    val id : Int,
    val first_name : String,
    val last_name : String,
    val position : String,
    val height_feet : Int,
    val height_inches : Int,
    val weight_pounds : Int,
    val team : BasicTeamData
)

fun BasicData.toEntity() =
    Basic (
        personId= id,
        firstName = first_name,
        lastName = last_name,
        position= position,
        height_feet= height_feet,
        height_inches = height_inches,
        weight_pounds = weight_pounds,
        teamId = team.teamId,
        teamName = team.teamName
    )