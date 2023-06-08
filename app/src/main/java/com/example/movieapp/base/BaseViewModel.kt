package com.example.movieapp.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel<N>: ViewModel() {

    var messageLiveData = MutableLiveData<String>()
    var showLoding = MutableLiveData<Boolean>()
    var Navigator:N? =null



}