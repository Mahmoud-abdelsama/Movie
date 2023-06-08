package com.example.movieapp.ui.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider

import com.example.movieapp.R
import com.example.movieapp.base.BaseActivity
import com.example.movieapp.databinding.ActivitySignInBinding
import com.example.movieapp.databinding.ActivitySignUpBinding
import com.example.movieapp.ui.signin.SiginInActivity
import com.example.movieapp.ui.signin.SiginViewModel

class SiginUpActivity : BaseActivity<SiginUpViewModel,ActivitySignUpBinding>(),Navigator{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding.vm = viewModel
        viewModel.Navigator = this


    }


    override fun getLayoutId(): Int {
        return R.layout.activity_sign_up
    }

    override fun initilizeViewModel(): SiginUpViewModel {
        return ViewModelProvider(this).get(SiginUpViewModel::class.java)
    }

    override fun openSinInActivity() {
        val intent = Intent(this,SiginInActivity::class.java)
        startActivity(intent)

}

}
