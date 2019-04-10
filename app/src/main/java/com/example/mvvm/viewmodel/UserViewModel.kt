package com.example.mvvm.viewmodel

import android.content.Context
import android.text.TextUtils
import android.widget.Toast
import com.example.mvvm.model.api.User

class UserViewModel(val context: Context, val user: User) {

    var isValid: Boolean = true

    fun updateModel(email: String, password: String) {
        user.email = email
        user.password = password
    }

    fun validLogin() {
        if (TextUtils.isEmpty(user.email))
            isValid = false

        if (TextUtils.isEmpty(user.password))
            isValid = false

        val TOAST_MESSAGE_SUCCESS = "Sukses"
        val TOAST_MESSAGE_FAILED = "Gagal"

        if (isValid)
            showToast(TOAST_MESSAGE_SUCCESS)
        else
            showToast(TOAST_MESSAGE_FAILED)
    }

    fun showToast(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
    }
}