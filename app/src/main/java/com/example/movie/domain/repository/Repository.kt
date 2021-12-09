package com.example.movie.domain.repository

import android.content.Context
import com.example.movie.domain.model.Movie
import com.example.movie.domain.model.Movie_table

interface Repository {
    fun getMovie()
    fun getMovieDB(): List<Movie_table>
    suspend fun insert(movie:Movie_table)
    fun getGenrMovieList(genr:String):List<Movie_table>
    fun getMovieID(id:String):List<Movie_table>
}