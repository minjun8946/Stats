package com.example.domain.service

import com.example.domain.base.Result
import com.example.domain.entity.*
import com.example.domain.repository.PlayerRepository
import com.example.domain.toResult
import io.reactivex.Single

class PlayerServiceImpl(
    private val playerRepository: PlayerRepository
): PlayerService {
    override fun getAllPlayer(page: Page): Single<Result<StatsBasicInfo>> =
        playerRepository.getAllPlayerInfo(page).toResult()

    override fun getPlayerSeasonAverages(playerSeasonId: PlayerSeasonId): Single<Result<PlayerSeasonAveragesInfo>> =
        playerRepository.getPlayerSeasonAverages(playerSeasonId).toResult()

    override fun getPlayerStats(gameId: GameId): Single<Result<PlayerStatsInfo>> =
        playerRepository.getPlayerStats(gameId).toResult()
}