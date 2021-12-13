package com.example.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface GameResultDao {

    @Query("SELECT * FROM GameResultEntity")
    fun getGameResult() : Single<List<GameResultEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGame(gameData : List<GameResultEntity>?) : Completable
}