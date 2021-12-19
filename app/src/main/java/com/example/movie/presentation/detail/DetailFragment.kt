package com.example.movie.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.movie.databinding.FragmentDitailBinding
import com.example.movie.presentation.base.BaseFragment




class DetailFragment: BaseFragment<FragmentDitailBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvTitle.text="Name :${requireArguments().getString("title")}"
        binding.tvOrigenalTitle.text="Original name: ${requireArguments().getString("original_title")}"
        binding.tvyear.text="Year relis: ${requireArguments().getString("year")}"
        binding.tvOverview.text=requireArguments().getString("overview")
        binding.tvrating.text="Rating ${requireArguments().getString("rating")}"
        val detailPresenter:DetailPresenter= DetailPresenter(requireArguments().getString("poster_path")!!,binding.ivPoster)
        detailPresenter.setPoster()

    }

    override fun getBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentDitailBinding {
        return FragmentDitailBinding.inflate(inflater,container,false)
    }




}