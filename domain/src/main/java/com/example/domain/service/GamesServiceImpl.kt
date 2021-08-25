package com.example.domain.service

import com.example.domain.base.Result
import com.example.domain.entity.Date
import com.example.domain.entity.GamesInfo
import com.example.domain.repository.GamesRepository
import com.example.domain.toResult
import io.reactivex.Single

class GamesServiceImpl(
    private val gamesRepository: GamesRepository
) : GamesService{
    override fun getGamesData(date: Date): Single<Result<GamesInfo>> =
        gamesRepository.getGamesData(date).toResult()
}