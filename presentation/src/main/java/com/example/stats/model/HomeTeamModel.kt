package com.example.stats.model

import com.example.domain.entity.HomeTeam
import com.example.stats.base.teamImage

data class HomeTeamModel(
    val homeTeamId : Int,
    val homeCityName : String
)

fun HomeTeam.toEntity() =
    HomeTeamModel(
        homeTeamId = teamImage(homeTeamId),
        homeCityName = homeCityName
    )