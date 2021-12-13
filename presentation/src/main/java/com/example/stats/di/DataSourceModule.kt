package com.example.stats.di

import android.app.Application
import com.example.data.datasource.*
import com.example.data.local.GameResultDao
import com.example.data.remote.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Singleton
    @Provides
    fun provideGamesDataSource(
        apiService: ApiService,
        gameResultDao : GameResultDao
    ) : GamesDataSource {
        return GamesDataSourceImpl(apiService,gameResultDao)
    }

    @Singleton
    @Provides
    fun providePlayerDataSource(
        apiService: ApiService
    ) : PlayerDataSource {
        return PlayerDataSourceImpl(apiService)
    }

    @Singleton
    @Provides
    fun provideTeamDataSource(
        apiService: ApiService
    ) : TeamDataSource {
        return TeamDataSourceImpl(apiService)
    }
}