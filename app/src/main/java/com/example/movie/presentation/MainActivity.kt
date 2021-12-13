package com.example.movie.presentation

import android.os.AsyncTask.execute
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.movie.R
import com.example.movie.domain.usercase.GetMovieByList
import com.example.movie.domain.usercase.SearchGenresByList
import kotlinx.coroutines.DelicateCoroutinesApi

class MainActivity : AppCompatActivity() {
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*тест ретрофит
        val getMovieByList:GetMovieByList= GetMovieByList(this)
       val List= getMovieByList.execute()
        Log.d("List1" ,List.size.toString() )
        Log.d("List2" ,List[0].title )
        val getMovieSearhList:SearchGenresByList= SearchGenresByList()
        val List1= getMovieSearhList.execute(this,"28")
        Log.d("List1" ,List1.size.toString() )
        Log.d("List2" ,List1[0].title)

         */

    }


}