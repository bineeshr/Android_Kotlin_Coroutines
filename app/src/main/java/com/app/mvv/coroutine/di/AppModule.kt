package com.app.mvv.coroutine.di

import com.app.mvv.coroutine.BuildConfig.API_BASE_URL
import com.app.mvv.coroutine.api.ApiService
import com.app.mvv.coroutine.ui.user.UserRepository
import com.app.mvv.coroutine.ui.user.UserViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val appmodule = module {
    single {
        UserViewModel(get())
    }

    single {
        UserRepository(get())    }

    factory { get<Retrofit>().create(ApiService::class.java) }


    factory {

        val logging = HttpLoggingInterceptor()

        logging.level = HttpLoggingInterceptor.Level.BODY
        OkHttpClient.Builder()
            .connectTimeout(20, TimeUnit.SECONDS)
            .addInterceptor(logging)
            .readTimeout(20, TimeUnit.SECONDS)
            .build()
    }


    factory {
        Retrofit.Builder()
            .client(get())
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}