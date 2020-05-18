package com.sunnyweather.android

import android.app.Application
import android.content.Context

class MyApplication :Application(){
    companion object{
        lateinit var context:Context
        const val TOKEN = "NFwl2E4NosfGncZX"
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}