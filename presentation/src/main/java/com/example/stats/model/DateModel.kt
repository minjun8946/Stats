package com.example.stats.model

import com.example.domain.entity.Date

data class DateModel(
    val date : String?,
    val season : Int?,
    val teamId : Int?,
    val page : Int,
    val perPage : Int
)


fun DateModel.toEntity() =
    Date(
        date = date,
        season = season,
        teamId = teamId,
        page = page,
        perPage = perPage
    )