package com.example.domain.service

import com.example.domain.base.ErrorHandler
import com.example.domain.base.Result
import com.example.domain.entity.*
import com.example.domain.repository.PlayerRepository
import com.example.domain.toResult
import io.reactivex.Single

class PlayerServiceImpl(
    private val playerRepository: PlayerRepository,
    private val handler : ErrorHandler
): PlayerService {
    override fun getAllPlayer(page: Page): Single<Result<StatsBasicInfo>> =
        playerRepository.getAllPlayerInfo(page).toResult(
            handler = handler,
            getLocalDataFun = { playerRepository.getAllPlayerInfo(page).blockingGet() },
            saveLocalFun = { T -> playerRepository.getAllPlayerInfo(page) }
        )

    override fun getPlayerSeasonAverages(playerSeasonId: PlayerSeasonId): Single<Result<PlayerSeasonAveragesInfo>> =
        playerRepository.getPlayerSeasonAverages(playerSeasonId).toResult(
            handler = handler,
            getLocalDataFun = { playerRepository.getPlayerSeasonAverages(playerSeasonId).blockingGet() },
            saveLocalFun = { T -> playerRepository.getPlayerSeasonAverages(playerSeasonId) }
        )

    @Suppress("CheckResult")
    override fun getPlayerStats(gameId: GameId): Single<Result<PlayerStatsInfo>> =
        playerRepository.getPlayerStats(gameId).toResult(
            handler = handler
        )
}