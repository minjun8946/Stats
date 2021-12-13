package com.example.data.datasource

import com.example.data.entity.TeamBasicInfoResponse
import io.reactivex.Single

interface TeamDataSource {

    fun getTeamData() : Single<TeamBasicInfoResponse>
}