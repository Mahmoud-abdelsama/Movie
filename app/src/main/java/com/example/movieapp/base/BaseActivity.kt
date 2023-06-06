package com.example.chatt_app.base

import android.app.ProgressDialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel

abstract class BaseActivity<VM: BaseViewModel<*>,DB:ViewDataBinding>: AppCompatActivity() {
    lateinit var viewModel:VM
    lateinit var viewBinding:DB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(this, getLayoutId())
        viewModel = initilizeViewModel()


        subscribeToLiveData()

    }

     fun subscribeToLiveData(){

         viewModel.messageLiveData.observe(this) { message ->
             showDialog(message,"Ok",object :DialogInterface.OnClickListener{
                 override fun onClick(dialog: DialogInterface?, which: Int) {
                     dialog?.dismiss()
                     showLoding(false)
                 }

             })


         }
         viewModel.showLoding.observe(this) { show ->
             Log.e("sowLoding","value"+show)
             showLoding(show)

         }


    }
   // val alertDialog:AlertDialog?=null
    fun showDialog(message:String,posActionName:String?=null,
                   postiveAction:DialogInterface.OnClickListener?= null,
                   canceAble:Boolean = true) {
        //val defAction = DialogInterface.OnCancelListener { dialog -> dialog?.dismiss() }
        val builder = AlertDialog.Builder(this).setMessage(message)
        builder.setPositiveButton(posActionName,postiveAction)
        builder.setCancelable(canceAble)
        builder.show()
    }

   lateinit var loding : ProgressDialog
    fun showLoding(show:Boolean){
        loding = ProgressDialog(this)
        if (show)
            loding.show()
        else
            loding.dismiss()


    }





    abstract fun getLayoutId():Int
    abstract fun initilizeViewModel():VM



}