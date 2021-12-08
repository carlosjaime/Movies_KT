package com.example.movie.domain.usercase

import com.example.movie.domain.model.Movie

class GetMovieInfo() {
    fun execute(movie: Movie):String
    {
        return movie.overview
    }
}