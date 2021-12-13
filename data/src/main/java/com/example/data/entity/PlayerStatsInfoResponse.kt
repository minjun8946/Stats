package com.example.data.entity

import com.example.domain.entity.PlayerStatsInfo
import com.google.gson.annotations.SerializedName

data class PlayerStatsInfoResponse(
    @SerializedName("data")
    val data : List<PlayerStatsData>,
    @SerializedName("meta")
    val meta : MetaData
)

fun PlayerStatsInfoResponse.toEntity() =
    PlayerStatsInfo(
        data = data.map { it.toEntity() },
        meta = meta.toEntity()
    )