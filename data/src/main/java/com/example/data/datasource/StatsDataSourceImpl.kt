package com.example.data.datasource

import com.example.data.entity.PageData
import com.example.data.entity.PlayerSeasonAveragesInfoData
import com.example.data.entity.PlayerSeasonIdData
import com.example.data.entity.StatsBasicInfoData
import com.example.data.remote.ApiService
import io.reactivex.Single

class StatsDataSourceImpl(private val api : ApiService) : StatsDataSource{
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

}