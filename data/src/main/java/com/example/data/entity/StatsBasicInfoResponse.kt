package com.example.data.entity

import com.example.domain.entity.StatsBasicInfo

data class StatsBasicInfoResponse(
    val data : List<BasicData>,
    val meta : MetaData
)

fun StatsBasicInfoResponse.toEntity() =
    StatsBasicInfo(
        data = data.map { it.toEntity() },
        meta = meta.toEntity()
    )