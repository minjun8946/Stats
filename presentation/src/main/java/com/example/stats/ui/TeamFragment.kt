package com.example.stats.ui

import com.example.stats.R
import com.example.stats.base.BaseFragment
import com.example.stats.databinding.FragmentTeamBinding
import com.example.stats.viewmodel.TeamViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class TeamFragment : BaseFragment<FragmentTeamBinding,TeamViewModel>() {

    override val viewModel : TeamViewModel by viewModel()
    override val layoutId = R.layout.fragment_team

    override fun init() {
        viewModel.getTeamList()
    }
}