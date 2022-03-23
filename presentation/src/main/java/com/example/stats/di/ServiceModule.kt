package com.example.stats.di

import com.example.data.base.ErrorHandlerImpl
import com.example.domain.base.ErrorHandler
import com.example.domain.repository.GamesRepository
import com.example.domain.repository.PlayerRepository
import com.example.domain.repository.TeamRepository
import com.example.domain.service.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    fun provideErrorHandle(): ErrorHandler{
        return ErrorHandlerImpl()
    }

    @Provides
    fun provideGamesService(
        gamesRepository: GamesRepository,
        errorHandler: ErrorHandler
    ) : GamesService{
        return GamesServiceImpl(gamesRepository, errorHandler)
    }

    @Provides
    fun providePlayerService(
        playerRepository: PlayerRepository,
        errorHandler: ErrorHandler
    ) : PlayerService {
        return PlayerServiceImpl(playerRepository, errorHandler)
    }

    @Provides
    fun provideTeamService(
        teamRepository: TeamRepository,
        errorHandler: ErrorHandler
    ) : TeamService {
        return TeamServiceImpl(teamRepository, errorHandler)
    }

}