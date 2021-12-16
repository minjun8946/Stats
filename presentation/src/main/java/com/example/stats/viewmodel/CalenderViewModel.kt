package com.example.stats.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.domain.base.Result
import com.example.domain.entity.GameResult
import com.example.domain.entity.GamesInfo
import com.example.domain.usecase.GetGameResultUseCase
import com.example.domain.usecase.GetGamesDataUseCase
import com.example.domain.usecase.InsertGameDataUseCase
import com.example.stats.BR
import com.example.stats.R
import com.example.stats.adapter.RecyclerItem
import com.example.stats.adapter.RecyclerViewAdapter
import com.example.stats.base.BaseViewModel
import com.example.stats.model.DateModel
import com.example.stats.model.GamesModel
import com.example.stats.model.toEntity
import com.example.stats.model.toGameResult
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

@HiltViewModel
class CalenderViewModel @Inject constructor(
    private val getGamesDataUseCase : GetGamesDataUseCase,
    private val getGameResultUseCase: GetGameResultUseCase
) : BaseViewModel() {

    var gamesData = ArrayList<GamesModel>()
    var gameListAdapter = RecyclerViewAdapter()

    fun getGamesData(date : DateModel){

        val disposableObserver = object : DisposableSingleObserver<Result<GamesInfo>>(){
            @RequiresApi(Build.VERSION_CODES.O)
            override fun onSuccess(t: Result<GamesInfo>) {
                when(t){
                    is Result.Success -> {
                        gamesData = t.response.data.map { it.toEntity() } as ArrayList<GamesModel>
                        gameListAdapter.changeData(gamesData.map { it.toRecyclerItem() })
                        println(gamesData)
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