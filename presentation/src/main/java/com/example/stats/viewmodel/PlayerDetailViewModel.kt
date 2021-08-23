package com.example.stats.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.domain.base.Result
import com.example.domain.entity.PlayerSeasonAveragesInfo
import com.example.domain.usecase.GetPlayerSeasonAveragesUseCase
import com.example.stats.BR
import com.example.stats.R
import com.example.stats.adapter.RecyclerItem
import com.example.stats.adapter.RecyclerViewAdapter
import com.example.stats.base.BaseViewModel
import com.example.stats.base.SingleLiveEvent
import com.example.stats.model.PlayerSeasonAveragesModel
import com.example.stats.model.PlayerSeasonIdModel
import com.example.stats.model.toEntity
import io.reactivex.observers.DisposableSingleObserver
import java.time.Instant
import java.time.LocalDate
import java.util.*
import kotlin.collections.ArrayList
import kotlin.time.hours

class PlayerDetailViewModel(
    private val getPlayerSeasonAveragesUseCase: GetPlayerSeasonAveragesUseCase
) : BaseViewModel() {

    var playerStatList = ArrayList<PlayerSeasonAveragesModel>()
    val playerAdapter = RecyclerViewAdapter()

    val getPlayerSeasonEvent = SingleLiveEvent<Int>()

    @RequiresApi(Build.VERSION_CODES.O)
    val date = LocalDate.now().year


    fun setYear(){
        if (getPlayerSeasonEvent.value == null) getPlayerSeasonEvent.setValue(date)
        else getPlayerSeasonEvent.setValue(getPlayerSeasonEvent.value!! -1)
    }

    fun getPlayerSeasonStats(playerSeasonIdModel: PlayerSeasonIdModel){

        val disposableSingleObserver = object :
            DisposableSingleObserver<Result<PlayerSeasonAveragesInfo>>(){
            override fun onSuccess(result: Result<PlayerSeasonAveragesInfo>) {
                when(result){
                    is Result.Success -> if (result.response.playerSeasonAveragesInfo != null){
                        playerStatList = result.response.playerSeasonAveragesInfo!!.map { it.toEntity() } as ArrayList<PlayerSeasonAveragesModel>
                        playerAdapter.addData(playerStatList.map { it.toRecyclerItem() })
                        setYear()
                        println(result.response)
                    }
                    is Result.Error -> println("error")
                }
            }
            override fun onError(e: Throwable) {
                println("ERROR")
            }
        }
        execute(playerSeasonIdModel.toEntity(),disposableSingleObserver, getPlayerSeasonAveragesUseCase)
    }

    fun PlayerSeasonAveragesModel.toRecyclerItem() =
        RecyclerItem(
            data = this,
            variableId = BR.repo,
            layoutId = R.layout.item_detail_player
        )

}