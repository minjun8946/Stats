package com.example.data.datasource

import com.example.data.entity.GetAllPlayerResponse
import com.example.data.entity.PageData
import com.example.data.remote.ApiService
import io.reactivex.Single

class StatsDataSourceImpl(private val api : ApiService) : StatsDataSource{
    override fun getBasicData(pageData: PageData): Single<GetAllPlayerResponse> =
        api.getAllPlayerInfo(
            page= pageData.page,
            perPage = pageData.perPage,
            search = pageData.search
        )
}