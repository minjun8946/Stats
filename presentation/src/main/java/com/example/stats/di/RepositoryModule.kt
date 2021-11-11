package com.example.stats.di

import com.example.data.datasource.GamesDataSource
import com.example.data.datasource.PlayerDataSource
import com.example.data.datasource.TeamDataSource
import com.example.data.repository.GamesRepositoryImpl
import com.example.data.repository.PlayerRepositoryImpl
import com.example.data.repository.TeamRepositoryImpl
import com.example.domain.repository.GamesRepository
import com.example.domain.repository.PlayerRepository
import com.example.domain.repository.TeamRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideGamesRepository(
        gamesDataSource: GamesDataSource
    ) : GamesRepository{
        return GamesRepositoryImpl(gamesDataSource)
    }

    @Singleton
    @Provides
    fun providePlayerRepository(
        playerDataSource: PlayerDataSource
    ) : PlayerRepository {
        return PlayerRepositoryImpl(playerDataSource)
    }

    @Singleton
    @Provides
    fun provideTeamRepository(
        teamDataSource: TeamDataSource
    ) : TeamRepository{
        return TeamRepositoryImpl(teamDataSource)
    }
}