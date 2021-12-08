package com.example.movie.data.repository

import com.example.movie.domain.model.Movie
import com.example.movie.domain.repository.RepositoryRoom
import kotlinx.coroutines.flow.Flow

class RepositoryRoomImp:RepositoryRoom {
    override fun getMovieDB(): Flow<List<Movie>> {
        TODO("Not yet implemented")
    }

    override suspend fun insert(movie: Movie) {
        TODO("Not yet implemented")
    }

    override fun getGenrMovieList(genr: String): Flow<List<Movie>> {
        TODO("Not yet implemented")
    }

    override fun getMovieID(id: String): Flow<List<Movie>> {
        TODO("Not yet implemented")
    }
}