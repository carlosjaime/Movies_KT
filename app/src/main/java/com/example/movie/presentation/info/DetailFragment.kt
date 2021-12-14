package com.example.movie.presentation.info

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.movie.R
import com.example.movie.databinding.FragmentDitailBinding
import com.example.movie.databinding.FragmentListBinding
import com.example.movie.presentation.base.BaseFragment
import com.example.movie.presentation.list.ListContract

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class DetailFragment: BaseFragment<FragmentDitailBinding>(), DetailContract.DetailView {




    override fun getBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentDitailBinding {
        return FragmentDitailBinding.inflate(inflater,container,false)
    }


}