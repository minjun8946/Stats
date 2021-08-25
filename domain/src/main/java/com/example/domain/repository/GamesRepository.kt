package com.example.domain.repository

import com.example.domain.entity.Date
import com.example.domain.entity.GamesInfo
import io.reactivex.Single

interface GamesRepository {

    fun getGamesData(date : Date) : Single<GamesInfo>
}