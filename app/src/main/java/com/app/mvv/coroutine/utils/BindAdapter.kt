package com.app.mvv.coroutine.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.app.mvv.coroutine.R
import com.app.mvv.coroutine.data.AllGitUserResponse
import com.app.mvv.coroutine.ui.user.UserAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("adapter")
fun RecyclerView.addUserData(trendingItems: MutableList<AllGitUserResponse>?) {
    if (this.adapter !=null) {
        val adapter = this.adapter as? UserAdapter
        adapter?.clearData()
        trendingItems?.let {
            adapter?.addAllUser(it)
        }

    } }

@BindingAdapter("imageUrl")
fun ImageView.setImage(url:String?){
    url?.let {
        Picasso.get()
            .load(it)
            .resize(100, 100)
            .centerCrop()
            .placeholder(R.drawable.ic_boy)
            .into(this)
    }
}
