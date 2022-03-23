package com.example.stats.ui

import android.os.Build
import android.widget.Toast
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import com.example.stats.R
import com.example.stats.base.BaseActivity
import com.example.stats.databinding.ActivityTeamGameListBinding
import com.example.stats.model.BasicTeamModel
import com.example.stats.model.DateModel
import com.example.stats.model.GameResultModel
import com.example.stats.viewmodel.TeamGameListViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.time.LocalDate
import java.time.LocalDateTime

@AndroidEntryPoint
class TeamGameListActivity(
) : BaseActivity<ActivityTeamGameListBinding, TeamGameListViewModel>() {
    override val layoutId = R.layout.activity_team_game_list
    override val viewModel: TeamGameListViewModel by viewModels()


    private var teamYear = 2021

    override fun init() {
        val teamData = intent.getSerializableExtra("teamData") as GameResultModel
        getTeamGameData(teamData)
        binding.plusYearBtn.setOnClickListener {
            if (teamYear == 2021){
                Toast.makeText(this,"다음 시즌이 없습니다", Toast.LENGTH_SHORT).show()
            }else{
                teamYear++
                getTeamGameData(teamData)
            }
        }

        binding.minusYearBtn.setOnClickListener {
            teamYear--
            getTeamGameData(teamData)
        }
    }

    private fun setYear(year : Int) {
        binding.teamYearTv.text =  "$year - ${year+1}"
    }

    private fun getTeamGameData(teamData: GameResultModel) {
        viewModel.getTeamGamesData(DateModel(null, teamYear, teamData.teamId,false, 0, 100))
        setYear(teamYear)
    }
}