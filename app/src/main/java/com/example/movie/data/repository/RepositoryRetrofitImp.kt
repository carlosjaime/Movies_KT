package com.example.movie.data.repository

import android.util.Log
import com.example.movie.data.retrofit.MovieApiInterface
import com.example.movie.domain.model.Movie
import com.example.movie.domain.model.MovieList
import com.example.movie.domain.repository.RepositoryRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoryRetrofitImp:RepositoryRetrofit {


    override fun getMovieNetwork(): List<Movie> {
        var movies= listOf<Movie>()
        val call = MovieApiInterface.MovieApiClient.apiClient().getMovieList()
        call.enqueue(
            object : Callback<MovieList>{
                override fun onResponse(call: Call<MovieList>, response: Response<MovieList>) {
                    movies= response.body()?.results ?: throw NullPointerException("ERROR: Network,(NetworkRepositoryImpl)")
                    Log.d("TAG", movies.toString())
                }

                override fun onFailure(call: Call<MovieList>, t: Throwable) {
                    Log.d("TAG", t.toString())
                }

            }
        )
        return movies
    }
}