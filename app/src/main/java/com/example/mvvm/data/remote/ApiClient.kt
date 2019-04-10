package com.example.mvvm.data.remote

import com.example.mvvm.BuildConfig
import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    var retrofit = Retrofit.Builder().baseUrl("https://www.thesportsdb.com/").addConverterFactory(GsonConverterFactory.create()).build()
    var service = retrofit.create(Api::class.java)
}