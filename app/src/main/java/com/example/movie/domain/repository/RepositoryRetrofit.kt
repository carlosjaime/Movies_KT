package com.example.movie.domain.repository

import android.content.Context
import com.example.movie.domain.model.Movie

interface RepositoryRetrofit {
    fun getMovieNetwork(context: Context)
}