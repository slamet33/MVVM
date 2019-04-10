package com.example.mvvm.model

import com.example.mvvm.data.TeamDataSource
import com.example.mvvm.data.TeamRepository
import com.example.mvvm.data.local.TeamDetail
import com.example.mvvm.model.api.Team

class TeamViewModel (val teamRepository: TeamRepository, var teamNavigator: TeamNavigator){
    fun getListTeam() {
//        teamRepository.getListTeams(callback = object : TeamDataSource.GetTeamsCallback{
//            override fun onTeamLoad(data: Team) {
//                if (data != null) {
//                    teamNavigator.loadListTeam(data.teams)
//                }
//            }
//
//            override fun onDataNotAvailable(errorMsg: String) {
//                teamNavigator.errorListTeam(errorMsg)
//            }
//        })

        teamRepository.getTeamsFromRemote(callback = object : TeamDataSource.GetTeamsCallback{
            override fun onTeamLoad(data: Team) {
                    teamNavigator.loadListTeam(data.teams)
            }

            override fun onDataNotAvailable(errorMsg: String) {
                teamNavigator.errorListTeam(errorMsg)
            }
        })
    }

    fun setNavigator(navigator: TeamNavigator) {
        teamNavigator = navigator
    }

    interface TeamNavigator{
        fun loadListTeam(listTeam: List<TeamDetail>)
        fun errorListTeam(msg: String)
    }
}