package com.example.mvvm

import android.content.Context
import com.example.mvvm.data.TeamRepository
import com.example.mvvm.data.local.TeamLocalDataSource
import com.example.mvvm.data.remote.TeamRemoteDataSource

class Injection {
    companion object {
        fun provideTeamRepository(context: Context) : TeamRepository {
            return TeamRepository(TeamRemoteDataSource(), TeamLocalDataSource(context))
        }
    }
}