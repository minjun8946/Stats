package com.example.domain.base

import io.reactivex.Single

abstract class UseCase<T, E>() {

    abstract fun create(data: T): Single<E>
}