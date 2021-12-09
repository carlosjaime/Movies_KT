package com.example.movie.domain.usercase

import android.content.Context
import android.telecom.Call
import android.util.Log
import android.util.Log.DEBUG
import androidx.room.PrimaryKey
import com.example.movie.data.repository.RepositoryRetrofitImp
import com.example.movie.data.repository.RepositoryRoomImp
import com.example.movie.domain.model.Movie
import com.example.movie.domain.model.Movie_table
import com.example.movie.domain.repository.RepositoryRetrofit
import com.example.movie.domain.repository.RepositoryRoom
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.concurrent.Callable
import java.util.concurrent.Executors

class GetMovieByList(val context: Context) {
    @DelicateCoroutinesApi
    fun execute():List<Movie_table>
    {
        val repositoryRetrofit: RepositoryRetrofit=RepositoryRetrofitImp()
        val repositoryRoom: RepositoryRoom =RepositoryRoomImp(context, Dispatchers.IO)
        val ref:RepositoryRetrofit=RepositoryRetrofitImp()
        ref.getMovieNetwork(context)
        val DBcallable = Callable {repositoryRoom.getMovieDB()}
        val DBfuture = Executors.newSingleThreadExecutor().submit(DBcallable)
        val DBRes:List<Movie_table> = DBfuture.get()
        Log.d("TAG111", DBRes.size.toString())
        Log.d("TAG211", DBRes.toString())
        return DBRes
    }
}