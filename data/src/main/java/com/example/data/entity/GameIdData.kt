package com.example.data.entity

import com.example.domain.entity.GameId

data class GameIdData(
    val gameId : Int,
    val perPage : Int
)

fun GameId.toEntity() =
    GameIdData(
        gameId = gameId,
        perPage = perPage
    )