package com.pfariasmunoz.paintapp.ui.userlist

import com.pfariasmunoz.paintapp.base.BasePresenter
import com.pfariasmunoz.paintapp.base.BaseView
import com.pfariasmunoz.paintapp.data.User

interface UsersContract {
    interface View : BaseView<Presenter>{
        fun setLoadingIndicator(active: Boolean)
        fun showUsers(users: List<User>)
        fun showLoadingUserError()
        fun showNoUsers()
        fun showSuccessfullySavedMessage()
    }

    interface Presenter : BasePresenter {
        fun loadUsers(forceUpdate: Boolean)
        fun addNewUser()
    }
}