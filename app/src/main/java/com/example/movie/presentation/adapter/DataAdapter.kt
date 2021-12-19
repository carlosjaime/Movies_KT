package com.example.movie.presentation.adapter
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movie.R
import com.example.movie.domain.model.Movie
import com.example.movie.domain.model.Movie_table
import com.example.movie.presentation.adapter.model.MovieUImodel
import com.example.movie.presentation.list.ListPresenter
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class DataAdapter(private val context: Context): RecyclerView.Adapter<DataAdapter.DataAdapterViewHolder>() {

    private val adapterData = mutableListOf<MovieUImodel>()

    var onMovieClickLisener:OnMovieClickLisener?=null
    var onGenrsClickLisener:OnGenrsClickLisener?=null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataAdapterViewHolder {

        val layout = when (viewType) {
            TYPE_TITLE -> R.layout.item_group
            TYPE_GENRE -> R.layout.item_generes
            TYPE_MOVIE  -> R.layout.item_movie
            else -> throw IllegalArgumentException("Invalid view type")
        }

        val view = LayoutInflater
            .from(parent.context)
            .inflate(layout, parent, false)

        return DataAdapterViewHolder(view,onGenrsClickLisener)
    }


    //-----------onBindViewHolder: bind view with data model---------
    override fun onBindViewHolder(holder: DataAdapterViewHolder, position: Int) {
        holder.bind(adapterData[position],context)
        holder.itemView.setOnClickListener{
            if(holder.itemViewType==1)
            {
               // onGenrsClickLisener?.onGenrClick()
                Log.d("type112","genrse")
            }
            else if (holder.itemViewType==2)
            {
                val item: MovieUImodel.Cover= adapterData[position] as MovieUImodel.Cover



                onMovieClickLisener?.onMovieClick(item.MovieEntity)
                Log.d("type112","movie")
            }

        }


    }

    override fun getItemCount(): Int = adapterData.size

    override fun getItemViewType(position: Int): Int {
        return when (adapterData[position]) {
            is MovieUImodel.Title -> TYPE_TITLE
            is MovieUImodel.Genre -> TYPE_GENRE
            else -> TYPE_MOVIE
        }
    }

    fun setData(data: List<MovieUImodel>) {
        adapterData.apply {
            clear()
            addAll(data)
        }
    }
    companion object {
        private const val TYPE_TITLE = 0
        private const val TYPE_GENRE = 1
        private const val TYPE_MOVIE = 2



    }
    interface OnMovieClickLisener
    {
        fun onMovieClick(movie: Movie_table)
    }

    interface OnGenrsClickLisener
    {
        fun onGenrClick(string: String)
    }
    class DataAdapterViewHolder(itemView: View,var onGenrsClickLisener:OnGenrsClickLisener?) : RecyclerView.ViewHolder(itemView) {

        private fun bindTitle(item: MovieUImodel.Title) {
            itemView.findViewById<TextView>(R.id.tvTitle).text=item.title

        }

        private fun bindGenre(item: MovieUImodel.Genre,context: Context) {
            Log.d("aaaaa","BEGIN")

            itemView.findViewById<ChipGroup>(R.id.chipGpRow).removeAllViews()
            for (i in item.list_genres)
            {
                val chip = Chip(context).apply {
                    text=i.key
                    isCheckable = true
                    isCheckedIconVisible = false
                }


                itemView.findViewById<ChipGroup>(R.id.chipGpRow).addView(chip)
                Log.d("aaaaa",i.key)

                chip.setOnCheckedChangeListener{
                    _,isChecked ->

                    if (isChecked) {

                       onGenrsClickLisener?.onGenrClick(chip.text.toString())
                        Log.d("type112","genrse")
                        Log.d("type999",chip.text.toString())
                       //chip.isChecked=false
                    }
                    else
                    {
                        Log.d("type999","genrse")
                    }
                  //  chip.isChecked=false
                }


            }
            Log.d("aaaaa","END")
        }

        private fun bindMovie(item: MovieUImodel.Cover) {
            itemView.findViewById<TextView>(R.id.film_name).text=item.MovieEntity.title
            Glide.with(itemView)
                .load("https://image.tmdb.org/t/p/w500"+item.MovieEntity.poster_path)
                .into(itemView.findViewById<ImageView>(R.id.film_cover))


        }
        fun bind(dataModel: MovieUImodel,context: Context) {
            when (dataModel) {
                is MovieUImodel.Title -> bindTitle(dataModel)
                is MovieUImodel.Genre -> bindGenre(dataModel,context)
                is MovieUImodel.Cover -> bindMovie(dataModel)

            }
        }
    }}

