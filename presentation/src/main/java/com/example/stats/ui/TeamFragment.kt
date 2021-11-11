package com.example.stats.ui

import androidx.fragment.app.viewModels
import com.example.stats.R
import com.example.stats.base.BaseFragment
import com.example.stats.databinding.FragmentTeamBinding
import com.example.stats.viewmodel.TeamViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TeamFragment : BaseFragment<FragmentTeamBinding,TeamViewModel>() {

    override val viewModel : TeamViewModel by viewModels()
    override val layoutId = R.layout.fragment_team

    override fun init() {
        viewModel.getTeamList()
    }
}