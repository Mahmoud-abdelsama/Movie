package com.example.movieapp.ui.signup

import android.app.Application
import android.provider.Settings.Global.getString
import android.util.Log
import androidx.constraintlayout.motion.widget.TransitionBuilder.validate
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.movieapp.R
import com.example.movieapp.ui.signin.SiginInActivity
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

public class SiginUpViewModel(private val app: Application, private val listener: OnSignInStartedListener):AndroidViewModel(app) {

    private var auth: FirebaseAuth = Firebase.auth

    private val _currentUser = MutableLiveData<FirebaseUser>()

    val currentUser: LiveData<FirebaseUser> = _currentUser

   // var siginUpActivity = SiginInActivity()

    val email = ObservableField<String>()
    var errorEmail = ObservableField<String>()
    var password = ObservableField<String>()
    var errorPassword = ObservableField<String>()
    var confirmpassword = ObservableField<String>()
    var errorConfirmPassword = ObservableField<String>()

    val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestIdToken(app.getString(R.string.default_web_client_id))
        .requestEmail()
        .build()

    private val googleSignInClient = GoogleSignIn.getClient(app, gso)

    fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential).addOnCompleteListener {
            if (it.isSuccessful) {
                _currentUser.value = auth.currentUser
            } else {
                //_currentUser.value = null
            }
        }
    }


    interface OnSignInStartedListener {
        fun onSignInStarted(client: GoogleSignInClient?)
    }







    fun signIn() {
        listener.onSignInStarted(googleSignInClient)
    }








    fun validate():Boolean {
        var isValidate = true
        if (email.get() == null) {
            isValidate = false
            errorEmail.set("invalid email")
        } else{
            isValidate = true
            errorEmail.set(null)
        }
         if(password.get() == null) {
            isValidate = false
            errorPassword.set("invalid password")
        } else {
            isValidate = true
            errorPassword.set(null)
        }
         if (confirmpassword.get() == null || confirmpassword.get()!= password.get()) {
            isValidate = false
            errorConfirmPassword.set("password not confirmed")
        } else {
            isValidate = true
            errorConfirmPassword.set(null)
        }
        return isValidate

    }
}