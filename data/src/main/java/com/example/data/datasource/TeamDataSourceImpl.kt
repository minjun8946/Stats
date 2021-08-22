package com.example.data.datasource

import com.example.data.entity.TeamBasicInfoData
import com.example.data.remote.ApiService
import io.reactivex.Single

class TeamDataSourceImpl(private val apiService : ApiService) : TeamDataSource {

    override fun getTeamData(): Single<TeamBasicInfoData> = apiService.getTeamList()
}