package com.example.stats.base

import androidx.lifecycle.ViewModel
import com.example.domain.base.UseCase
import com.example.domain.usecase.GetPlayerStatsUseCase
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

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}