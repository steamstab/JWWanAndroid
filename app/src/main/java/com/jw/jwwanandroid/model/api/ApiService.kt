package com.jw.jwwanandroid.model.api

import com.jw.jwwanandroid.model.bean.ArticleList
import com.jw.jwwanandroid.model.bean.BaseResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * User: Steam
 * Date: 2020/6/1
 * Desc:
 */
interface ApiService {

    companion object {
        const val BASE_URL = "https://www.wanandroid.com"
    }

    @GET("/article/list/{page}/json")
    fun getHomeArticleList(@Path("page") page: Int): BaseResponse<ArticleList>

}