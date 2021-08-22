package com.example.domain.usecase

import com.example.domain.base.Result
import com.example.domain.base.UseCase
import com.example.domain.entity.TeamBasicInfo
import com.example.domain.service.TeamService
import io.reactivex.Single

class GetTeamListUseCase(
    private val teamService: TeamService
) : UseCase<Unit, Result<TeamBasicInfo>>() {
    override fun create(data: Unit): Single<Result<TeamBasicInfo>> {
        return teamService.getTeamList()
    }
}