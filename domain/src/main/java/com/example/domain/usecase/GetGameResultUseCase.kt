package com.example.domain.usecase

import com.example.domain.base.Result
import com.example.domain.base.UseCase
import com.example.domain.entity.GameResult
import com.example.domain.service.GamesService
import io.reactivex.Single

class GetGameResultUseCase(
    val gamesService: GamesService
) : UseCase<Unit,Result<List<GameResult>>>() {
    override fun create(data: Unit): Single<Result<List<GameResult>>> =
        gamesService.getGameResult()
}