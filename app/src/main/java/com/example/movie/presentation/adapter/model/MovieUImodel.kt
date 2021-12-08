package com.example.movie.presentation.adapter.model

import com.example.movie.domain.model.Movie

sealed class MovieUImodel {
    data class Cover(val MovieEntity: Movie) :  MovieUImodel()
    data class Title(val title: String) :  MovieUImodel()
    data class Genre(val list_genres: Map<String, Int>) :  MovieUImodel()
}