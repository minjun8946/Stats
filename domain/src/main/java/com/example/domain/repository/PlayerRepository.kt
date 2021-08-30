package com.example.domain.repository

import com.example.domain.entity.*
import io.reactivex.Single

interface PlayerRepository {

    fun getAllPlayerInfo(page : Page) : Single<StatsBasicInfo>

    fun getPlayerSeasonAverages(playerSeasonId : PlayerSeasonId) : Single<PlayerSeasonAveragesInfo>

    fun getPlayerStats(gameId : Int) : Single<PlayerStatsInfo>
}