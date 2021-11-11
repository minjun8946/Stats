package com.example.stats.ui

import android.os.Build
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import com.example.stats.R
import com.example.stats.base.BaseActivity
import com.example.stats.databinding.ActivityTeamGameListBinding
import com.example.stats.model.BasicTeamModel
import com.example.stats.model.DateModel
import com.example.stats.viewmodel.TeamGameListViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.time.LocalDate

@AndroidEntryPoint
class TeamGameListActivity(
) : BaseActivity<ActivityTeamGameListBinding, TeamGameListViewModel>() {
    override val layoutId = R.layout.activity_team_game_list
    override val viewModel: TeamGameListViewModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.O)
    var teamYear = LocalDate.now().year

    override fun init() {
        val teamData = intent.getSerializableExtra("teamData") as BasicTeamModel
        getTeamGameData(teamData)
        binding.plusYearBtn.setOnClickListener {
            teamYear++
            getTeamGameData(teamData)
        }

        binding.minusYearBtn.setOnClickListener {
            teamYear--
            getTeamGameData(teamData)
        }
    }

    private fun setYear(year : Int) {
        binding.teamYearTv.text =  "$year - ${year+1}"
    }

    private fun getTeamGameData(teamData: BasicTeamModel) {
        viewModel.getTeamGamesData(DateModel(null, teamYear, teamData.teamId, 0, 100))
        setYear(teamYear)
    }
}