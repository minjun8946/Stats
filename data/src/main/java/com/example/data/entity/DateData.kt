package com.example.data.entity

import com.example.domain.entity.Date

data class DateData(
    val date : String
)

fun Date.toEntity() =
    DateData(
        date = date
    )