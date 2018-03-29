package com.pfariasmunoz.paintapp.di

import com.pfariasmunoz.paintapp.App

object Injector {
    fun get(): AppComponent = App.INSTANCE.component
}