package com.example.data.entity

import com.example.domain.entity.HomeTeam
import com.google.gson.annotations.SerializedName

data class HomeTeamData(
    @SerializedName("id")
    val homeTeamId : Int,
    @SerializedName("city")
    val homeCityName : String,
)

fun HomeTeamData.toEntity() =
    HomeTeam(
        homeTeamId = homeTeamId,
        homeCityName = homeCityName
    )