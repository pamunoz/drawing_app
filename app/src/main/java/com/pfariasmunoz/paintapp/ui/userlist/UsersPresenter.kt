package com.pfariasmunoz.paintapp.ui.userlist

import com.pfariasmunoz.paintapp.data.source.UsersRepository
import kotlinx.coroutines.experimental.android.UI
import kotlin.coroutines.experimental.CoroutineContext

class UsersPresenter(private val usersRepository: UsersRepository,
                     private val usersView: UsersContract.View,
                     private val uiContext: CoroutineContext = UI) : UsersContract.Presenter {

    private var firstLoad = true

    init {
        usersView.presenter = this
    }
    override fun addNewUser() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun start() {
        loadUsers(false)
    }

    override fun loadUsers(forceUpdate: Boolean) {

    }

    private fun loadUsers(forceUpdate: Boolean, showLoading: Boolean) = lau


}