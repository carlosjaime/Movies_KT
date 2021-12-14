package com.example.movie.presentation.list

import android.content.Context
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.movie.domain.model.Movie
import com.example.movie.domain.model.Movie_table
import com.example.movie.presentation.adapter.model.MovieUImodel

interface ListContract {
    interface ListPresenter{
        fun configuringAdapter(recyclerview:RecyclerView)
        fun filterList(filterFlag:String):List<Movie_table>

    }
    interface ListView{
        fun navigateTo(bundle: Bundle,marshrit:Int)
        fun onClickElement()
        fun onClicksearh()
    }
}