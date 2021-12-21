package com.example.stats.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.domain.base.Result
import com.example.domain.entity.GameResult
import com.example.domain.entity.GamesInfo
import com.example.domain.usecase.GetGameResultUseCase
import com.example.domain.usecase.GetGamesDataUseCase
import com.example.domain.usecase.InsertGameDataUseCase
import com.example.stats.base.BaseViewModel
import com.example.stats.base.SingleLiveEvent
import com.example.stats.model.DateModel
import com.example.stats.model.GamesModel
import com.example.stats.model.toEntity
import com.example.stats.model.toGameResult
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getGamesDataUseCase: GetGamesDataUseCase,
    private val insertGameDataUseCase: InsertGameDataUseCase,
    private val getGamesResultUseCase: GetGameResultUseCase
) : BaseViewModel(){

    var gamesData = ArrayList<GamesModel>()
    val sizeEvent = SingleLiveEvent<Int>()

    fun checkRoomData(year : String){
        val disposableSingleObserver = object : DisposableSingleObserver<Result<List<GameResult>>>(){

            override fun onSuccess(t: Result<List<GameResult>>) {
                when(t){
                    is Result.Success -> {
                        sizeEvent.setValue(t.response.size/100)
                    }
                    else -> println("error")
                }
            }
            override fun onError(e: Throwable) {
                println("error")
            }
        }
        execute(year,disposableSingleObserver,getGamesResultUseCase)
    }

    fun getGameData(data : DateModel) {
        println("실행실행")
        val disposableSingleObserver = object : DisposableSingleObserver<Result<GamesInfo>>() {
            @RequiresApi(Build.VERSION_CODES.O)
            override fun onSuccess(t: Result<GamesInfo>) {
                when (t) {
                    is Result.Success -> {
                        gamesData = t.response.data.map { it.toEntity() } as ArrayList<GamesModel>
                        insertGameData(gamesData.map { it.toGameResult() })
                    }
                    else -> println("error")
                }
            }

            override fun onError(e: Throwable) =
                println("error")
        }
        execute(data.toEntity(), disposableSingleObserver, getGamesDataUseCase)
    }

    fun insertGameData(data : List<GameResult>){
        val disposableSingleObserver = object : DisposableSingleObserver<Result<Unit>>(){
            override fun onSuccess(t: Result<Unit>) {
                println("성공 ${data.size}")
            }

            override fun onError(e: Throwable) {
                println("실패")
            }
        }
        execute(data,disposableSingleObserver,insertGameDataUseCase)
    }

}