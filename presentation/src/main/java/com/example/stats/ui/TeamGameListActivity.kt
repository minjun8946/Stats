package com.example.stats.ui

import com.example.stats.R
import com.example.stats.base.BaseActivity
import com.example.stats.databinding.ActivityGameStatsDetailBinding
import com.example.stats.model.DateModel
import com.example.stats.viewmodel.TeamGameListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class TeamGameListActivity(
) : BaseActivity<ActivityGameStatsDetailBinding, TeamGameListViewModel>() {
    override val layoutId =  R.layout.activity_team_game_list
    override val viewModel: TeamGameListViewModel by viewModel()

    override fun init() {
        viewModel.getTeamGamesData(DateModel(null,2020,1,0,100))
    }

}