package com.example.data.datasource

import com.example.data.entity.DateData
import com.example.data.entity.GamesInfoData
import com.example.data.remote.ApiService
import io.reactivex.Single

class GamesDataSourceImpl(
    private val apiService: ApiService
) : GamesDataSource {
    override fun getGamesData(date: DateData): Single<GamesInfoData> =
        apiService.getGameData(
            date = date.date
        )

}