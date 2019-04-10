//package com.example.mvvm.model.api
//
//import android.arch.persistence.room.ColumnInfo
//import android.arch.persistence.room.Entity
//import android.arch.persistence.room.PrimaryKey
//import com.google.gson.annotations.SerializedName
//
//@Entity(tableName = "team")
//data class TeamsItem(
//
//	@PrimaryKey(autoGenerate = true) var id: Int?,
//
//	@ColumnInfo(name = "team_name")
//	@field:SerializedName("strTeam")
//	val strTeam: String? = null,
//
//	@ColumnInfo(name = "team_logo")
//	@field:SerializedName("strTeamBadge")
//	val strTeamBadge: String? = null
//)