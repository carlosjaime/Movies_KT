package com.example.movie.domain.repository


import com.example.movie.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface RepositoryRoom {
    fun getMovieDB(): Flow<List<Movie>>
    suspend fun insert(movie: Movie)
    fun getGenrMovieList(genr:String):Flow<List<Movie>>
    fun getMovieID(id:String):Flow<List<Movie>>



}