package com.jw.jwwanandroid.model.api

import com.jw.jwwanandroid.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Author: Steam
 * Date: 2020/6/1
 * Desc:
 */
abstract class BaseClient {

    companion object {
        private const val TIME_OUT = 5
    }

    private val client: OkHttpClient
        get() {
            val builder = OkHttpClient.Builder()
            val logging = HttpLoggingInterceptor()
            logging.level =
                if (BuildConfig.DEBUG) {
                    HttpLoggingInterceptor.Level.BODY
                } else {
                    HttpLoggingInterceptor.Level.BASIC
                }

            builder.addInterceptor(logging).connectTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
            handleBuilder(builder)
            return builder.build()
        }

    protected abstract fun handleBuilder(builder: OkHttpClient.Builder)

    fun <T> getService(serviceClass: Class<T>, baseUrl: String): T {
        return Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build().create(serviceClass)
    }
}