package com.example.domain.service

import com.example.domain.base.Result
import com.example.domain.entity.Date
import com.example.domain.entity.GamesInfo
import io.reactivex.Single

interface GamesService {

    fun getGamesData(date : Date) : Single<Result<GamesInfo>>
}