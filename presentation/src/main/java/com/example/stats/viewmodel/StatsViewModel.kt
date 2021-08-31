package com.example.stats.viewmodel

import com.example.domain.base.Result
import com.example.domain.entity.PlayerStatsInfo
import com.example.domain.usecase.GetPlayerStatsUseCase
import com.example.stats.base.BaseViewModel
import com.example.stats.model.GameIdModel
import com.example.stats.model.toEntity
import io.reactivex.observers.DisposableSingleObserver
import retrofit2.HttpException

class StatsViewModel(
    private val getPlayerStatsUseCase: GetPlayerStatsUseCase
) : BaseViewModel() {

    fun getStats(gameId: GameIdModel){

        val disposableSingleObserver = object : DisposableSingleObserver<Result<PlayerStatsInfo>>(){
            override fun onSuccess(t: Result<PlayerStatsInfo>) {

                when(t){
                    is Result.Success ->println("$t")
                    is Result.Error -> {
                        onErrorData(t)
                    }
                }
            }
            override fun onError(e: Throwable) {
                when(e){
                    is HttpException ->{
                        println(e.message())
                    }
                    else -> println(e.printStackTrace())
                }
            }
        }
        execute(gameId.toEntity(), disposableSingleObserver, getPlayerStatsUseCase)

    }

}