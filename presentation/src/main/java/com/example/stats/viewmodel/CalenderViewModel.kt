package com.example.stats.viewmodel

import com.example.domain.base.Result
import com.example.domain.entity.GamesInfo
import com.example.domain.usecase.GetGamesDataUseCase
import com.example.stats.base.BaseViewModel
import com.example.stats.model.DateModel
import com.example.stats.model.toEntity
import io.reactivex.observers.DisposableSingleObserver

class CalenderViewModel(
    private val getGamesDataUseCase : GetGamesDataUseCase
) : BaseViewModel() {


    fun getGamesData(date : DateModel){

        val disposableObserver = object : DisposableSingleObserver<Result<GamesInfo>>(){

            override fun onSuccess(t: Result<GamesInfo>) {
                when(t){
                    is Result.Success -> println(t.response)
                    is Result.Error -> println(t.response)
                }
            }

            override fun onError(e: Throwable) {
                println("Error")
            }
        }

        execute(date.toEntity(),disposableObserver,getGamesDataUseCase)
    }

}