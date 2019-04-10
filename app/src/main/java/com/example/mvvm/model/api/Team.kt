package com.example.mvvm.model.api

import com.example.mvvm.data.local.TeamDetail
import com.google.gson.annotations.SerializedName

data class Team(

	@field:SerializedName("teams")
    val teams: List<TeamDetail>
)