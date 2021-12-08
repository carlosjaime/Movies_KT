package com.example.movie.domain.model

//Пример запроса
//https://api.themoviedb.org/3/discover/movie?
// api_key=59a202c94eb1db326c806558399d7d75&
// language=ru-Ru&
// sort_by=popularity.desc&include_adult=false&include_video=false&
// page=2&
// with_watch_monetization_types=flatrate

//@Entity(tableName = "table_movie")

data class Movie(
    var adult:Boolean = false,
    var backdrop_path: String,
    var genre_ids: List<String>,
    var id:Int = 0,
    var original_language: String,
    var original_title: String,
    var overview: String,
    var popularity:Double = 0.0,
    var poster_path: String,
    var release_date: String,
    var title: String,
    var video:Boolean = false,
    var vote_average:Double = 0.0,
    var vote_count:Int = 0
)

data class MovieList (
    var page:Int = 0,
    var results: List<Movie>,
    var total_pages:Int = 0,
    var total_results:Int = 0
)