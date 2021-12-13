package com.example.movie.presentation.list
import android.content.Context
import android.util.Log
import android.widget.Adapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movie.domain.model.Genres
import com.example.movie.domain.model.Movie
import com.example.movie.domain.model.Movie_table
import com.example.movie.domain.usercase.GetMovieByList
import com.example.movie.domain.usercase.SearchGenresByList
import com.example.movie.presentation.adapter.DataAdapter
import com.example.movie.presentation.adapter.model.MovieUImodel

class ListPresenter(val context: Context):ListContract.ListPresenter {
   /* val adapter:DataAdapter
    init {
        adapter=DataAdapter(context)
    }

    */

    override fun configuringAdapter(recyclerview: RecyclerView) {
        val adapter:DataAdapter=DataAdapter(context)
        val getMovieByList: GetMovieByList = GetMovieByList(context)

        val movies:List<Movie_table> = getMovieByList.execute()
        adapter.setData(getMockData(movies))
        recyclerview.apply{
            //layoutManager=LinearLayoutManager(context)
            layoutManager= GridLayoutManager(context,2)
            (layoutManager as GridLayoutManager).setSpanSizeLookup(object:GridLayoutManager.SpanSizeLookup(){
                override fun getSpanSize(position: Int): Int {
                   if(position>2) return 1
                    else return 2
                }

            } )

            this.adapter=adapter
        }
        adapter.onMovieClickLisener=object : DataAdapter.Companion.OnMovieClickLisener{
            override fun onMovieClick() {

            }
        }
        adapter.onGenrsClickLisener=object : DataAdapter.Companion.OnGenrsClickLisener{
            override fun onGenrClick() {
                val searchGenresByList: SearchGenresByList =SearchGenresByList()
                adapter.setData(getMockData(searchGenresByList.execute(context,"28")))
                adapter.notifyDataSetChanged()
            }

        }

    }

    override fun filterList(filterFlag: Int): List<Movie> {
        TODO("Not yet implemented")
    }

    private fun getMockData(list:List<Movie_table>): List<MovieUImodel> {
        val ls :MutableList<MovieUImodel> = mutableListOf()
        ls.add(MovieUImodel.Title("Жанры"))
        ls.add(MovieUImodel.Genre(Genres.list_genres))
        ls.add(MovieUImodel.Title("Фильмы"))
        for(ln in list)
            ls.add(MovieUImodel.Cover(ln))
        Log.d("TAG", ls.toString())
        return ls.toList()

    }

}