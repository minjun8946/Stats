package com.example.domain.repository

import com.example.domain.entity.Date
import com.example.domain.entity.GameResult
import com.example.domain.entity.GamesInfo
import io.reactivex.Completable
import io.reactivex.Single

interface GamesRepository {

    fun getGamesData(date : Date) : Single<GamesInfo>

    fun insertGame(gameResult : List<GameResult>) : Completable

    fun getGameResult() : Single<List<GameResult>>
}