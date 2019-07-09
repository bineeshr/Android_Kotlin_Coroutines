package com.app.mvv.coroutine.api

import com.app.mvv.coroutine.data.AllGitUserResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/users")
     suspend fun getAllGitUserAsync(): Response<MutableList<AllGitUserResponse>>
    
}