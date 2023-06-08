package com.example.movieapp.ui.signin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.movieapp.R
import com.example.movieapp.base.BaseActivity
import com.example.movieapp.databinding.ActivitySignInBinding


class SiginInActivity : BaseActivity<SiginViewModel, ActivitySignInBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




    }
    override fun getLayoutId(): Int {

      return R.layout.activity_sign_in
    }

    override fun initilizeViewModel(): SiginViewModel {
        return ViewModelProvider(this).get(SiginViewModel::class.java)
    }
}