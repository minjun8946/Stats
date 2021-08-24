package com.example.stats.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.stats.R
import com.example.stats.databinding.FragmentCalenderBinding
import com.example.stats.databinding.FragmentTeamBinding
import com.example.stats.viewmodel.CalenderViewModel
import com.example.stats.viewmodel.TeamViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CalenderFragment : Fragment() {

    val viewModel : CalenderViewModel by viewModel()
    lateinit var binding : FragmentCalenderBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_calender, container, false)
        binding.lifecycleOwner = this
        binding.vm = viewModel

        return binding.root
    }
}