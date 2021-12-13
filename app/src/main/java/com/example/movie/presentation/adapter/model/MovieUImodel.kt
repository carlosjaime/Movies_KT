package com.example.movie.presentation.adapter.model

import com.example.movie.domain.model.Movie
import com.example.movie.domain.model.Movie_table

sealed class MovieUImodel {
    data class Cover(val MovieEntity: Movie_table) :  MovieUImodel()
    data class Title(val title: String) :  MovieUImodel()
    data class Genre(val list_genres: Map<String, Int>) :  MovieUImodel()
}