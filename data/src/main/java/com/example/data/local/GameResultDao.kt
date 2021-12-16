package com.example.data.local

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface GameResultDao {

    @Query("SELECT * FROM GameResultEntity WHERE season== :season ")
    fun getGameResult(season : String) : Single<List<GameResultEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGame(gameData : List<GameResultEntity>?) : Completable

}