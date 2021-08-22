package com.example.domain.service

import com.example.domain.base.Result
import com.example.domain.entity.TeamBasicInfo
import com.example.domain.repository.TeamRepository
import com.example.domain.toResult
import io.reactivex.Single

class TeamServiceImpl(
    private val teamRepository: TeamRepository
) : TeamService {
    override fun getTeamList(): Single<Result<TeamBasicInfo>> =
        teamRepository.getTeamList().toResult()
}