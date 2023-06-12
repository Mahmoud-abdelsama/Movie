package com.example.movieapp.ui.signin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.movieapp.R
import com.example.movieapp.databinding.ActivitySignInBinding
import com.example.movieapp.databinding.ActivitySignUpBinding
import com.example.movieapp.ui.signup.SiginUpViewModel

//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import androidx.lifecycle.ViewModelProvider
//import com.example.movieapp.R
//import com.example.movieapp.base.BaseActivity
//import com.example.movieapp.databinding.ActivitySignInBinding
//
//
class SiginInActivity :AppCompatActivity(){

    private lateinit var binding: ActivitySignInBinding
    private lateinit var viewModel: SiginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_in)
        viewModel = ViewModelProvider(this).get(SiginViewModel::class.java)


    }
}