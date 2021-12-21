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
import com.example.stats.base.SingleLiveEvent
import com.example.stats.base.teamName
import com.example.stats.model.*
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject
import kotlin.math.round

@HiltViewModel
class TeamViewModel @Inject constructor(
    private val getTeamListUseCase: GetTeamListUseCase,
    private val getGamesDataUseCase: GetGamesDataUseCase,
    private val insertGameDataUseCase: InsertGameDataUseCase,
    private val getGameResultUseCase: GetGameResultUseCase
) : BaseViewModel() {

    val teamAdapter = RecyclerViewAdapter()
    var teamBasicModel = ArrayList<BasicTeamModel>()

    private val gameResultModel = mutableListOf<GameResultModel>()

    val sizeEvent = SingleLiveEvent<Int>()

    val getTeamEvent = SingleLiveEvent<Unit>()


    fun getTeamList() {
        val disposableSingleObserver = object : DisposableSingleObserver<Result<TeamBasicInfo>>() {
            override fun onSuccess(result: Result<TeamBasicInfo>) {
                when (result) {
                    is Result.Success -> {
                        println(result.response.data)
                        teamBasicModel =
                            result.response.data.map { it.toEntity() } as ArrayList<BasicTeamModel>
                        getTeamEvent.setValue(Unit)
                    }
                    else -> println("error")
                }
            }

            override fun onError(e: Throwable) {
                println("error")
            }
        }
        execute(Unit, disposableSingleObserver, getTeamListUseCase)
    }

    fun checkRoomData(year: String) {
        val disposableSingleObserver =
            object : DisposableSingleObserver<Result<List<GameResult>>>() {

                override fun onSuccess(t: Result<List<GameResult>>) {
                    when (t) {
                        is Result.Success -> {
                            sizeEvent.setValue(t.response.size / 100)
                        }
                        else -> println("error")
                    }
                }

                override fun onError(e: Throwable) {
                    println("error")
                }
            }
        execute(year, disposableSingleObserver, getGameResultUseCase)
    }


    fun getGameData(data: DateModel) {
        val disposableSingleObserver = object : DisposableSingleObserver<Result<GamesInfo>>() {
            @RequiresApi(Build.VERSION_CODES.O)
            override fun onSuccess(t: Result<GamesInfo>) {
                when (t) {
                    is Result.Success -> {
                        println("success ${data.season}")
                        val gamesData =
                            t.response.data.map { it.toEntity() } as ArrayList<GamesModel>
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


    fun insertGameData(data: List<GameResult>) {
        val disposableSingleObserver = object : DisposableSingleObserver<Result<Unit>>() {
            override fun onSuccess(t: Result<Unit>) {
                println("성공 ${data.size}")
            }

            override fun onError(e: Throwable) {
                println("실패")
            }
        }
        execute(data, disposableSingleObserver, insertGameDataUseCase)
    }

    fun getGameResult(year: String) {
        val disposableSingleObserver =
            object : DisposableSingleObserver<Result<List<GameResult>>>() {
                @RequiresApi(Build.VERSION_CODES.N)
                override fun onSuccess(t: Result<List<GameResult>>) {
                    when (t) {
                        is Result.Success -> {
                            gameWinLose(t.response)
                            println("gameResult ${t.response[1].season}")


                        }
                        else -> {
                            println("error")
                        }
                    }
                }

                override fun onError(e: Throwable) {
                    println("실패")
                }

            }
        execute(year, disposableSingleObserver, getGameResultUseCase)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun gameWinLose(gameResult: List<GameResult>) {
        val win = mutableMapOf<Int, Int>()
        val lose = mutableMapOf<Int, Int>()

        for (i in 1..30) {
            win[i] = 0
            lose[i] = 0
        }
        println(gameResult.size)

        for (i in gameResult.indices) {
            val homeTeamId = gameResult[i].homeTeam.homeTeamId
            val visitorTeamId = gameResult[i].visitorTeam.visitorId
            val homeTeamScore = gameResult[i].homeTeamScore.toInt()
            val visitorTeamScore = gameResult[i].visitorTeamScore.toInt()


            if (gameResult[1].season == "2021 - 2022") {
                if (homeTeamScore > visitorTeamScore &&
                    gameResult[i].gameDate.replace("-", "").toInt() > 20211019 &&
                    !gameResult[i].postSeason
                ) {
                    win.replace(homeTeamId, win[homeTeamId]!! + 1)
                    lose.replace(visitorTeamId, lose[visitorTeamId]!! + 1)
                } else if (homeTeamScore < visitorTeamScore &&
                    gameResult[i].gameDate.replace("-", "").toInt() > 20211019 &&
                    !gameResult[i].postSeason
                ) {
                    lose.replace(homeTeamId, lose[homeTeamId]!! + 1)
                    win.replace(visitorTeamId, win[visitorTeamId]!! + 1)
                }
            } else {
                if (homeTeamScore > visitorTeamScore && !gameResult[i].postSeason) {
                    win.replace(homeTeamId, win[homeTeamId]!! + 1)
                    lose.replace(visitorTeamId, lose[visitorTeamId]!! + 1)
                    //println("idss ${gameResult[i].homeTeam.homeCityName} ${gameResult[i].gameDate} ")
                } else if (homeTeamScore < visitorTeamScore && !gameResult[i].postSeason) {
                    lose.replace(homeTeamId, lose[homeTeamId]!! + 1)
                    win.replace(visitorTeamId, win[visitorTeamId]!! + 1)
                    //println("idss ${gameResult[i].visitorTeam.visitorCityName} ${gameResult[i].gameDate} ")
                }
            }
        }
        gameResultModel.clear()
        println("result  ${gameResult[1].season}$win $lose")

        for (i in 0..29) {
            val resultModel = GameResultModel(
                rank(win, lose, i),
                win.values.toList()[i].toString(),
                lose.values.toList()[i].toString(),
                i + 1,
                teamName(i + 1),
                "${
                    calculateRate(win,lose,i)
                }"
            )
            gameResultModel.add(resultModel)
        }
        gameResultModel.sortByDescending { 30 - it.rank.toInt() }

        teamAdapter.changeData(gameResultModel.map { it.toRecyclerItem() })

    }

    private fun rank(win: MutableMap<Int, Int>, lose: MutableMap<Int, Int>, teamNumber: Int): String {
        val mutableList = mutableListOf<Team>()

        for(i in 0..29) {
            mutableList.add(Team(i, calculateRate(win, lose, i)))
        }

        mutableList.sortBy { it.rate }

        val team = mutableList.find { it.teamNumber == teamNumber }

        return (30 - mutableList.indexOf(team)).toString()
    }

    private fun GameResultModel.toRecyclerItem() =
        RecyclerItem(
            data = this,
            variableId = BR.repo,
            layoutId = R.layout.item_team
        )

    private fun calculateRate(win: MutableMap<Int, Int>, lose: MutableMap<Int, Int>, i: Int): Double {
        return round(win.values.toList()[i] / (win.values.toList()[i] + lose.values.toList()[i]).toDouble() * 1000) / 1000
    }

    class Team(
        val teamNumber: Int,
        val rate: Double
    )

}