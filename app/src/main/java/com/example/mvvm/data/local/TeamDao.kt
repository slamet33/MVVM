package com.example.mvvm.data.local

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
@Dao
interface TeamDao {
    @android.arch.persistence.room.Query("SELECT * from team")
    fun getAll(): List<TeamDetail>

    @Insert(onConflict = REPLACE)
    fun insert(teamData: List<TeamDetail>)

    @android.arch.persistence.room.Query("DELETE from team")
    fun deleteAll()
}