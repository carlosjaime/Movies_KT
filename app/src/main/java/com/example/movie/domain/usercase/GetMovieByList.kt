package com.example.movie.domain.usercase

import android.content.Context
import android.telecom.Call
import android.util.Log
import android.util.Log.DEBUG
import com.example.movie.data.repository.RepositoryRetrofitImp
import com.example.movie.data.repository.RepositoryRoomImp
import com.example.movie.domain.model.Movie
import com.example.movie.domain.repository.RepositoryRetrofit
import com.example.movie.domain.repository.RepositoryRoom
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.concurrent.Callable
import java.util.concurrent.Executors

class GetMovieByList(val context: Context) {
    fun execute():List<Movie>
    {
        val repositoryRetrofit: RepositoryRetrofit=RepositoryRetrofitImp()
        val repositoryRoom: RepositoryRoom=RepositoryRoomImp(context, Dispatchers.IO)

        val nwcallable = Callable {repositoryRetrofit.getMovieNetwork()}
        val nwfuture = Executors.newSingleThreadExecutor().submit(nwcallable)
        val networkRes:List<Movie> = nwfuture.get()

        networkRes.forEach {
            GlobalScope.launch {
                repositoryRoom.insert(it)
                Log.d("TAG",it.toString())
            }
        }
        val DBcallable = Callable {repositoryRetrofit.getMovieNetwork()}
        val DBfuture = Executors.newSingleThreadExecutor().submit(DBcallable)
        val DBRes:List<Movie> = DBfuture.get()
        return  DBRes
    }
}