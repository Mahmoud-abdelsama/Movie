package com.example.movieapp.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
//
//abstract class BaseActivity<VM: BaseViewModel<*>,DB:ViewDataBinding>: AppCompatActivity() {
//    lateinit var viewModel: VM
//    lateinit var viewBinding: DB
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        viewBinding = DataBindingUtil.setContentView(this, getLayoutId())
//        viewModel = initilizeViewModel()
//
//
//    }
//
//    abstract fun getLayoutId(): Int
//    abstract fun initilizeViewModel(): VM
//}