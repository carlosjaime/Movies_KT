package com.example.movie.presentation.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.movie.R
import com.example.movie.databinding.FragmentListBinding
import com.example.movie.presentation.base.BaseFragment


class ListFragment : BaseFragment<FragmentListBinding>(),ListContract.ListView {


    override fun getBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentListBinding {
        return FragmentListBinding.inflate(inflater,container,false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val presenter:ListPresenter= ListPresenter(requireContext())
       // presenter.
        presenter.configuringAdapter(binding.rcList)

    }



}