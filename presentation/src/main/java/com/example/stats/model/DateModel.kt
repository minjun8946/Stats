package com.example.stats.model

import com.example.domain.entity.Date

data class DateModel(
    val date : String
)


fun DateModel.toEntity() =
    Date(
        date = date
    )