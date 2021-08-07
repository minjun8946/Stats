package com.example.stats.viewmodel


import androidx.lifecycle.MutableLiveData
import com.example.data.entity.BasicData
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

    val successEvent =SingleLiveEvent<Unit>()
    var basicModel = ArrayList<BasicModel>()

    fun getAllPlayer(pageModel : PageModel){

        val allPlayerResult = getAllPlayerUseCase.create(pageModel.toEntity())

        val disposableSingleObserver = object : DisposableSingleObserver<Result<StatsBasicInfo>>(){
            override fun onSuccess(t: Result<StatsBasicInfo>) {

                if (t is Result.Success){
                    basicModel = t.response.data.map { it.toBasicModel() } as ArrayList<BasicModel>
                    successEvent.setValue(Unit)

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

}