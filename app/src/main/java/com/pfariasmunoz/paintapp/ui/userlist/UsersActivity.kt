package com.pfariasmunoz.paintapp.ui.userlist

import android.app.Fragment
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.LinearLayout
import com.pfariasmunoz.paintapp.R
import com.pfariasmunoz.paintapp.R.id.users_list
import com.pfariasmunoz.paintapp.data.User
import kotlinx.android.synthetic.main.activity_users.*
import kotlinx.android.synthetic.main.item_user.view.*

class UsersActivity : AppCompatActivity(), UsersContract.View {

    override lateinit var presenter: UsersContract.Presenter

    override var isActive: Boolean = false

    private val listAdapter = UsersAdapter(ArrayList(0))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)
        users_list.adapter = listAdapter
    }

    override fun onResume() {
        super.onResume()
        presenter.start()
    }

    override fun setLoadingIndicator(active: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showUsers(users: List<User>) {
        listAdapter.users = users
        users_list.visibility = View.VISIBLE
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
