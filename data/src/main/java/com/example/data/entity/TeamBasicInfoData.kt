package com.example.data.entity

import com.example.domain.entity.TeamBasicInfo

data class TeamBasicInfoData(
    val data : List<BasicTeamData>,
    val meta : MetaData
)

fun TeamBasicInfoData.toEntity() =
    TeamBasicInfo(
        data = data.map { it.toEntity() },
        meta = meta.toEntity()
    )
