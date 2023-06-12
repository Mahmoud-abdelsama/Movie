package com.example.movieapp.base

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movieapp.ui.signup.SiginUpViewModel

open class  MainActivityViewModelFactory(
    private val application: Application,
    private val listener: SiginUpViewModel.OnSignInStartedListener
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SiginUpViewModel::class.java)) {

            return SiginUpViewModel(application, listener) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
