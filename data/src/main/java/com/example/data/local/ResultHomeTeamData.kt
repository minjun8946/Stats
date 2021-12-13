package com.example.data.local

import com.example.data.entity.HomeTeamData
import com.example.domain.entity.HomeTeam
import com.google.gson.annotations.SerializedName

data class ResultHomeTeamData(

    val homeTeamId : Int,

    val homeCityName : String,
)

fun HomeTeam.toResultHomeTeamData() =
    ResultHomeTeamData(
        homeTeamId = homeTeamId,
        homeCityName = homeCityName
    )

fun ResultHomeTeamData.toHomeTeam() =
    HomeTeam(
        homeTeamId = homeTeamId,
        homeCityName = homeCityName
    )