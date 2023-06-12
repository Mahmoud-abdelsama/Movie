package com.example.movieapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.movieapp.ui.signin.SiginInActivity
import com.example.movieapp.ui.signup.SiginUpActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {


    lateinit var auth:FirebaseAuth
    var siginInActivity: SiginInActivity = SiginInActivity()
     var siginUpActivity: SiginUpActivity = SiginUpActivity()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()
        val user = auth.currentUser

        Handler(Looper.getMainLooper()).postDelayed({
          if(user != null){
              StartActivity(siginInActivity)
          }else{
              StartActivity(siginUpActivity)
          }

        }, 2000)
    }

    fun StartActivity(activity:Activity){
        val intent = Intent(this,activity::class.java)
        startActivity(intent)
    }


}