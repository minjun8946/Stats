package com.example.domain.usecase

import com.example.domain.base.Result
import com.example.domain.base.UseCase
import com.example.domain.entity.PlayerSeasonAveragesInfo
import com.example.domain.entity.PlayerSeasonId
import com.example.domain.service.StatsService
import io.reactivex.Single

class GetPlayerSeasonAveragesUseCase(
    private val statsService: StatsService
) : UseCase<PlayerSeasonId, Result<PlayerSeasonAveragesInfo>>() {
    override fun create(data: PlayerSeasonId): Single<Result<PlayerSeasonAveragesInfo>> =
        statsService.getPlayerSeasonAverages(data)
}
