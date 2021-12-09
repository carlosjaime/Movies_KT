package com.example.movie.domain.usercase

import android.content.Context
import com.example.movie.data.repository.RepositoryRoomImp
import com.example.movie.domain.model.Movie
import com.example.movie.domain.model.Movie_table
import com.example.movie.domain.repository.RepositoryRoom
import kotlinx.coroutines.Dispatchers
import java.util.concurrent.Callable
import java.util.concurrent.Executors

class SearchGenresByList {
  fun execute(context: Context, genr:String):List<Movie_table>
  {
      val repositoryRoom:RepositoryRoom= RepositoryRoomImp(context, Dispatchers.Default)
      val callable = Callable {repositoryRoom.getGenrMovieList(genr)}
      var res:MutableList<Movie_table> = mutableListOf()
      val future = Executors.newSingleThreadExecutor().submit(callable)
      res=future.get().toMutableList()
      return res
  }
}