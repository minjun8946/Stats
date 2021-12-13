package com.example.data.repository

import com.example.data.datasource.GamesDataSource
import com.example.data.entity.toEntity
import com.example.data.local.toEntity
import com.example.domain.entity.Date
import com.example.domain.entity.GameResult
import com.example.domain.entity.GamesInfo
import com.example.domain.repository.GamesRepository
import io.reactivex.Completable
import io.reactivex.Single

class GamesRepositoryImpl(
    val dataSource: GamesDataSource
) : GamesRepository {
    override fun getGamesData(date: Date): Single<GamesInfo> =
        dataSource.getGamesData(date.toEntity()).map { it.toEntity() }

    override fun insertGame(gameResult: List<GameResult>): Completable =
        dataSource.insertGame(gameResult.map { it.toEntity() })

    override fun getGameResult(): Single<List<GameResult>> =
        dataSource.getGameResult().map { it -> it.map { it.toEntity() } }
}