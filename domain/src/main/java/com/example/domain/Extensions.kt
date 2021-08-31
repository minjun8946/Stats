package com.example.domain

import com.example.domain.base.Result
import io.reactivex.Completable
import io.reactivex.Single
import java.net.HttpRetryException

fun <T> Single<T>.toResult() : Single<Result<T>> =
    this.map {
        Result.Success(it) as Result<T>
    }.onErrorReturn {
       Result.Error()
    }

fun Completable.toSingleResult() : Single<Result<Unit>> =
    this.toSingle {}.toResult()