package com.example.data.datasource

import com.example.data.entity.PageData
import com.example.data.entity.StatsBasicInfoData
import io.reactivex.Single

interface StatsDataSource {

    fun getBasicData(pageData : PageData) : Single<StatsBasicInfoData>
}