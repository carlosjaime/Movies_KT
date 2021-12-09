package com.example.movie.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movie.domain.model.Movie
import com.example.movie.domain.model.Movie_table
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Query("SELECT * FROM tmovie")
    fun getMovieList(): List<Movie_table>

    @Query("SELECT * FROM tmovie WHERE genre_ids  LIKE '%' || :search || '%'")
    fun getGenrMovieList(search:String):List<Movie_table>

    @Query("SELECT * FROM tmovie WHERE id==:id")
    fun getMovieID(id:String):List<Movie_table>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movie: Movie_table)
}