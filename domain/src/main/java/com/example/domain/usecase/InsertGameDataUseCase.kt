package com.example.domain.usecase

import com.example.domain.base.Result
import com.example.domain.base.UseCase
import com.example.domain.entity.GameResult
import com.example.domain.service.GamesService
import io.reactivex.Single

class InsertGameDataUseCase(
    private val gamesService: GamesService
) : UseCase<List<GameResult>,Result<Unit>>(){
    override fun create(data: List<GameResult>): Single<Result<Unit>> =
        gamesService.insertGame(data)

}