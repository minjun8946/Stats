package com.example.data.entity

import com.example.domain.entity.Basic
import com.example.domain.entity.BasicPlayer
import com.example.domain.entity.StatsBasicInfo

data class BasicData(
    val basicPlayerData: BasicPlayerData,
    val basicTeamData: BasicTeamData
)

fun BasicData.toEntity() =
    Basic (
        basicPlayerData = basicPlayerData.toEntity(),
        basicTeamData = basicTeamData.toEntity()
    )

