package com.example.stats.viewmodel


import com.example.domain.base.Result
import com.example.domain.entity.StatsBasicInfo
import com.example.domain.usecase.GetAllPlayerUseCase
import com.example.stats.base.BaseViewModel
import com.example.stats.base.SingleLiveEvent
import com.example.stats.model.PageModel
import com.example.stats.model.toEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class MainViewModel(
    private val getAllPlayerUseCase: GetAllPlayerUseCase,
):BaseViewModel() {

    init {
        getAllPlayer(PageModel(1,10,"A"))
    }

    val successEvent =SingleLiveEvent<Unit>()

    fun getAllPlayer(pageModel : PageModel){

        val allPlayerResult = getAllPlayerUseCase.create(pageModel.toEntity())

        val disposableSingleObserver = object : DisposableSingleObserver<Result<StatsBasicInfo>>(){
            override fun onSuccess(t: Result<StatsBasicInfo>) {
                println("wowowowowowowowowowow")
                successEvent.setValue(Unit)
            }

            override fun onError(e: Throwable) {
                println("alsdjfa;lsdkfja;dklsfja;lksfd")
            }
        }
        val disposable = allPlayerResult
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(disposableSingleObserver)

        addDisposable(disposable)
    }


}