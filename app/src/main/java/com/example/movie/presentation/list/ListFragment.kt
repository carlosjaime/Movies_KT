package com.example.movie.presentation.list

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.movie.R
import com.example.movie.databinding.FragmentListBinding
import com.example.movie.domain.model.Movie_table
import com.example.movie.presentation.adapter.DataAdapter
import com.example.movie.presentation.base.BaseFragment


class ListFragment : BaseFragment<FragmentListBinding>(),ListContract.ListView {


    override fun getBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentListBinding {
        return FragmentListBinding.inflate(inflater,container,false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val presenter:ListPresenter= ListPresenter(requireContext())
       // presenter.
       val adapter= presenter.configuringAdapter(binding.rcList)
        adapter.onMovieClickLisener=object : DataAdapter.Companion.OnMovieClickLisener{


            override fun onMovieClick(movie: Movie_table) {

                Log.d("test48",movie.title)
                navigateTo(movie,R.id.action_listFragment_to_detailFragment)
            }



            // ListFragment.findNavController()?.navigate(R.id.action_listFragment_to_detailFragment)
        }
        adapter.onGenrsClickLisener=object : DataAdapter.Companion.OnGenrsClickLisener{
            override fun onGenrClick() {
             // binding.rcList.

            }

        }

    }

    override fun navigateTo(movie: Movie_table, marshrit: Int) {
        val bundle = Bundle()
        bundle.putString("title", movie.title)
        bundle.putString("year", movie.release_date)
        bundle.putString("original_title", movie.original_title)
        bundle.putString("overview", movie.overview)
        bundle.putString("poster_path", movie.poster_path)
        findNavController().navigate(marshrit,bundle)
    }


}