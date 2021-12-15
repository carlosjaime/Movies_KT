package com.example.movie.presentation.list
import android.content.Context
import android.util.Log
import android.widget.Adapter
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movie.R
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
   val getMovieByList: GetMovieByList = GetMovieByList(context)
    override fun configuringAdapter(recyclerview: RecyclerView):DataAdapter {
        val adapter:DataAdapter=DataAdapter(context)
        //val getMovieByList: GetMovieByList = GetMovieByList(context)

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
       /* adapter.onMovieClickLisener=object : DataAdapter.Companion.OnMovieClickLisener{


            override fun onMovieClick(movie: Movie_table) = // Log.d("test48",movie.title)

                   // ListFragment.findNavController()?.navigate(R.id.action_listFragment_to_detailFragment)
        }
        adapter.onGenrsClickLisener=object : DataAdapter.Companion.OnGenrsClickLisener{
            override fun onGenrClick() {

                adapter.setData(getMockData(filterList("28")))
                adapter.notifyDataSetChanged()
            }

        }

        */
        return adapter
    }

    override fun filterList(filterFlag: String): List<Movie_table> {
        val searchGenresByList: SearchGenresByList =SearchGenresByList()
        return searchGenresByList.execute(context,filterFlag)
    }

     fun getMockData(list:List<Movie_table>): List<MovieUImodel> {
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