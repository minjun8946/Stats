package com.example.stats.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data.local.GameDataBase
import com.example.data.local.GameResultDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    fun provideGameDataBase(
        @ApplicationContext context: Context
    ): GameDataBase = Room
        .databaseBuilder(context, GameDataBase::class.java, "gameDataBase")
        .build()

    @Provides
    fun provideGameDao(gameResultDatabase: GameDataBase): GameResultDao = gameResultDatabase.gameDao()

}