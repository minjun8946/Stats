package com.example.data.remote

import com.example.data.entity.*
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

    @GET("teams")
    fun getTeamList() : Single<TeamBasicInfoData>

    @GET("games")
    fun getGameData(
        @Query("dates[]") date : String
    ) : Single<GamesInfoData>

    @GET("stats")

    fun getPlayerStatsInfo(
        @Query("game_ids[]") id : Int
    ) : Single<PlayerStatsInfoData>
}