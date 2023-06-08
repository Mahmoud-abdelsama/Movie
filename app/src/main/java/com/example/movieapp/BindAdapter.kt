package com.example.movieapp

import android.widget.EditText

import androidx.databinding.BindingAdapter


@BindingAdapter("app:errorText")
fun BindError(view: EditText, error: String?) {
    view.error = error
}