package com.example.movie.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movie.domain.model.Movie

@Dao
interface MovieDao {

    @Query("SELECT * FROM table_movie")
    fun getMovieList(): List<Movie>

    @Query("SELECT * FROM table_movie WHERE genre_ids==:genr")
    fun getGenrMovieList(genr:String):List<Movie>

    @Query("SELECT * FROM table_movie WHERE id==:id")
    fun getMovieID(id:String):Movie

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movie: Movie)
}