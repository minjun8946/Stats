package com.example.stats.di

import com.example.domain.base.UseCase
import com.example.domain.service.GamesService
import com.example.domain.service.PlayerService
import com.example.domain.service.TeamService
import com.example.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun provideGetAllPlayerUseCase(
        playerService: PlayerService
    ) = GetAllPlayerUseCase(playerService)

    @Singleton
    @Provides
    fun provideGetGamesDataUseCase(
        gamesService: GamesService
    ) = GetGamesDataUseCase(gamesService)

    @Singleton
    @Provides
    fun provideGetPlayerSeasonAveragesUseCase(
        playerService: PlayerService
    ) = GetPlayerSeasonAveragesUseCase(playerService)

    @Singleton
    @Provides
    fun provideGetPlayerStatsUseCase(
        playerService: PlayerService
    ) = GetPlayerStatsUseCase(playerService)

    @Singleton
    @Provides
    fun provideGetTeamListUseCase(
        teamService: TeamService
    ) = GetTeamListUseCase(teamService)
}