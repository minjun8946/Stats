package com.example.data.datasource

import com.example.data.entity.GetAllPlayerResponse
import com.example.data.entity.PageData
import io.reactivex.Single

interface StatsDataSource {

    fun getBasicData(pageData : PageData) : Single<GetAllPlayerResponse>
}