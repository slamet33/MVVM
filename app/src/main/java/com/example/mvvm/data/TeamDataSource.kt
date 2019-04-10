package com.example.mvvm.data

import com.example.mvvm.model.api.Team

interface TeamDataSource {
    fun getListTeams(callback: GetTeamsCallback)

    interface GetTeamsCallback {
        fun onTeamLoad(data: Team)
        fun onDataNotAvailable(errorMsg: String)
    }
}