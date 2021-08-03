package com.example.data.entity

import com.example.domain.entity.StatsBasicInfo


data class GetAllPlayerResponse(
    val data : List<BasicData>?,

    val meta : MetaData?
)

fun GetAllPlayerResponse.toEntity() =
    StatsBasicInfo(
        data = data?.map { it.toEntity() },
        meta = meta?.toEntity()
    )



