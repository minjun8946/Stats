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
    ):Single<StatsBasicInfoResponse>

    @GET("season_averages")
    fun getPlayerSeasonAveragesInfo(
        @Query("season") season : Int,
        @Query("player_ids[]") playerId : Int
    ) : Single<PlayerSeasonAveragesInfoResponse>

    @GET("teams")
    fun getTeamList() : Single<TeamBasicInfoResponse>

    @GET("games")
    fun getGameData(
        @Query("dates[]") date : String?,
        @Query("seasons[]") season : Int?,
        @Query("team_ids[]") teamId : Int?,
        @Query("page") page : Int,
        @Query("per_page") perPage: Int,
    ) : Single<GamesInfoResponse>

    @GET("stats")
    fun getPlayerStatsInfo(
        @Query("game_ids[]") gameId : Int,
        @Query("per_page") perPage: Int
    ) : Single<PlayerStatsInfoResponse>
}