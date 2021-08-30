package com.example.data.datasource

import com.example.data.entity.*
import io.reactivex.Single

interface PlayerDataSource {

    fun getBasicData(pageData : PageData) : Single<StatsBasicInfoData>

    fun getPlayerSeasonAverages(playerSeasonIdData: PlayerSeasonIdData) : Single<PlayerSeasonAveragesInfoData>

    fun getPlayerStats(gamesId : Int) : Single<PlayerStatsInfoData>
}