package com.pfariasmunoz.paintapp.ui.userlist

import com.pfariasmunoz.paintapp.data.User
import com.pfariasmunoz.paintapp.data.source.Result
import com.pfariasmunoz.paintapp.data.source.UsersRepository
import com.pfariasmunoz.paintapp.util.EspressoIdlingResource
import com.pfariasmunoz.paintapp.util.launchSilent
import kotlinx.coroutines.experimental.android.UI
import kotlin.coroutines.experimental.CoroutineContext

/**
 * Retrieves the data and updates the
 * UI as required.
 */
class UsersPresenter(private val usersRepository: UsersRepository,
                     private val usersView: UsersContract.View,
                     private val uiContext: CoroutineContext = UI) : UsersContract.Presenter {

    private var firstLoad = true

    init {
        usersView.presenter = this
    }

    override fun start() {
        loadUsers(false)
    }

    override fun loadUsers(forceUpdate: Boolean) {
        loadUsers(forceUpdate || firstLoad, true)
        firstLoad = false
    }

    /**
     * @param forceUpdate   Pass in true to refresh the data in the [UsersDataSource]
     * *
     * @param showLoadingUI Pass in true to display a loading icon in the UI
     */
    private fun loadUsers(forceUpdate: Boolean, showLoadingUI: Boolean) = launchSilent(uiContext) {
        if (showLoadingUI) {
            usersView.setLoadingIndicator(true)
        }
        if (forceUpdate) {
            usersRepository.refreshUsers()
        }

        // The network request might be handled in a different thread so make sure Espresso knows
        // that the app is busy until the response is handled.
        EspressoIdlingResource.increment() // App is busy until further notice

        val result = usersRepository.getUsers()
        if (result is Result.Success) {
            val usersToShow = ArrayList<User>()

            // This callback may be called twice, once for the cache and once for loading
            // the data from the server API, so we check before decrementing, otherwise
            // it throws "Counter has been corrupted!" exception.
            if (!EspressoIdlingResource.countingIdlingResource.isIdleNow) {
                EspressoIdlingResource.decrement() // Set app as idle.
            }

            for (user in result.data) {
                usersToShow.add(user)
            }

            // The view may not be able to handle UI updates anymore
            if (usersView.isActive) {
                if (showLoadingUI) {
                    usersView.setLoadingIndicator(false)
                }
                processUsers(usersToShow)
            }

        } else {
            if (usersView.isActive) {
                usersView.showLoadingUserError()
            }
        }
    }

    private fun processUsers(users: List<User>) {
        if (users.isEmpty()) {
            // show that there are no users
            usersView.showNoUsers()
        } else {
            // show the list of the users
            usersView.showUsers(users)
        }
    }

}