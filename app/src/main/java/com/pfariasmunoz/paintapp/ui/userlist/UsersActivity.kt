package com.pfariasmunoz.paintapp.ui.userlist

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.pfariasmunoz.paintapp.R
import com.pfariasmunoz.paintapp.data.User
import kotlinx.android.synthetic.main.item_user.view.*

class UsersActivity : AppCompatActivity(), UsersContract.View {

    override lateinit var presenter: UsersContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)
    }

    override fun onResume() {
        super.onResume()
        presenter.start()
    }

    override fun setLoadingIndicator(active: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showUsers(users: List<User>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoadingUserError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showNoUsers() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showSuccessfullySavedMessage() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private class UsersAdapter(users: List<User>) : BaseAdapter() {

        var users: List<User> = users
            set(users) {
                field = users
                notifyDataSetChanged()
            }

        override fun getView(index: Int, view: View?, viewGroup: ViewGroup?): View {
            val user = getItem(index)
            val rowView = view ?: LayoutInflater.from(viewGroup?.context)
                    .inflate(R.layout.item_user, viewGroup, false)
            with(rowView.user_login) {
                text = user.login
            }
            return rowView
        }

        override fun getItem(index: Int) = users[index]

        override fun getItemId(index: Int) = index.toLong()

        override fun getCount() = users.size

    }
}
