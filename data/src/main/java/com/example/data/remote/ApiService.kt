package com.example.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("players")
    fun getPlayerInfo(
        @Query("page") page : Int,

        @Query("per_page") perPage : Int,

        @Query("search") search : String
    )
}