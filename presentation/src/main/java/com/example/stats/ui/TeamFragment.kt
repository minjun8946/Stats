package com.example.stats.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.stats.R
import com.example.stats.base.BaseFragment
import com.example.stats.databinding.FragmentSearchPlayerBinding
import com.example.stats.databinding.FragmentTeamBinding
import com.example.stats.viewmodel.SearchPlayerViewModel
import com.example.stats.viewmodel.TeamViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class TeamFragment : BaseFragment<FragmentTeamBinding,TeamViewModel>() {

    override val viewModel : TeamViewModel by viewModel()
    override val layoutId = R.layout.fragment_team

    override fun init() {
        viewModel.getTeamList()
        viewModel.getPlayerStats()
    }
}