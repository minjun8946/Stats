package com.example.stats.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.stats.R
import com.example.stats.databinding.FragmentSearchPlayerBinding
import com.example.stats.databinding.FragmentTeamBinding
import com.example.stats.viewmodel.SearchPlayerViewModel
import com.example.stats.viewmodel.TeamViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class TeamFragment : Fragment() {

    val viewModel : TeamViewModel by viewModel()
    lateinit var binding : FragmentTeamBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_team, container, false)
        binding.lifecycleOwner = this
        binding.vm = viewModel

        viewModel.getTeamList()

        return binding.root
    }
}