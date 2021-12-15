package com.example.movie.data.retrofit

import com.example.movie.domain.model.MovieList
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiInterface {
    @GET("/3/discover/movie")
    fun getMovieList(
        @Query("api_key") api: String="59a202c94eb1db326c806558399d7d75",
        @Query("language") language: String="ru-RU",
        @Query("sort_by") sort_by: String="popularity.desc",
        @Query("page") page: String="1",
        @Query("with_watch_monetization_types") with_watch_monetization_types: String="flatrate"
    ): retrofit2.Call<MovieList>

    object MovieApiClient{
        const val BASE_URL = "https://api.themoviedb.org"
        var retrofitService:MovieApiInterface? = null
        fun apiClient():MovieApiInterface{
            if (retrofitService==null){
                val retrofit= Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService=retrofit.create(MovieApiInterface::class.java)
            }
            return retrofitService?:throw NullPointerException("ERROR: Network,(MovieApiClient)")
        }


    }
}