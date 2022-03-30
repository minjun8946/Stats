package com.example.stats.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.domain.base.Result
import com.example.domain.entity.PlayerStatsInfo
import com.example.domain.usecase.GetPlayerStatsUseCase
import com.example.stats.BR
import com.example.stats.R
import com.example.stats.adapter.RecyclerItem
import com.example.stats.adapter.RecyclerViewAdapter
import com.example.stats.base.BaseViewModel
import com.example.stats.model.GameIdModel
import com.example.stats.model.StatsModel
import com.example.stats.model.toEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.observers.DisposableSingleObserver
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class StatsViewModel @Inject constructor(
    private val getPlayerStatsUseCase: GetPlayerStatsUseCase
) : BaseViewModel() {

    val statsAdapter = RecyclerViewAdapter()
    var gameStatsModel = ArrayList<StatsModel>()

    fun getStats(gameId: GameIdModel) {

        val disposableSingleObserver =
            object : DisposableSingleObserver<Result<PlayerStatsInfo>>() {
                @RequiresApi(Build.VERSION_CODES.O)
                override fun onSuccess(t: Result<PlayerStatsInfo>) {

                    when (t) {
                        is Result.Success -> {
                            gameStatsModel =
                                t.response.data.filter { it.minute != "0:00" && it.minute != null }
                                    .map { it.toEntity() } as ArrayList<StatsModel>
                            if (gameStatsModel[0].gameInfo.homeTeamId > gameStatsModel[0].gameInfo.visitorTeamId)
                                gameStatsModel.sortByDescending { it.teamInfo.teamId }
                            else gameStatsModel.sortBy { it.teamInfo.teamId }
                            statsAdapter.addData(gameStatsModel.map { it.toRecyclerItem() })
                        }
                        is Result.Error -> {
                            onErrorData(t)
                        }
                    }
                }

                override fun onError(e: Throwable) {
                    when (e) {
                        is HttpException -> {
                            println(e.message())
                        }
                        else -> println(e.printStackTrace())
                    }
                }
            }
        execute(gameId.toEntity(), disposableSingleObserver, getPlayerStatsUseCase)
    }

    fun StatsModel.toRecyclerItem() =
        RecyclerItem(
            data = this,
            variableId = BR.repo,
            layoutId = R.layout.item_game_player
        )
}