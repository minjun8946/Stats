package com.example.domain.service

import com.example.domain.base.Result
import com.example.domain.entity.Page
import com.example.domain.entity.StatsBasicInfo
import io.reactivex.Single

interface StatsService {

    fun getAllPlayer(page : Page) : Single<Result<StatsBasicInfo>>
}