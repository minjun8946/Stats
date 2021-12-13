package com.example.data.datasource

import com.example.data.entity.DateData
import com.example.data.entity.GamesInfoResponse
import io.reactivex.Single

interface GamesDataSource {
    fun getGamesData(date : DateData) : Single<GamesInfoResponse>
}