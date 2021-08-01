package com.example.data.datasource

import com.example.data.dto.request.AllPlayerPageRequest
import com.example.data.dto.response.GetAllPlayerResponse
import io.reactivex.Single

interface StatsDataSource {

    fun getBasicData(allPlayerPageData : AllPlayerPageRequest) : Single<GetAllPlayerResponse>
}