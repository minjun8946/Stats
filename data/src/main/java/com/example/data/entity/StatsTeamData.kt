package com.example.data.entity

import com.example.domain.entity.StatsTeam
import com.google.gson.annotations.SerializedName

data class StatsTeamData(
    @SerializedName("id")
    val teamId : Int,
    @SerializedName("abbreviation")
    val abbreviation : String,
    @SerializedName("city")
    val city : String,
    @SerializedName("conference")
    val conference : String,
    @SerializedName("division")
    val division : String,
    @SerializedName("full_name")
    val fullName: String,
    @SerializedName("name")
    val name: String
)

fun StatsTeamData.toEntity() =
    StatsTeam(
        teamId = teamId,
        abbreviation = abbreviation,
        city = city,
        conference = conference,
        division = division,
        fullName = fullName,
        name = name
    )