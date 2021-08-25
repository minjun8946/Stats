package com.example.data.repository

import com.example.data.datasource.GamesDataSource
import com.example.data.entity.toEntity
import com.example.domain.entity.Date
import com.example.domain.entity.GamesInfo
import com.example.domain.repository.GamesRepository
import io.reactivex.Single

class GamesRepositoryImpl(
    val dataSource: GamesDataSource
) : GamesRepository {
    override fun getGamesData(date: Date): Single<GamesInfo> =
        dataSource.getGamesData(date.toEntity()).map { it.toEntity() }
}