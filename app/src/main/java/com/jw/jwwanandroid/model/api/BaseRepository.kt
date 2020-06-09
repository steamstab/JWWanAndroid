package com.jw.jwwanandroid.model.api

import com.jw.jwwanandroid.model.bean.BaseResponse
import com.jw.jwwanandroid.model.bean.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import java.io.IOException

/**
 * Author: Steam
 * Date: 2020/6/3
 * Desc:
 */
open class BaseRepository {

    suspend fun <T> apiCall(call: suspend () -> BaseResponse<T>): BaseResponse<T> {
        return call()
    }

    suspend fun <T> safeApiCall(call: suspend () -> Result<T>, errorMessage: String): Result<T> {
        return try {
            call()
        } catch (e: Exception) {
            Result.Error(IOException(errorMessage, e))
        }
    }

    suspend fun <T> executeResponse(
        response: BaseResponse<T>,
        successBlock: (suspend CoroutineScope.() -> Unit)? = null,
        errorBlock: (suspend CoroutineScope.() -> Unit)? = null
    ): Result<T> {

        return coroutineScope {
            if (response.errorCode == -1) {
                errorBlock?.let { it() }
                Result.Error(IOException(response.errorMsg))
            } else {
                successBlock?.let { it() }
                Result.Success(response.data)
            }
        }
    }
}