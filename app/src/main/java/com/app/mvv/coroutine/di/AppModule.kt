package com.app.mvv.coroutine.di

import com.app.mvv.coroutine.ui.user.UserViewModel
import org.koin.dsl.module

val appmodule = module {
    single {
        UserViewModel()
    }
}