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
import okhttp3.internal.notify
import okhttp3.internal.notifyAll
import retrofit2.HttpException

class MainViewModel(
    private val getAllPlayerUseCase: GetAllPlayerUseCase,
):BaseViewModel() {



    val successEvent =SingleLiveEvent<Unit>()

    fun getAllPlayer(pageModel : PageModel){

        val allPlayerResult = getAllPlayerUseCase.create(pageModel.toEntity())

        val disposableSingleObserver = object : DisposableSingleObserver<Result<StatsBasicInfo>>(){
            override fun onSuccess(t: Result<StatsBasicInfo>) {
                println("wowowowowowowowowowow")
                successEvent.setValue(Unit)
                if (t is Result.Success){
                    println(t.response.meta.totalPage)
                }
                else if(t is Result.Error){
                    println(t.response)
                }
                println(t.toString())

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