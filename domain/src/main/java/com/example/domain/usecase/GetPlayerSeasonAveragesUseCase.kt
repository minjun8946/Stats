package com.example.domain.usecase

import com.example.domain.base.Result
import com.example.domain.base.UseCase
import com.example.domain.entity.PlayerSeasonAveragesInfo
import com.example.domain.entity.PlayerSeasonId
import com.example.domain.service.PlayerService
import io.reactivex.Single

class GetPlayerSeasonAveragesUseCase(
    private val statsService: PlayerService
) : UseCase<PlayerSeasonId, Result<PlayerSeasonAveragesInfo>>() {
    override fun create(data: PlayerSeasonId): Single<Result<PlayerSeasonAveragesInfo>> =
        statsService.getPlayerSeasonAverages(data)
}
