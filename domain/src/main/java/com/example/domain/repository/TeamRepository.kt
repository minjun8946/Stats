package com.example.domain.repository

import com.example.domain.entity.TeamBasicInfo
import io.reactivex.Single

interface TeamRepository {

    fun getTeamList() : Single<TeamBasicInfo>
}