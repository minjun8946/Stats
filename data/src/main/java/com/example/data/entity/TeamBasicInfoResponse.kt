package com.example.data.entity

import com.example.domain.entity.TeamBasicInfo

data class TeamBasicInfoResponse(
    val data : List<BasicTeamData>,
    val meta : MetaData
)

fun TeamBasicInfoResponse.toEntity() =
    TeamBasicInfo(
        data = data.map { it.toEntity() },
        meta = meta.toEntity()
    )
