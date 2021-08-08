package com.example.stats.viewmodel


import com.example.domain.base.Result
import com.example.domain.entity.StatsBasicInfo
import com.example.domain.usecase.GetAllPlayerUseCase
import com.example.stats.adapter.MainAdapter
import com.example.stats.base.BaseViewModel
import com.example.stats.base.SingleLiveEvent
import com.example.stats.model.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class MainViewModel(
    private val getAllPlayerUseCase: GetAllPlayerUseCase,
):BaseViewModel() {



    var basicModel = ArrayList<BasicModel>()
    val mainAdapter = MainAdapter()
    var page = 1

    val successEvent = SingleLiveEvent<Unit>()
    val scrollListenerEvent = SingleLiveEvent<Unit>()
    val searchEvent = SingleLiveEvent<Unit>()


    fun getAllPlayer(pageModel: PageModel){

        val allPlayerResult = getAllPlayerUseCase.create(pageModel.toEntity())

        val disposableSingleObserver = object : DisposableSingleObserver<Result<StatsBasicInfo>>(){
            override fun onSuccess(result: Result<StatsBasicInfo>) {

                when (result){
                    is Result.Success ->{
                        basicModel = result.response.data.map { it.toBasicModel() } as ArrayList<BasicModel>
                        successEvent.setValue(Unit)
                        mainAdapter.addData(basicModel)

                        page = when(result.response.meta.page){
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
        val disposable = allPlayerResult
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(disposableSingleObserver)

        addDisposable(disposable)
    }

    fun onSearchClick(){
        mainAdapter.clearData()
        page = 1
        searchEvent.setValue(Unit)
    }

}