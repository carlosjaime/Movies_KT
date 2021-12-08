package com.example.movie.domain.repository

import com.example.movie.domain.model.Movie

interface RepositoryRetrofit {
    fun getMovieNetwork():List<Movie>
}