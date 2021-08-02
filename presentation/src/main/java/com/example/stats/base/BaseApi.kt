package com.example.stats.base

import android.util.Log
import com.example.data.remote.ApiService
import io.reactivex.plugins.RxJavaPlugins
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import rxdogtag2.RxDogTag
import java.util.concurrent.TimeUnit

class BaseApi {
    val CONNECT_TIMEOUT: Long = 15
    val WRITE_TIMEOUT: Long = 15
    val READ_TIMEOUT: Long = 15
    val API_URL: String = "https://www.balldontlie.io/api/v1/"
    var OKHttpClient: OkHttpClient
    var mRetrofit: Retrofit
    var KotlinRetrofitInterface: ApiService

    init {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        OKHttpClient = OkHttpClient().newBuilder().apply {
            addInterceptor(httpLoggingInterceptor)
            connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
        }.build()
        mRetrofit = Retrofit.Builder().apply {
            baseUrl(API_URL)
            client(OKHttpClient)
            addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            addConverterFactory(GsonConverterFactory.create())
        }.build()
        KotlinRetrofitInterface = mRetrofit.create()
        RxDogTag.install()
        RxJavaPlugins.setErrorHandler { Log.d("RxError", it.toString()) }
    }

    fun getInstance(): ApiService {
        return KotlinRetrofitInterface
    }

}