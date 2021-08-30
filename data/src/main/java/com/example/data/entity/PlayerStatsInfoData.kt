package com.example.data.entity

import com.example.domain.entity.PlayerStatsInfo

data class PlayerStatsInfoData(
    val data : List<PlayerStatsData>,
    val meta : MetaData
)

fun PlayerStatsInfoData.toEntity() =
    PlayerStatsInfo(
        data = data.map { it.toEntity() },
        meta = meta.toEntity()
    )