package com.example.movie.presentation.detail

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.movie.R

class DetailPresenter(var img:String,var imageView: ImageView):DetailContract.DetailPresenter {
  fun  setPoster()
  {
      Glide.with(imageView).load("https://image.tmdb.org/t/p/w500"+img)
          .into(imageView.findViewById<ImageView>(R.id.ivPoster))
  }

}