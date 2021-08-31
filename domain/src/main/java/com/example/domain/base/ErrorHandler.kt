package com.example.domain.base

interface ErrorHandler {
    fun errorHandle(throwable: Throwable?): Message
}