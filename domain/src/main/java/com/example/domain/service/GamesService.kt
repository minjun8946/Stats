package com.example.domain.service

import com.example.domain.base.Result
import com.example.domain.entity.Date
import com.example.domain.entity.GameResult
import com.example.domain.entity.GamesInfo
import io.reactivex.Completable
import io.reactivex.Single

interface GamesService {

    fun getGamesData(date : Date) : Single<Result<GamesInfo>>

    fun insertGame(gameResult : List<GameResult>) : Single<Result<Unit>>

    fun getGameResult() : Single<Result<List<GameResult>>>
}