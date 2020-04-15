package com.augus.roomdeepresearch.base

import android.app.Application
import android.content.res.Configuration
import com.augus.roomdeepresearch.database.TFDatabase

class BaseApplication : Application() {

    init {
        context = this
    }

    companion object {
        private var context: BaseApplication? = null

        fun context(): BaseApplication {
            return context as BaseApplication
        }
    }

    override fun onCreate() {
        super.onCreate()
        //init
        TFDatabase.instance
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }

}