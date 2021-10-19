package com.example.stats.model

import com.example.domain.entity.HomeTeam
import com.example.stats.base.teamImage
import java.io.Serializable

data class HomeTeamModel(
    val homeTeamId : Int,
    val homeCityName : String
) : Serializable

fun HomeTeamModel.toVisitorTeamModel() =
    VisitorTeamModel(
        visitorCityName = homeCityName,
        visitorId = homeTeamId
    )

fun HomeTeam.toEntity() =
    HomeTeamModel(
        homeTeamId = homeTeamId,
        homeCityName = homeCityName
    )