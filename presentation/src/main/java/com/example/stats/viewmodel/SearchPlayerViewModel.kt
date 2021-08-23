package com.example.stats.viewmodel

import com.example.domain.base.Result
import com.example.domain.entity.StatsBasicInfo
import com.example.domain.usecase.GetAllPlayerUseCase
import com.example.stats.BR
import com.example.stats.R
import com.example.stats.adapter.RecyclerItem
import com.example.stats.adapter.RecyclerViewAdapter
import com.example.stats.base.BaseViewModel
import com.example.stats.base.SingleLiveEvent
import com.example.stats.model.BasicModel
import com.example.stats.model.PageModel
import com.example.stats.model.toBasicModel
import com.example.stats.model.toEntity
import io.reactivex.observers.DisposableSingleObserver

class SearchPlayerViewModel(
    private val getAllPlayerUseCase: GetAllPlayerUseCase,
):BaseViewModel() {

    var basicModel = ArrayList<BasicModel>()
    val searchPlayerAdapter = RecyclerViewAdapter()

    var page = 1

    val scrollListenerEvent = SingleLiveEvent<Unit>()
    val searchEvent = SingleLiveEvent<Unit>()

    fun getAllPlayer(pageModel: PageModel) {

        val disposableSingleObserver = object : DisposableSingleObserver<Result<StatsBasicInfo>>() {
            override fun onSuccess(result: Result<StatsBasicInfo>) {
                when (result) {
                    is Result.Success -> {
                        basicModel = result.response.data.map { it.toBasicModel() } as ArrayList<BasicModel>
                        searchPlayerAdapter.addData(basicModel.map { it.toRecyclerItem() })

                        page = when (result.response.meta.page) {
                            null -> ++page
                            else -> result.response.meta.page!!
                        }
                    }
                    is Result.Error -> {
                        println("ERROR")
                    }
                }
            }

            override fun onError(e: Throwable) {
                println("error")
            }
        }
        execute(pageModel.toEntity(), disposableSingleObserver, getAllPlayerUseCase)
    }

    fun onSearchClick() {
        println("click")
        searchPlayerAdapter.clearData()
        page = 1
        searchEvent.setValue(Unit)
    }
    fun BasicModel.toRecyclerItem() =
        RecyclerItem(
            data = this,
            variableId = BR.repo,
            layoutId = R.layout.item_player

        )
}