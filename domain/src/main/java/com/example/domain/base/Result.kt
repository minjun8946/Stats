package com.example.domain.base

sealed class Result<T> {

    data class Success<T>(val response: T): Result<T>()

    data class Error<T>(
        var response: T? = null,
        var message: Message
    ): Result<T>()

}