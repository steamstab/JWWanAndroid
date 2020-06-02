package com.jw.jwwanandroid.model.bean

import java.io.Serializable

/**
 * User: Steam
 * Date: 2020/6/1
 * Desc:
 */
data class ArticleList(
    val offset: Int,
    val size: Int,
    val total: Int,
    val pageCount: Int,
    val curPage: Int,
    val over: Boolean,
    val list: List<Article>
) : Serializable