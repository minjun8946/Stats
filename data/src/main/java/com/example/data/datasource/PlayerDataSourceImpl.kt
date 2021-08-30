package com.example.data.datasource

import com.example.data.entity.*
import com.example.data.remote.ApiService
import io.reactivex.Single

class PlayerDataSourceImpl(private val api : ApiService) : PlayerDataSource{
    override fun getBasicData(
        pageData: PageData
    ): Single<StatsBasicInfoData> =
        api.getAllPlayerInfo(
            page= pageData.page,
            perPage = pageData.perPage,
            search = pageData.search
        )

    override fun getPlayerSeasonAverages(
        playerSeasonIdData: PlayerSeasonIdData
    ): Single<PlayerSeasonAveragesInfoData> =
        api.getPlayerSeasonAveragesInfo(
            season = playerSeasonIdData.season,
            playerId = playerSeasonIdData.playerId
        )

    override fun getPlayerStats(gamesId: Int): Single<PlayerStatsInfoData> =
        api.getPlayerStatsInfo(gamesId)

}