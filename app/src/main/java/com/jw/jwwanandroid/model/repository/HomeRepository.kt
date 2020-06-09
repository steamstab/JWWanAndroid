package com.jw.jwwanandroid.model.repository

import com.jw.jwwanandroid.model.api.ApiClient
import com.jw.jwwanandroid.model.api.BaseRepository
import com.jw.jwwanandroid.model.bean.ArticleList
import com.jw.jwwanandroid.model.bean.Result

/**
 * Author: Steam
 * Date: 2020/6/8
 * Desc:
 */
class HomeRepository : BaseRepository() {

    suspend fun getArticleList(page: Int): Result<ArticleList> {
        return safeApiCall(
            call = { executeResponse(ApiClient.service.getHomeArticleList(page)) },
            errorMessage = ""
        )
    }
}