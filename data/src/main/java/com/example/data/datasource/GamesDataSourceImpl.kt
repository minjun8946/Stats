package com.example.data.datasource

import com.example.data.entity.DateData
import com.example.data.entity.GamesInfoResponse
import com.example.data.local.GameResultDao
import com.example.data.local.GameResultEntity
import com.example.data.remote.ApiService
import io.reactivex.Completable
import io.reactivex.Single

class GamesDataSourceImpl(
    private val apiService: ApiService,
    private val gameResultDao: GameResultDao
) : GamesDataSource {
    override fun getGamesData(date: DateData): Single<GamesInfoResponse> =
        apiService.getGameData(
            date = date.date,
            season = date.season,
            teamId = date.teamId,
            page = date.page,
            perPage = date.perPage,
        )

    override fun insertGame(gameResult: List<GameResultEntity>): Completable =
        gameResultDao.insertGame(gameResult)

    override fun getGameResult(season : String): Single<List<GameResultEntity>> =
        gameResultDao.getGameResult(season)

}