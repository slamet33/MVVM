package com.example.mvvm.view

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.mvvm.R
import com.example.mvvm.data.local.TeamDetail

class TeamBolaAdapter(val data: List<TeamDetail>, val context: Context) :
    RecyclerView.Adapter<TeamBolaAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.list_team, null))
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {
        p0.teamTitle.text = data[p1].teamName
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val teamBadge: ImageView = itemView.findViewById(R.id.imgTeam)
        val teamTitle: TextView = itemView.findViewById(R.id.tvTeam)
    }

}
