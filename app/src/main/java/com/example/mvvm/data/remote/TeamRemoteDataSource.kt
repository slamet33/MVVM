package com.example.mvvm.data.remote

import com.example.mvvm.data.TeamDataSource
import com.example.mvvm.model.api.Team
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TeamRemoteDataSource : TeamDataSource {

    override fun getListTeams(callback: TeamDataSource.GetTeamsCallback) {
        val call : Call<Team> = ApiClient.service.getDataTeam()
        call.enqueue(object : Callback<Team>{
            override fun onFailure(call: Call<Team>, t: Throwable) {
                callback.onDataNotAvailable(t.message.toString())
            }

            override fun onResponse(call: Call<Team>, response: Response<Team>) {
                callback.onTeamLoad(response.body()!!)
            }
        })
    }
}