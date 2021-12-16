package com.example.data.entity

import com.example.domain.entity.Date

data class DateData(
    val date : String?,
    val season : Int?,
    val teamId : Int?,
    val postseason : Boolean?,
    val page : Int,
    val perPage : Int,
)

fun Date.toEntity() =
    DateData(
        date = date,
        season = season,
        teamId = teamId,
        postseason = postseason,
        page = page,
        perPage = perPage
    )