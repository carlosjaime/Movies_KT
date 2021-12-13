package com.example.movie.domain.usercase

import android.content.Context
import android.util.Log
import com.example.movie.data.repository.RepositoryImp
import com.example.movie.domain.model.Movie_table
import com.example.movie.domain.repository.Repository
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import java.util.concurrent.Callable
import java.util.concurrent.Executors

class GetMovieByList(val context: Context) {
    @DelicateCoroutinesApi
    fun execute():List<Movie_table>
    {

        val ref:Repository=RepositoryImp(context, Dispatchers.IO)
        ref.getMovie()


        val DBcallable = Callable {ref.getMovieDB()}
        val DBfuture = Executors.newSingleThreadExecutor().submit(DBcallable)
        val DBRes:List<Movie_table> = DBfuture.get()
        Log.d("TAG111", DBRes.size.toString())
        Log.d("TAG211", DBRes.toString())
        return DBRes
    }
}