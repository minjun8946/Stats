package com.example.data.base

import com.example.domain.base.ErrorHandler
import com.example.domain.base.Message
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class ErrorHandlerImpl: ErrorHandler {

    override fun errorHandle(throwable: Throwable?): Message {
        return when (throwable) {
            is HttpException -> when(throwable.code()) {
                400 -> Message.INVALID
                401 -> Message.UNAUTHORIZED
                404 -> Message.NOT_FOUND
                403 -> Message.FORBIDDEN
                406 -> Message.NOT_ACCEPTABLE
                409 -> Message.CONFLICT
                413 -> Message.PAYLOAD_TOO_LARGE
                500 -> Message.SERVER_ERROR
                520 -> Message.UNKNOWN_ERROR
                else -> Message.UNKNOWN_ERROR
            }
            is ConnectException, is SocketTimeoutException, is UnknownHostException -> Message.NETWORK_ERROR
            else -> Message.UNKNOWN_ERROR
        }
    }

}
