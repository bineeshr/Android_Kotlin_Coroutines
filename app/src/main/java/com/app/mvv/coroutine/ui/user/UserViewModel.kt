package com.app.mvv.coroutine.ui.user

import androidx.lifecycle.MutableLiveData
import com.app.mvv.coroutine.base.BaseViewModel
import com.app.mvv.coroutine.data.AllGitUserResponse
import kotlinx.coroutines.*
import java.lang.Exception

class UserViewModel(private val userRepository:UserRepository) :BaseViewModel() {
    val allGitUserResponse=MutableLiveData<MutableList<AllGitUserResponse>>()
    fun getUserData(){
    scope.launch {
        val response=userRepository.getUserData()
        try{
            if(response.isSuccessful){
                allGitUserResponse.value=response.body()
            }
        }catch (e:Exception){
            print(e.message)

        }
        }
    }


}