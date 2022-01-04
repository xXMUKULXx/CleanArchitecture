package com.xxmukulxx.notes.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.xxmukulxx.notes.MyApplication
import com.xxmukulxx.notes.R
import com.xxmukulxx.notes.util.toast

abstract class BaseViewModel() : ViewModel() {
    protected val isLoading = MutableLiveData<Boolean>()
    protected val displayError = MutableLiveData<String>()

    fun getIsLoadingLiveData(): LiveData<Boolean> {
        return isLoading
    }

    fun getDisplayErrorLiveData(): LiveData<String> {
        return displayError
    }

    fun showToast(message: String) {
        toast(message)
    }

    protected fun handleNetworkError() {
        isLoading.postValue(false)
        displayError.postValue(MyApplication.context.resources.getString(R.string.network_error))
    }

    protected fun handleUnauthorizedError() {
        isLoading.postValue(false)
        //Pending
    }
}