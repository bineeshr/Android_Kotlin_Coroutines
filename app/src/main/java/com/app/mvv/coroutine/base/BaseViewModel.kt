package com.app.mvv.coroutine.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob


abstract class BaseViewModel :ViewModel(){
    private val viewModelJob= SupervisorJob()
   var scope= CoroutineScope(Dispatchers.Main+viewModelJob)


    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }


}