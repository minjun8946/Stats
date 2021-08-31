package com.example.domain.usecase

import com.example.domain.base.Result
import com.example.domain.base.UseCase
import com.example.domain.entity.GameId
import com.example.domain.entity.PlayerStatsInfo
import com.example.domain.service.PlayerService
import io.reactivex.Single

class GetPlayerStatsUseCase(private val playerService: PlayerService) : UseCase<GameId,Result<PlayerStatsInfo>>(){
    override fun create(data: GameId): Single<Result<PlayerStatsInfo>> =
        playerService.getPlayerStats(data)
}