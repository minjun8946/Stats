package com.example.domain.service

import com.example.domain.base.Result
import com.example.domain.entity.*
import io.reactivex.Single

interface PlayerService {

    fun getAllPlayer(page : Page) : Single<Result<StatsBasicInfo>>

    fun getPlayerSeasonAverages(playerSeasonId : PlayerSeasonId) : Single<Result<PlayerSeasonAveragesInfo>>
}