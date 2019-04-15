package com.example.mvvm.model.local

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Entity

@Entity()
data class Team(
    val teams: LiveData<List<TeamDetail>>
)