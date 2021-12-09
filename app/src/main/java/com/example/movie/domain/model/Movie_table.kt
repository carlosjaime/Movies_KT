package com.example.movie.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tmovie")
data class Movie_table (
    @PrimaryKey
    var id:Int = 0,
    var original_title: String,
    var overview: String,
    var poster_path: String,
    var release_date: String,
    var title: String,
    var genre_ids: List<String>
        )