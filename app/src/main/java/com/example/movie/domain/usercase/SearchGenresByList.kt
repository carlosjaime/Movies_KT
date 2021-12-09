package com.example.movie.domain.usercase

import android.content.Context
import android.util.Log
import com.example.movie.data.repository.RepositoryImp
import com.example.movie.domain.model.Movie_table
import com.example.movie.domain.repository.Repository
import kotlinx.coroutines.Dispatchers
import java.util.concurrent.Callable
import java.util.concurrent.Executors

class SearchGenresByList {
  fun execute(context: Context, genr:String):List<Movie_table>
  {val ref: Repository = RepositoryImp(context, Dispatchers.IO)
      val DBcallable = Callable {ref.getGenrMovieList(genr)}
      val DBfuture = Executors.newSingleThreadExecutor().submit(DBcallable)
      val DBRes:List<Movie_table> = DBfuture.get()
      Log.d("TAG111", DBRes.size.toString())
      Log.d("TAG211", DBRes.toString())
      return DBRes

  }
}