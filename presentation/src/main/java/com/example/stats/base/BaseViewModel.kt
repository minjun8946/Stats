package com.example.stats.base

import androidx.lifecycle.ViewModel
import com.example.domain.base.Message
import com.example.domain.base.Result
import com.example.domain.base.UseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

open class BaseViewModel : ViewModel(){

    private val compositeDisposable = CompositeDisposable()

    private fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    fun <T,E>execute(
        data: T, disposableSingleObserver: DisposableSingleObserver<E>,
        useCase: UseCase<T,E>
    ){
        val disposable = useCase.create(data)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(disposableSingleObserver)

        addDisposable(disposable)
    }

    fun <T> onErrorData(result: Result.Error<T>) {
        if (result.response != null) {
            when (result.message) {

                Message.UnKnownError -> println("알수없는 오류가 발생했습니다 ${result.message.ordinal}")
                Message.NetWorkError -> println("네트워크 오류가 발생했습니다")
                else ->println("알 수 없는 오류 발생했습니다")
            }
        } else {
            when (result.message) {
                Message.UnKnownError -> println("알수없는 오류가 발생했습니다 ${result.message.ordinal}")
                Message.NetWorkError -> println("네트워크 오류가 발생했습니다")
                else ->println("알 수 없는 오류 발생했습니다")
            }
        }
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}