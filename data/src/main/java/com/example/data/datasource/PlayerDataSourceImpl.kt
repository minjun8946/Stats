package com.example.data.datasource

import com.example.data.entity.*
import com.example.data.remote.ApiService
import io.reactivex.Single

class PlayerDataSourceImpl(private val api : ApiService) : PlayerDataSource{
    override fun getBasicData(
        pageData: PageData
    ): Single<StatsBasicInfoResponse> =
        api.getAllPlayerInfo(
            page= pageData.page,
            perPage = pageData.perPage,
            search = pageData.search
        )

    override fun getPlayerSeasonAverages(
        playerSeasonIdData: PlayerSeasonIdData
    ): Single<PlayerSeasonAveragesInfoResponse> =
        api.getPlayerSeasonAveragesInfo(
            season = playerSeasonIdData.season,
            playerId = playerSeasonIdData.playerId
        )

    override fun getPlayerStats(gamesId: GameIdData): Single<PlayerStatsInfoResponse> =
        api.getPlayerStatsInfo(
            gameId = gamesId.gameId,
            perPage = gamesId.perPage
        )


}