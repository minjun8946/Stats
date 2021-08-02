package com.example.domain.base

import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

abstract class UseCase<T, E>() {

    abstract fun create(data: T): Single<E>
}