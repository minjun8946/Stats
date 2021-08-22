package com.example.stats.viewmodel

import com.example.domain.base.Result
import com.example.domain.entity.TeamBasicInfo
import com.example.domain.usecase.GetTeamListUseCase
import com.example.stats.base.BaseViewModel
import io.reactivex.observers.DisposableSingleObserver

class TeamViewModel(
    private val getTeamListUseCase: GetTeamListUseCase
) : BaseViewModel() {

    fun getTeamList(){
        val disposableSingleObserver = object : DisposableSingleObserver<Result<TeamBasicInfo>>(){
            override fun onSuccess(t: Result<TeamBasicInfo>) {
                when(t){
                    is Result.Success -> {
                        println(t.response.data)
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

}