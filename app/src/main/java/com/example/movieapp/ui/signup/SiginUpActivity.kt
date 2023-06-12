package com.example.movieapp.ui.signup

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider

import com.example.movieapp.R
import com.example.movieapp.base.MainActivityViewModelFactory
import com.example.movieapp.databinding.ActivitySignUpBinding
import com.example.movieapp.ui.home.HomeActivity

import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.common.api.ApiException


public class SiginUpActivity :AppCompatActivity() {

    companion object {
        private const val RC_SIGN_IN = 9001
    }


    private lateinit var binding: ActivitySignUpBinding
    private lateinit var viewModel: SiginUpViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
        viewModel = ViewModelProvider(this).get(SiginUpViewModel::class.java)


//        val application = requireNotNull(this).application
//        val factory = SignInViewModelFactory(application, object :  val factory = MainActivityViewModelFactory(application, object : OnSignInStartedListener {
//            override fun onSignInStarted(client: GoogleSignInClient?) {
//                startActivityForResult(client?.signInIntent, RC_SIGN_IN)
//            }
//        })
//        val  viewModel = ViewModelProvider(this, factory).get(SignInViewModel::class.java)


        val application = requireNotNull(this).application

        val factory = MainActivityViewModelFactory(application, object :
            SiginUpViewModel.OnSignInStartedListener {
            override fun onSignInStarted(client: GoogleSignInClient?) {
                startActivityForResult(client?.signInIntent!!, RC_SIGN_IN)
            }
        })

        val viewModel = ViewModelProvider(this, factory).get(SiginUpViewModel::class.java)



        binding.siginupWithGogleButton.setOnClickListener {
            viewModel.signIn()
            val intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)
        }

        viewModel.currentUser.observe(this) {
            it?.let {
                val userName = it.displayName
            }
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN && resultCode == Activity.RESULT_OK && data != null) {

            // this task is responsible for getting ACCOUNT SELECTED
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = task.getResult(ApiException::class.java)!!

                viewModel.firebaseAuthWithGoogle(account.idToken!!)

                Toast.makeText(this, "Signed In Successfully", Toast.LENGTH_SHORT)
                    .show()

            } catch (e: ApiException) {
                Toast.makeText(this, e.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }

}
