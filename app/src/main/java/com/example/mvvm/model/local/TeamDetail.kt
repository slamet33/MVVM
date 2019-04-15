package com.example.mvvm.model.local

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "team")
data class TeamDetail(

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo(name = "team_name")
    @SerializedName("strTeam")
    var teamName: String?,

    @ColumnInfo(name = "team_logo")
    @SerializedName("strTeamBadge")
    var teamLogo: String?)