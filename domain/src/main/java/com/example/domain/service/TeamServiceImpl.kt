package com.example.domain.service

import com.example.domain.base.ErrorHandler
import com.example.domain.base.Result
import com.example.domain.entity.TeamBasicInfo
import com.example.domain.repository.TeamRepository
import com.example.domain.toResult
import io.reactivex.Single

class TeamServiceImpl(
    private val teamRepository: TeamRepository,
    private val handler : ErrorHandler
) : TeamService {
    override fun getTeamList(): Single<Result<TeamBasicInfo>> =
        teamRepository.getTeamList().toResult(
            handler = handler,
            getLocalDataFun = { teamRepository.getTeamList().blockingGet() },
            saveLocalFun = { T -> teamRepository.getTeamList() }
        )
}