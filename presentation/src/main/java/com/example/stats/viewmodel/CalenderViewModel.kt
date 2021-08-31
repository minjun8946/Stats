package com.example.stats.viewmodel

import com.example.domain.base.Message
import com.example.domain.base.Result
import com.example.domain.entity.GameId
import com.example.domain.entity.GamesInfo
import com.example.domain.entity.PlayerStatsInfo
import com.example.domain.usecase.GetGamesDataUseCase
import com.example.domain.usecase.GetPlayerStatsUseCase
import com.example.stats.BR
import com.example.stats.R
import com.example.stats.adapter.RecyclerItem
import com.example.stats.adapter.RecyclerViewAdapter
import com.example.stats.base.BaseViewModel
import com.example.stats.model.DateModel
import com.example.stats.model.GameIdModel
import com.example.stats.model.GamesModel
import com.example.stats.model.toEntity
import io.reactivex.observers.DisposableSingleObserver
import okhttp3.internal.assertThreadDoesntHoldLock
import okhttp3.internal.assertThreadHoldsLock
import retrofit2.HttpException

class CalenderViewModel(
    private val getGamesDataUseCase : GetGamesDataUseCase,
    private val getPlayerStatsUseCase: GetPlayerStatsUseCase
) : BaseViewModel() {

    var gamesData = ArrayList<GamesModel>()
    var gameListAdapter = RecyclerViewAdapter()

    fun getStats(gameId: GameIdModel){

        val disposableSingleObserver = object : DisposableSingleObserver<Result<PlayerStatsInfo>>(){
            override fun onSuccess(t: Result<PlayerStatsInfo>) {

                when(t){
                    is Result.Success ->println(t)
                    is Result.Error -> {
                        println(t)

                    }
                }
            }
            override fun onError(e: Throwable) {
                println(e.message)
            }
        }
        execute(gameId.toEntity(), disposableSingleObserver, getPlayerStatsUseCase)

    }

    fun getGamesData(date : DateModel){

        val disposableObserver = object : DisposableSingleObserver<Result<GamesInfo>>(){

            override fun onSuccess(t: Result<GamesInfo>) {
                when(t){
                    is Result.Success -> {
                        gamesData = t.response.data.map { it.toEntity() } as ArrayList<GamesModel>
                        gameListAdapter.changeData(gamesData.map { it.toRecyclerItem() })
                    }
                    is Result.Error -> println(t.response)
                }
            }

            override fun onError(e: Throwable) {
                println("Error")
            }
        }

        execute(date.toEntity(),disposableObserver,getGamesDataUseCase)
    }
    fun GamesModel.toRecyclerItem() =
        RecyclerItem(
            data = this,
            variableId = BR.repo,
            layoutId = R.layout.item_game_list
        )

}