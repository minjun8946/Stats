package com.example.data.entity

import com.example.domain.entity.StatsPlayer
import com.google.gson.annotations.SerializedName

data class StatsPlayerData(
    @SerializedName("id")
    val playerId : Int,
    @SerializedName("first_name")
    val firstName : String,
    @SerializedName("last_name")
    val lastName : String,
    @SerializedName("position")
    val position : String,
    @SerializedName("team_id")
    val teamId : String,
)

fun StatsPlayerData.toEntity() =
    StatsPlayer(
        playerId = playerId,
        firstName = firstName,
        lastName = lastName,
        position = position,
        teamId = teamId
    )
