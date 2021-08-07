package com.example.stats.model

import com.example.domain.entity.Basic
import com.example.domain.entity.BasicPlayer
import com.example.domain.entity.BasicTeam

data class BasicModel(

    val personId : String,
    val firstName : String,
    val lastName : String,
    val position : String,
    val height_feet : String,
    val height_inches : String,
    val weight_pounds : String,
    val teamId : String,
    val teamName : String
)

fun Basic.toBasicModel() : BasicModel =
    BasicModel(
        personId= "$personId",
        firstName = firstName,
        lastName = lastName,
        position= position,
        height_feet= "$height_feet",
        height_inches = "$height_inches",
        weight_pounds = "$weight_pounds",
        teamId = "$teamId",
        teamName = teamName
    )