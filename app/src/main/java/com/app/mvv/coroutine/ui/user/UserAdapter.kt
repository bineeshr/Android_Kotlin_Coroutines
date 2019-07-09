package com.app.mvv.coroutine.ui.user

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.mvv.coroutine.data.AllGitUserResponse
import com.app.mvv.coroutine.databinding.AdapterUserBinding

class UserAdapter(var userList: MutableList<AllGitUserResponse> = mutableListOf()) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val adapterUserBinding = AdapterUserBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return UserViewHolder(adapterUserBinding)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user=userList[position]
        holder.onBind(user)
    }

    fun clearData() {
        userList.clear()
    }
    class UserViewHolder(private val binding: AdapterUserBinding) :RecyclerView.ViewHolder(binding.root) {


         fun onBind(user: AllGitUserResponse) {
             binding.txtUserName.text=user.login
             binding.txtUserDetails.text=user.type
             binding.executePendingBindings()
        }

    }

    fun addAllUser(users: MutableList<AllGitUserResponse>){
        userList=users
        notifyDataSetChanged()
    }
}