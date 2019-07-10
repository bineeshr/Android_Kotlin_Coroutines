package com.app.mvv.coroutine.ui.user

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.mvv.coroutine.base.BaseViewHolder
import com.app.mvv.coroutine.data.AllGitUserResponse
import com.app.mvv.coroutine.databinding.AdapterUserBinding

class UserAdapter(private var userList: MutableList<AllGitUserResponse> = ArrayList()) :
    RecyclerView.Adapter<BaseViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val adapterUserBinding = AdapterUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(adapterUserBinding)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.onBind(position)
    }

    fun clearData() {
        userList.clear()
    }

    inner class UserViewHolder(private val binding: AdapterUserBinding) : BaseViewHolder(binding.root) {

        override
        fun onBind(position: Int) {
            val user = userList[position]
            binding.userItem=user
            binding.executePendingBindings()
        }

    }

    fun addAllUser(users: MutableList<AllGitUserResponse>) {
        userList = users
        notifyDataSetChanged()
    }
}