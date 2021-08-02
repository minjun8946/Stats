package com.example.domain.repository

import com.example.domain.entity.Page
import com.example.domain.entity.StatsBasicInfo
import io.reactivex.Single

interface StatsRepository {

    fun getAllPlayerInfo(page : Page) : Single<StatsBasicInfo>

}