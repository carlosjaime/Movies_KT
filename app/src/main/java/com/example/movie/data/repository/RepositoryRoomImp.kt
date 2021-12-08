package com.example.movie.data.repository

import android.content.Context
import com.example.movie.data.room.MovieDao
import com.example.movie.data.room.RoomDatabaseMovie
import com.example.movie.domain.model.Movie
import com.example.movie.domain.repository.RepositoryRoom
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class RepositoryRoomImp(context: Context, private val backgroundDispatcher: CoroutineDispatcher):RepositoryRoom {
    private val movieDao: MovieDao
    init {
        val database =RoomDatabaseMovie.getInstance(context,backgroundDispatcher)
        movieDao= database?.movieDao() ?:throw NullPointerException("ERROR: Database,(RepositoryRoom)")
    }
    override fun getMovieDB(): List<Movie> {
       return movieDao.getMovieList()
    }

    override suspend fun insert(movie: Movie) {
        withContext(backgroundDispatcher)
        {
            movieDao.insertMovie(movie)
        }
    }

    override fun getGenrMovieList(genr: String): List<Movie> {
       return movieDao.getGenrMovieList(genr)
    }

    override fun getMovieID(id: String): Flow<Movie> {
       return movieDao.getMovieID(id)
    }
}