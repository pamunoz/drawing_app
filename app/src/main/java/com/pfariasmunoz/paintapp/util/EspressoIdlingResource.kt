package com.pfariasmunoz.paintapp.util

import android.support.test.espresso.IdlingResource

/**
 * Contains a static reference to [IdlingResource], only available in the 'mock' build type.
 */
object EspressoIdlingResource {
    private val RESOURCE = "GLOBAL"

    val countingIdlingResource = SimpleCountingIdlingResource(RESOURCE)

    fun increment() = countingIdlingResource.increment()

    fun decrement() = countingIdlingResource.decrement()
}