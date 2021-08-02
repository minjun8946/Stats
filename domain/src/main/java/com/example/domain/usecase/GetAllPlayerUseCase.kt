package com.example.domain.usecase

import com.example.domain.base.Result
import com.example.domain.base.UseCase
import com.example.domain.entity.Page
import com.example.domain.entity.StatsBasicInfo
import com.example.domain.service.StatsService
import io.reactivex.Single

class GetAllPlayerUseCase(private val statsService: StatsService): UseCase<Page, Result<StatsBasicInfo>>() {
    override fun create(data: Page): Single<Result<StatsBasicInfo>> {
        return statsService.getAllPlayer(data)
    }


}