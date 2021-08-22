package com.example.data.repository

import com.example.data.datasource.PlayerDataSource
import com.example.data.datasource.TeamDataSource
import com.example.data.entity.toEntity
import com.example.domain.entity.TeamBasicInfo
import com.example.domain.repository.TeamRepository
import io.reactivex.Single

class TeamRepositoryImpl(
    private val dataSource : TeamDataSource
) : TeamRepository{

    override fun getTeamList(): Single<TeamBasicInfo> =
        dataSource.getTeamData().map { it.toEntity() }

}