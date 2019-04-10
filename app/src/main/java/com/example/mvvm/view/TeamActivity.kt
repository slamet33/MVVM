package com.example.mvvm.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.example.mvvm.Injection
import com.example.mvvm.R
import com.example.mvvm.data.local.TeamDetail
import com.example.mvvm.model.TeamViewModel

class TeamActivity : AppCompatActivity(), TeamViewModel.TeamNavigator {

    lateinit var mTeamViewModel: TeamViewModel
    lateinit var rvTeam: RecyclerView

    var adapter: TeamBolaAdapter? = null
    lateinit var dataListTeam: MutableList<TeamDetail>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team)

        rvTeam = findViewById(R.id.rv_team)
        rvTeam.layoutManager = LinearLayoutManager(this)
        mTeamViewModel = TeamViewModel(Injection.provideTeamRepository(this), this)
        dataListTeam = ArrayList()
        mTeamViewModel.setNavigator(this)
        mTeamViewModel.getListTeam()
    }

    override fun loadListTeam(listTeam: List<TeamDetail>) {
        if (listTeam != null) {
            dataListTeam.addAll(listTeam)
        }
        adapter = TeamBolaAdapter(listTeam, this)
        rvTeam.adapter = adapter
        adapter?.notifyDataSetChanged()
    }

    override fun errorListTeam(msg: String) {
        Log.e("TAG#1", msg)
    }
}
