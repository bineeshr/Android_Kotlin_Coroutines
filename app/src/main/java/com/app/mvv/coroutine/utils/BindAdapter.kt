package com.app.mvv.coroutine.utils

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.app.mvv.coroutine.data.AllGitUserResponse
import com.app.mvv.coroutine.ui.user.UserAdapter

@BindingAdapter("adapter")
fun RecyclerView.addUserData(trendingItems: MutableList<AllGitUserResponse>?) {
    if (this.adapter !=null) {
        val adapter = this.adapter as? UserAdapter
        adapter?.clearData()
        trendingItems?.let {
            adapter?.addAllUser(it)
        }

    }


}
