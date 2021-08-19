package com.example.domain.service

import com.example.domain.base.Result
import com.example.domain.entity.Page
import com.example.domain.entity.PlayerSeasonAveragesInfo
import com.example.domain.entity.PlayerSeasonId
import com.example.domain.entity.StatsBasicInfo
import com.example.domain.repository.StatsRepository
import com.example.domain.toResult
import io.reactivex.Single

class StatsServiceImpl(
    private val statsRepository: StatsRepository
): StatsService {
    override fun getAllPlayer(page: Page): Single<Result<StatsBasicInfo>> =
        statsRepository.getAllPlayerInfo(page).toResult()

    override fun getPlayerSeasonAverages(playerSeasonId: PlayerSeasonId): Single<Result<PlayerSeasonAveragesInfo>> =
        statsRepository.getPlayerSeasonAverages(playerSeasonId).toResult()
}