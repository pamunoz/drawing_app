package com.pfariasmunoz.paintapp

import android.app.Application
import com.pfariasmunoz.paintapp.di.AppComponent
import com.pfariasmunoz.paintapp.di.DaggerAppComponent
import com.pfariasmunoz.paintapp.di.modules.ContextModule
import dagger.Component

class App: Application() {

    companion object {
        @JvmStatic lateinit var INSTANCE: App
            private set
    }

    lateinit var component: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        component = DaggerAppComponent.builder()
                .contextModule(ContextModule(this))
                .build()
    }
}