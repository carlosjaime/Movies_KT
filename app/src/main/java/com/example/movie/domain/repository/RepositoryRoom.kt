package com.example.movie.domain.repository


import com.example.movie.domain.model.Movie
import com.example.movie.domain.model.Movie_table
import kotlinx.coroutines.flow.Flow

interface RepositoryRoom {
    fun getMovieDB(): List<Movie_table>
    suspend fun insert(movie:Movie_table)
    fun getGenrMovieList(genr:String):List<Movie_table>
    fun getMovieID(id:String):List<Movie_table>



}