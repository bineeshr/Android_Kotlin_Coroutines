package com.app.mvv.coroutine.utils

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.app.mvv.coroutine.data.AllGitUserResponse
import com.app.mvv.coroutine.ui.user.UserAdapter

@BindingAdapter("adapter")
fun addUserData(recyclerView: RecyclerView,userList:MutableList<AllGitUserResponse>?){
    recyclerView.adapter?.let {
        val userAdapter = recyclerView.adapter as UserAdapter
        userAdapter.apply {
            this.clearData()
            userList?.let { users -> this.addAllUser(users) }
        }
    }

}