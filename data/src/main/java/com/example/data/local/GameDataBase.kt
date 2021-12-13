package com.example.data.local

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
    entities = [GameResultEntity::class],
    version = 1
)
abstract class GameDataBase : RoomDatabase() {
    
    abstract fun gameDao() : GameResultDao
}