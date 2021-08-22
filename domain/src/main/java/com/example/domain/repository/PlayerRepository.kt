package com.example.domain.repository

import com.example.domain.entity.Page
import com.example.domain.entity.PlayerSeasonAveragesInfo
import com.example.domain.entity.PlayerSeasonId
import com.example.domain.entity.StatsBasicInfo
import io.reactivex.Single

interface PlayerRepository {

    fun getAllPlayerInfo(page : Page) : Single<StatsBasicInfo>

    fun getPlayerSeasonAverages(playerSeasonId : PlayerSeasonId) : Single<PlayerSeasonAveragesInfo>
}