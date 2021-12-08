package com.example.movie.presentation.info

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.movie.R
import com.example.movie.databinding.FragmentInfoBlankBinding
import com.example.movie.presentation.base.BaseFragment


class InfoFragment : BaseFragment<FragmentInfoBlankBinding>(),InfoContract.InfoView {
    override fun getBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentInfoBlankBinding {
        return FragmentInfoBlankBinding.inflate(inflater,container,false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}