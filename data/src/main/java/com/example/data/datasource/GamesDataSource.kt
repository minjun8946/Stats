package com.example.data.datasource

import com.example.data.entity.DateData
import com.example.data.entity.GamesInfoResponse
import com.example.data.local.GameResultEntity
import io.reactivex.Completable
import io.reactivex.Single

interface GamesDataSource {
    fun getGamesData(date : DateData) : Single<GamesInfoResponse>

    fun insertGame(gameResult : List<GameResultEntity>) : Completable

    fun getGameResult() : Single<List<GameResultEntity>>
}