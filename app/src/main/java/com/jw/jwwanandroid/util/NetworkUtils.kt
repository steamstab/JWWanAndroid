package com.jw.jwwanandroid.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build

/**
 * Author: Steam
 * Date: 2020/6/3
 * Desc:
 */
object NetworkUtils {

    fun isNetworkAvailable(context: Context): Boolean {
        val manager = context.applicationContext.getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val networkCapabilities = manager.getNetworkCapabilities(manager.activeNetwork)
            networkCapabilities?.let {
                return networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
            }
        } else {
            val networkInfo = manager.activeNetworkInfo
            networkInfo?.let {
                return networkInfo.isConnected
            }
        }
        return false
    }
}