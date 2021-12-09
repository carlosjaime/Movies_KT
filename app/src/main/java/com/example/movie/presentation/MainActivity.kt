package com.example.movie.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.movie.R
import com.example.movie.data.repository.RepositoryRetrofitImp
import com.example.movie.data.repository.RepositoryRoomImp
import com.example.movie.domain.repository.RepositoryRetrofit
import com.example.movie.domain.repository.RepositoryRoom
import com.example.movie.domain.usercase.GetMovieByList
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //тест ретрофит
        val getMovieByList:GetMovieByList= GetMovieByList(this)
       val List= getMovieByList.execute()
        Log.d("List1" ,List.size.toString() )
      //  val ref:RepositoryRetrofit=RepositoryRetrofitImp()
      //  ref.getMovieNetwork(this)
        //val repositoryRoom: RepositoryRoom = RepositoryRoomImp(this, Dispatchers.IO)
    }
}