package com.example.movie.data.repository

import android.content.Context
import android.util.Log
import com.example.movie.data.retrofit.MovieApiInterface
import com.example.movie.data.room.MovieDao
import com.example.movie.data.room.RoomDatabaseMovie
import com.example.movie.domain.model.Movie
import com.example.movie.domain.model.MovieList
import com.example.movie.domain.model.Movie_table
import com.example.movie.domain.repository.Repository
import kotlinx.coroutines.*
import org.jetbrains.anko.doAsync
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoryImp(val context: Context, private val backgroundDispatcher: CoroutineDispatcher):Repository {

    var  movies:List<Movie> = listOf()
    private val movieDao: MovieDao
    init {
        val database =RoomDatabaseMovie.getInstance(context,backgroundDispatcher)
        movieDao= database?.movieDao() ?:throw NullPointerException("ERROR: Database,(RepositoryRoom)")
    }

    override fun getMovie() {
        val call = MovieApiInterface.MovieApiClient.apiClient().getMovieList()

        doAsync {

            call.enqueue(
                object : Callback<MovieList>{

                    override fun onResponse(call: Call<MovieList>, response: Response<MovieList>) {

                        movies= response.body()?.results ?: throw NullPointerException("ERROR: Network,(NetworkRepositoryImpl)")
                        Log.d("TAG1", movies[0].title)

                        movies.forEach {
                            GlobalScope.launch {
                                insert(
                                Movie_table(
                                id = it.id,
                                original_title=it.original_title,
                                overview=it.overview,
                                poster_path=it.poster_path,
                                release_date=it.release_date,
                                title=it.title,
                                genre_ids=it.genre_ids
                            )
                            )

                            }
                        }

                    }


                    override fun onFailure(call: Call<MovieList>, t: Throwable) {
                        Log.d("TAG1", t.toString())
                    }

                }
            )}

    }

    override fun getMovieDB(): List<Movie_table> {
        return movieDao.getMovieList()
    }

    override suspend fun insert(movie: Movie_table) {
        withContext(backgroundDispatcher)
        {
            movieDao.insertMovie(movie)
        }
    }

    override fun getGenrMovieList(genr: String): List<Movie_table> {
        return movieDao.getGenrMovieList(genr)
    }

    override fun getMovieID(id: String): List<Movie_table> {
        return movieDao.getMovieID(id)
    }
}
