package com.example.movie.presentation.list

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.example.movie.domain.model.Movie
import com.example.movie.presentation.adapter.model.MovieUImodel

interface ListContract {
    interface ListPresenter{
        fun configuringAdapter(recyclerview:RecyclerView,context: Context)
        fun filterList(filterFlag:Int):List<Movie>

    }
    interface ListView{
        fun navigateTo(id:Int,marshrit:Int)
        fun onClickElement()
    }
}