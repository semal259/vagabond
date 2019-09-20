package com.sierra.vagabond

import android.app.Application
import com.sierra.vagabond.di.AppComponent
import com.sierra.vagabond.di.AppInjector
import com.sierra.vagabond.di.DaggerAppComponent
import com.sierra.vagabond.utils.Prefs
import com.sierra.vagabond.utils.PushInteractor

class VagabondApplication : Application() {

    private val pushInteractor = PushInteractor()

    override fun onCreate() {
        super.onCreate()
        pushInteractor.registerDeviceToken()
        Prefs.init(this)
    }
}