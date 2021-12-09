package com.example.movie.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.movie.domain.model.Movie
import com.example.movie.domain.model.Movie_table
import kotlinx.coroutines.CoroutineDispatcher
@Database(entities = arrayOf(Movie_table::class), version = 1, exportSchema = false)
@TypeConverters(Genre_igsConverter::class)
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