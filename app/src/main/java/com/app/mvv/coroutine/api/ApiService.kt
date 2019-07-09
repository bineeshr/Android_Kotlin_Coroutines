package com.app.mvv.coroutine.api

import com.app.mvv.coroutine.data.AllGitUserResponse
import retrofit2.http.GET

interface ApiService {
    @GET("/users")
     suspend fun getAllGitUserAsync(): MutableList<AllGitUserResponse>
    
}