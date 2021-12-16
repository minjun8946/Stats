package com.example.stats.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.domain.base.Result
import com.example.domain.entity.GameResult
import com.example.domain.entity.GamesInfo
import com.example.domain.entity.TeamBasicInfo
import com.example.domain.usecase.GetGameResultUseCase
import com.example.domain.usecase.GetGamesDataUseCase
import com.example.domain.usecase.GetTeamListUseCase
import com.example.domain.usecase.InsertGameDataUseCase
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
class TeamViewModel @Inject constructor(
    private val getTeamListUseCase: GetTeamListUseCase,
    private val getGamesDataUseCase: GetGamesDataUseCase,
    private val insertGameDataUseCase: InsertGameDataUseCase,
    private val getGameResultUseCase: GetGameResultUseCase
) : BaseViewModel() {

    val teamAdapter = RecyclerViewAdapter()
    var teamBasicModel = ArrayList<BasicTeamModel>()



    fun getTeamList(){
        val disposableSingleObserver = object : DisposableSingleObserver<Result<TeamBasicInfo>>(){
            override fun onSuccess(result: Result<TeamBasicInfo>) {
                when(result){
                    is Result.Success -> {
                        println(result.response.data)
                        teamBasicModel = result.response.data.map { it.toEntity() } as ArrayList<BasicTeamModel>
                        teamAdapter.addData(teamBasicModel.map { it.toRecyclerItem() })
                    }
                    else -> println("error")
                }
            }

            override fun onError(e: Throwable) {
                println("error")
            }
        }
        execute(Unit,disposableSingleObserver,getTeamListUseCase)
    }

    fun getGameData(data : DateModel) {
        val disposableSingleObserver = object : DisposableSingleObserver<Result<GamesInfo>>() {
            @RequiresApi(Build.VERSION_CODES.O)
            override fun onSuccess(t: Result<GamesInfo>) {
                when (t) {
                    is Result.Success -> {
                        println("success ${data.page} ${t.response}")
                        val gamesData = t.response.data.map { it.toEntity() } as ArrayList<GamesModel>
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

    fun getGameResult(year : String){
        val disposableSingleObserver = object : DisposableSingleObserver<Result<List<GameResult>>>(){
            @RequiresApi(Build.VERSION_CODES.N)
            override fun onSuccess(t: Result<List<GameResult>>) {
                when(t){
                    is Result.Success -> {
                        gameWinLose(t.response)

                    }else ->{
                        println("error")
                    }
                }
            }

            override fun onError(e: Throwable) {
                println("실패")
            }

        }
        execute(year,disposableSingleObserver,getGameResultUseCase)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun gameWinLose(gameResult : List<GameResult>) {
        val win = mutableMapOf<Int, Int>()
        val lose = mutableMapOf<Int, Int>()
        for (i in 1..30) {
            win[i] = 0
            lose[i] = 0
        }

        for (i in gameResult.indices) {
            val homeTeamId = gameResult[i].homeTeam.homeTeamId
            val visitorTeamId = gameResult[i].visitorTeam.visitorId
            val homeTeamScore = gameResult[i].homeTeamScore.toInt()
            val visitorTeamScore = gameResult[i].visitorTeamScore.toInt()

            if (gameResult[1].season == "2021 - 2022") {
                if (homeTeamScore > visitorTeamScore &&
                    gameResult[i].gameDate.replace("-", "").toInt() > 20211019
                ) {
                    win.replace(homeTeamId, win[homeTeamId]!! + 1)
                    lose.replace(visitorTeamId, lose[visitorTeamId]!! + 1)
                } else if (homeTeamScore < visitorTeamScore &&
                    gameResult[i].gameDate.replace("-", "").toInt() > 20211019
                ) {
                    lose.replace(homeTeamId, lose[homeTeamId]!! + 1)
                    win.replace(visitorTeamId, win[visitorTeamId]!! + 1)
                }
            } else {
                if (homeTeamScore > visitorTeamScore) {
                    win.replace(homeTeamId, win[homeTeamId]!! + 1)
                    lose.replace(visitorTeamId, lose[visitorTeamId]!! + 1)

                } else if (homeTeamScore < visitorTeamScore) {
                    lose.replace(homeTeamId, lose[homeTeamId]!! + 1)
                    win.replace(visitorTeamId, win[visitorTeamId]!! + 1)
                }
            }
        }
        println("result $win $lose")

    }

    fun BasicTeamModel.toRecyclerItem() =
        RecyclerItem(
            data = this,
            variableId = BR.repo,
            layoutId = R.layout.item_team
        )

}