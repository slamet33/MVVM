package com.example.mvvm.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = arrayOf(TeamDetail::class), version = 1)
abstract class TeamDataBase : RoomDatabase() {
    companion object {
        private var INSTANCE: TeamDataBase? = null
        private val sLock: Any = Object()

        fun getInstance(context: Context): TeamDataBase? {
            synchronized(sLock) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext, TeamDataBase::class.java, "Team.db")
                        .allowMainThreadQueries().build()
                }
            }
            return INSTANCE
        }

        fun destroy() {
            INSTANCE = null
        }
    }

    abstract fun teamDao(): TeamDao
}