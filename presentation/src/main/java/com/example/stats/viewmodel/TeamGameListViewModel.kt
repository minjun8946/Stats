package com.example.stats.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.domain.base.Result
import com.example.domain.entity.GamesInfo
import com.example.domain.usecase.GetGamesDataUseCase
import com.example.stats.BR
import com.example.stats.R
import com.example.stats.adapter.RecyclerItem
import com.example.stats.adapter.RecyclerViewAdapter
import com.example.stats.base.BaseViewModel
import com.example.stats.model.*
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

@HiltViewModel
class TeamGameListViewModel @Inject constructor(
    private val getGamesDataUseCase: GetGamesDataUseCase,
) : BaseViewModel() {

    var gamesData = ArrayList<GamesModel>()
    var gameListAdapter = RecyclerViewAdapter()

    fun getTeamGamesData(date: DateModel) {

        val disposableObserver = object : DisposableSingleObserver<Result<GamesInfo>>() {
            @RequiresApi(Build.VERSION_CODES.O)
            override fun onSuccess(t: Result<GamesInfo>) {
                when (t) {
                    is Result.Success -> {
                        println(t.response.data)
                        gamesData = t.response.data.filter { it.visitorTeamScore != 0 }
                            .map { it.toEntity() } as ArrayList<GamesModel>
                        gamesData.sortBy { it.gameDate }
                        gameListAdapter.changeData(gamesData.map { it.toRecyclerItem() })
                    }
                    is Result.Error -> println(t.response)
                }
            }
            override fun onError(e: Throwable) {
                println("Error")
            }
        }
        execute(date.toEntity(), disposableObserver, getGamesDataUseCase)
    }

    fun GamesModel.toRecyclerItem() =
        RecyclerItem(
            data = this,
            variableId = BR.repo,
            layoutId = R.layout.item_game_list
        )
}