package com.example.movie.data.repository

import android.content.Context
import android.util.Log
import com.example.movie.data.retrofit.MovieApiInterface
import com.example.movie.domain.model.Movie
import com.example.movie.domain.model.MovieList
import com.example.movie.domain.model.Movie_table
import com.example.movie.domain.repository.RepositoryRetrofit
import com.example.movie.domain.repository.RepositoryRoom
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jetbrains.anko.doAsync
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.Callable
import java.util.concurrent.Executors

class RepositoryRetrofitImp:RepositoryRetrofit {

    var  movies:List<Movie> = listOf()
    @OptIn(DelicateCoroutinesApi::class)
    override fun getMovieNetwork(context:Context) {



        val call = MovieApiInterface.MovieApiClient.apiClient().getMovieList()
        val repositoryRoom: RepositoryRoom =RepositoryRoomImp(context, Dispatchers.IO)
        doAsync {
        call.enqueue(
            object : Callback<MovieList>{

                override fun onResponse(call: Call<MovieList>, response: Response<MovieList>) {

                      movies= response.body()?.results ?: throw NullPointerException("ERROR: Network,(NetworkRepositoryImpl)")
                    Log.d("TAG1", movies[0].title)

                    movies.forEach {
                        GlobalScope.launch {
                    repositoryRoom.insert(
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
      //  Log.d("TAG112", movies.toString())


       // movies=repositoryRoom.getMovieDB()

    }
}