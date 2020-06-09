package com.jw.jwwanandroid.model.bean

/**
 * Author: Steam
 * Date: 2020/6/4
 * Desc:
 */
sealed class Result<out T> {

    data class Success<out T>(val data: T) : Result<T>()
    data class Error<out T>(val exception: Exception) : Result<T>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success [data=$data]"
            is Error -> "Error [exception=$exception]"
        }
    }
}