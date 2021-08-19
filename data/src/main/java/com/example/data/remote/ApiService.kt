package com.example.data.remote

import com.example.data.entity.PlayerSeasonAveragesInfoData
import com.example.data.entity.StatsBasicInfoData
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("players")
    fun getAllPlayerInfo(
        @Query("page") page : Int,
        @Query("per_page") perPage : Int,
        @Query("search") search : String?
    ):Single<StatsBasicInfoData>

    @GET("season_averages")
    fun getPlayerSeasonAveragesInfo(
        @Query("season") season : Int,
        @Query("player_ids[]") playerId : Int
    ) : Single<PlayerSeasonAveragesInfoData>
}