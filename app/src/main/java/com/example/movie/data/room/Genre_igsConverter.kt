package com.example.movie.data.room

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.TypeConverter
import java.util.*
import java.util.stream.Collectors

class Genre_igsConverter {
    @RequiresApi(Build.VERSION_CODES.N)
    @TypeConverter
    fun fromGenre_ids(genre_ids: List<String>): String {
        return genre_ids.stream().collect((Collectors.joining(",")))

    }

    @TypeConverter
    fun toGenre_ids(data: String): List<String> {
        val array = Arrays.asList(data.split(","))
        return array[0].toList()
    }
}