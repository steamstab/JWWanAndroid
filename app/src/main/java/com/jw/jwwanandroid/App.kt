package com.jw.jwwanandroid

import android.app.Application
import android.content.Context
import kotlin.properties.Delegates

/**
 * Author: Steam
 * Date: 2020/6/2
 * Desc:
 */
class App : Application() {

    companion object {
        var CONTENT by Delegates.notNull<Context>()
    }

    override fun onCreate() {
        super.onCreate()
        CONTENT = applicationContext
    }
}