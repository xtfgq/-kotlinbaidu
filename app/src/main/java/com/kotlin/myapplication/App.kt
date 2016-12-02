package com.wingsofts.gankclient

import android.app.Application
import com.baidu.mapapi.SDKInitializer

/**
 * Created by wing on 16-11-22.
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        SDKInitializer.initialize(this)
    }


}