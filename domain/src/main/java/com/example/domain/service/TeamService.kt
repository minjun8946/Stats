package com.example.domain.service

import com.example.domain.base.Result
import com.example.domain.entity.TeamBasicInfo
import io.reactivex.Single

interface TeamService {

    fun getTeamList() : Single<Result<TeamBasicInfo>>
}