package com.example.domain.usecase

import com.example.domain.base.Result
import com.example.domain.base.UseCase
import com.example.domain.entity.Date
import com.example.domain.entity.GamesInfo
import com.example.domain.service.GamesService
import io.reactivex.Single

class GetGamesDataUseCase(
    private val gamesService: GamesService
) : UseCase<Date, Result<GamesInfo>>() {
    override fun create(data: Date): Single<Result<GamesInfo>> =
        gamesService.getGamesData(data)
}