package com.example.data.datasource

import com.example.data.entity.*
import io.reactivex.Single

interface PlayerDataSource {

    fun getBasicData(pageData : PageData) : Single<StatsBasicInfoResponse>

    fun getPlayerSeasonAverages(playerSeasonIdData: PlayerSeasonIdData) : Single<PlayerSeasonAveragesInfoResponse>

    fun getPlayerStats(gamesId : GameIdData) : Single<PlayerStatsInfoResponse>
}