package com.example.stats.model

import android.view.inspector.IntFlagMapping
import com.example.domain.entity.GameId

data class GameIdModel(
    val gameId : Int,
    val perPage : Int
)

fun GameIdModel.toEntity() =
    GameId(
        gameId = gameId,
        perPage = perPage
    )
