package com.jw.jwwanandroid.model.bean

/**
 * Author: Steam
 * Date: 2020/6/4
 * Desc:
 */
data class BaseResponse<out T>(val errorCode: Int, val errorMsg: String, val data: T)