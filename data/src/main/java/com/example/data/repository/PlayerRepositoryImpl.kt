package com.example.data.repository

import com.example.data.datasource.PlayerDataSource
import com.example.data.entity.toEntity
import com.example.domain.entity.Page
import com.example.domain.entity.PlayerSeasonAveragesInfo
import com.example.domain.entity.PlayerSeasonId
import com.example.domain.entity.StatsBasicInfo
import com.example.domain.repository.PlayerRepository
import io.reactivex.Single


class PlayerRepositoryImpl(
    private val dataSource : PlayerDataSource
) : PlayerRepository {
    override fun getAllPlayerInfo(page: Page): Single<StatsBasicInfo> =
        dataSource.getBasicData(page.toEntity()).map { it.toEntity() }

    override fun getPlayerSeasonAverages(playerSeasonId: PlayerSeasonId): Single<PlayerSeasonAveragesInfo> =
        dataSource.getPlayerSeasonAverages(playerSeasonId.toEntity()).map { it.toEntity() }
}