package com.example.domain.usecase

import com.example.domain.base.Result
import com.example.domain.base.UseCase
import com.example.domain.entity.PlayerStatsInfo
import com.example.domain.service.PlayerService
import io.reactivex.Single

class GetPlayerStatsUseCase(
    private val playerService: PlayerService
) : UseCase<Int,Result<PlayerStatsInfo>>(){
    override fun create(data: Int): Single<Result<PlayerStatsInfo>> =
        playerService.getPlayerStats(data)
}