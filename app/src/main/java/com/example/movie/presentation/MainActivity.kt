package com.example.movie.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movie.R
import com.example.movie.data.repository.RepositoryRetrofitImp
import com.example.movie.domain.repository.RepositoryRetrofit
import com.example.movie.domain.usercase.GetMovieByList
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //тест ретрофит
       // val getMovieByList:GetMovieByList= GetMovieByList(this)
       // getMovieByList.execute()
        //val ref:RepositoryRetrofit=RepositoryRetrofitImp()
       // ref.getMovieNetwork()
    }
}