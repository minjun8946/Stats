package com.example.stats.viewmodel

import com.example.domain.base.Result
import com.example.domain.entity.TeamBasicInfo
import com.example.domain.usecase.GetTeamListUseCase
import com.example.stats.BR
import com.example.stats.R
import com.example.stats.adapter.RecyclerItem
import com.example.stats.adapter.RecyclerViewAdapter
import com.example.stats.base.BaseViewModel
import com.example.stats.model.BasicTeamModel
import com.example.stats.model.toEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

@HiltViewModel
class TeamViewModel @Inject constructor(
    private val getTeamListUseCase: GetTeamListUseCase,
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
    fun BasicTeamModel.toRecyclerItem() =
        RecyclerItem(
            data = this,
            variableId = BR.repo,
            layoutId = R.layout.item_team
        )
}