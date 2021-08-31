package com.example.domain

import com.example.domain.base.ErrorHandler
import com.example.domain.base.Result
import com.example.domain.entity.GamesInfo
import io.reactivex.Completable
import io.reactivex.Single
import java.net.HttpRetryException

fun <T> Single<T>.toResult(
    handler: ErrorHandler
): Single<Result<T>> = this
    .map {
        Result.Success(it) as Result<T>
    }
    .onErrorReturn {
        Result.Error(message = handler.errorHandle(it))
    }

fun <T> Single<T>.toResult(
    handler: ErrorHandler,
    getLocalDataFun: () -> T?,
    saveLocalFun: (T) -> Unit
): Single<Result<T>> = this
    .toResult(handler)
    .processLocal(getLocalDataFun, saveLocalFun)

fun <T> Single<Result<T>>.processLocal(
    getLocalDataFun: () -> T?,
    saveLocalFun: (T) -> Unit
): Single<Result<T>> = this
    .flatMap { result ->
        when(result) {
            is Result.Success -> {
                saveLocalFun(result.response)
                Single.just(result)
            }
            is Result.Error -> {
                val localData = getLocalDataFun()
                if (localData != null)
                    return@flatMap Single.just(
                        Result.Error(localData, result.message)
                    )
                Single.just(result)
            }
        }
    }