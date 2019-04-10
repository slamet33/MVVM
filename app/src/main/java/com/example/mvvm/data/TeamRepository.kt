package com.example.mvvm.data

import com.example.mvvm.data.local.TeamLocalDataSource
import com.example.mvvm.data.remote.TeamRemoteDataSource
import com.example.mvvm.model.api.Team

class TeamRepository(val teamsRemoteDataSource: TeamRemoteDataSource, val teamLocalDataSource: TeamLocalDataSource) :
    TeamDataSource {
    override fun getListTeams(callback: TeamDataSource.GetTeamsCallback) {
        teamLocalDataSource.getListTeams(object : TeamDataSource.GetTeamsCallback {
            override fun onTeamLoad(data: Team) {
                callback.onTeamLoad(data)
            }

            override fun onDataNotAvailable(errorMsg: String) {
                getTeamsFromRemote(callback)
            }
        })
    }

    fun getTeamsFromRemote(callback: TeamDataSource.GetTeamsCallback) {
        teamsRemoteDataSource.getListTeams(object : TeamDataSource.GetTeamsCallback {
            override fun onTeamLoad(data: Team) {
                teamLocalDataSource.saveDataTeam(data.teams)
                callback.onTeamLoad(data)
            }

            override fun onDataNotAvailable(errorMsg: String) {
                callback.onDataNotAvailable(errorMsg)
            }
        })
    }

}