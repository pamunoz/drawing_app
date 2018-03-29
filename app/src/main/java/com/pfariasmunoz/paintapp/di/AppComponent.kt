package com.pfariasmunoz.paintapp.di

import android.content.Context
import com.pfariasmunoz.paintapp.di.modules.ContextModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ContextModule::class])
interface AppComponent {
    fun appContext(): Context
}