package com.example.stats.viewmodel

import com.example.domain.base.Result
import com.example.domain.entity.PlayerStatsInfo
import com.example.domain.entity.TeamBasicInfo
import com.example.domain.usecase.GetPlayerStatsUseCase
import com.example.domain.usecase.GetTeamListUseCase
import com.example.stats.BR
import com.example.stats.R
import com.example.stats.adapter.RecyclerItem
import com.example.stats.adapter.RecyclerViewAdapter
import com.example.stats.base.BaseViewModel
import com.example.stats.model.BasicTeamModel
import com.example.stats.model.toEntity
import io.reactivex.observers.DisposableSingleObserver
import retrofit2.HttpException

class TeamViewModel(
    private val getTeamListUseCase: GetTeamListUseCase,
    private val getPlayerStatsUseCase: GetPlayerStatsUseCase
) : BaseViewModel() {

    val teamAdapter = RecyclerViewAdapter()
    var teamBasicModel = ArrayList<BasicTeamModel>()

    fun getPlayerStats(){
        val disposableSingleObserver = object : DisposableSingleObserver<Result<PlayerStatsInfo>>(){
            override fun onSuccess(t: Result<PlayerStatsInfo>) {
                when(t){
                    is Result.Success ->println(t)
                    is Result.Error -> {
                        println(t.response)
                    }
                }
            }

            override fun onError(e: Throwable) {
                println(e.message)
            }
        }
        execute(448337,disposableSingleObserver,getPlayerStatsUseCase)
    }

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
    fun BasicTeamModel.toRecyclerItem() =
        RecyclerItem(
            data = this,
            variableId = BR.repo,
            layoutId = R.layout.item_team
        )

}