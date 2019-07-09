package com.app.mvv.coroutine.ui.user

import com.app.mvv.coroutine.api.ApiService
import com.app.mvv.coroutine.data.AllGitUserResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class UserRepository(private val apiService:ApiService) {

    suspend fun getUserData(): MutableList<AllGitUserResponse>{
        return withContext(Dispatchers.IO) {
            apiService.getAllGitUserAsync()
        }
    }
}