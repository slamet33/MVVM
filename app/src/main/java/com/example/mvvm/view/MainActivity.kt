package com.example.mvvm.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.mvvm.R
import com.example.mvvm.model.api.User
import com.example.mvvm.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var userViewModel: UserViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_login.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_login -> {
                userViewModel = UserViewModel(this,
                    User(edt_username.text.toString(), edt_password.text.toString())
                )
                userViewModel.updateModel(edt_username.text.toString() ,edt_password.text.toString())
                userViewModel.validLogin()
            }
        }
    }
}