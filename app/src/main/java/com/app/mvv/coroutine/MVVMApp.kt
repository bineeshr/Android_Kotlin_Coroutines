package com.app.mvv.coroutine

import android.app.Application
import com.app.mvv.coroutine.di.appmodule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MVVMApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MVVMApp)
            modules (appmodule)
        }
    }
}