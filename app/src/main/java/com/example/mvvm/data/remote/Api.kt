package com.example.mvvm.data.remote

import com.example.mvvm.model.api.Team
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("api/v1/json/1/search_all_teams.php?l=English%20Premier%20League")
    fun getDataTeam(
    ): Call<Team>
}