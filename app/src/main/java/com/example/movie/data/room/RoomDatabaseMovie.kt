package com.example.movie.data.room

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.CoroutineDispatcher

abstract class RoomDatabaseMovie : RoomDatabase() {
    abstract fun movieDao():MovieDao
    companion object {
        private var INSTANCE: RoomDatabaseMovie? = null
        fun getInstance(
            context: Context,
            backgroundDispatcher: CoroutineDispatcher
        ): RoomDatabaseMovie? {
            if (INSTANCE == null) {
                synchronized(RoomDatabaseMovie::class)
                {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        RoomDatabaseMovie::class.java, "best_movie_database"
                    ).build()
                }
            }
            return INSTANCE
        }


    }
}