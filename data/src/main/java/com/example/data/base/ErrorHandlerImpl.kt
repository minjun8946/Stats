package com.example.data.base

import android.net.sip.SipErrorCode.SERVER_ERROR
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
                400 -> Message.BadRequest
                404 -> Message.NotFound
                406 -> Message.NotAcceptable
                429 -> Message.TooManyRequests
                500 -> Message.InternalServerError
                503 -> Message.ServiceUnavailable
                else -> Message.UnKnownError
            }
            is ConnectException, is SocketTimeoutException, is UnknownHostException -> Message.NetWorkError
            else -> {
                println(throwable.toString())
                Message.UnKnownError
            }
        }
    }

}
