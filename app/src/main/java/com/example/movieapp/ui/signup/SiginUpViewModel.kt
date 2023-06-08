package com.example.movieapp.ui.signup

import android.util.Log
import androidx.databinding.ObservableField
import com.example.movieapp.base.BaseViewModel

class SiginUpViewModel:BaseViewModel<Navigator>() {

    val email = ObservableField<String>()
    var errorEmail = ObservableField<String>()
    var password = ObservableField<String>()
    var errorPassword = ObservableField<String>()
    var confirmpassword = ObservableField<String>()
    var errorConfirmPassword = ObservableField<String>()

fun siginUp(){
    Log.e("siginUp","siginup begin")
    if(validate()){
     Navigator?.openSinInActivity()}
    Log.e("validate","siginup false")


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