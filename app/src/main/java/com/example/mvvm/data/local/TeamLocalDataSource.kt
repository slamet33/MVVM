package com.example.mvvm.data.local

import android.content.Context
import com.example.mvvm.data.TeamDataSource
import com.example.mvvm.model.api.Team

class TeamLocalDataSource (val context: Context, val teamDao: TeamDao? = TeamDataBase.getInstance(context)?.teamDao()) : TeamDataSource {

    override fun getListTeams(callback: TeamDataSource.GetTeamsCallback) {
        val runnable: Runnable = Runnable {
            val team: List<TeamDetail>? = teamDao?.getAll()

            if (team != null) {
                if (team.isEmpty()) {
                    callback.onDataNotAvailable("Data Local Kosong")
                } else {
                    val teams = Team(team)
                    callback.onTeamLoad(teams)
                }
            }

        }
        Thread(runnable).start()
    }

    fun saveDataTeam(teamDetail: List<TeamDetail>?) {
        val runnable: Runnable = Runnable {
            if (teamDetail != null) {
                teamDao?.insert(teamDetail)
            }
        }
        Thread(runnable).start()
    }

}
