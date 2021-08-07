package com.example.data.entity

import com.example.domain.entity.StatsBasicInfo


data class StatsBasicInfoData(
    val data : List<BasicData>,

    val meta : MetaData?
)

fun StatsBasicInfoData.toEntity() =
    StatsBasicInfo(
        data = data?.map { it.toEntity() },
        meta = meta?.toEntity()
    )



