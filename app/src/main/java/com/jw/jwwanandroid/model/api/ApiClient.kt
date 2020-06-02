package com.jw.jwwanandroid.model.api

import com.jw.jwwanandroid.App
import okhttp3.Cache
import okhttp3.OkHttpClient
import java.io.File

/**
 * Author: Steam
 * Date: 2020/6/1
 * Desc:
 */
class ApiClient: BaseClient(){

    val service by lazy { getService(ApiService::class.java, ApiService.BASE_URL) }

    override fun handleBuilder(builder: OkHttpClient.Builder) {

        val httpCacheDirectory = File(App.CONTENT.cacheDir, "responses")
        val cacheSize = 10 * 1024 * 1024L
        val cache = Cache(httpCacheDirectory, cacheSize)
    }
}