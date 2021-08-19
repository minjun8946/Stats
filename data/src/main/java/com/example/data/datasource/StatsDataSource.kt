package com.example.data.datasource

import com.example.data.entity.*
import io.reactivex.Single

interface StatsDataSource {

    fun getBasicData(pageData : PageData) : Single<StatsBasicInfoData>

    fun getPlayerSeasonAverages(playerSeasonIdData: PlayerSeasonIdData) : Single<PlayerSeasonAveragesInfoData>
}