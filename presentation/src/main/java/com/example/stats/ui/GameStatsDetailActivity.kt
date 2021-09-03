package com.example.stats.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.stats.R
import com.example.stats.base.BaseActivity
import com.example.stats.databinding.ActivityGameStatsDetailBinding
import com.example.stats.model.StatsModel
import com.example.stats.viewmodel.GameStatsDetailViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class GameStatsDetailActivity :
    BaseActivity<ActivityGameStatsDetailBinding, GameStatsDetailViewModel>() {

    override val layoutId = R.layout.activity_game_stats_detail
    override val viewModel : GameStatsDetailViewModel by viewModel()
    override fun init() {
        val basicData = intent.getSerializableExtra("statsData") as StatsModel
        inputStatsData(basicData)
    }

    @SuppressLint("SetTextI18n", "UseCompatLoadingForDrawables")
    fun inputStatsData(data : StatsModel){
        binding.position.text = data.playerInfo.position
        binding.teamImage.setImageDrawable(resources.getDrawable(data.teamInfo.teamId))
        binding.playerName.text = data.playerInfo.teamName
        binding.gameDate.text = data.gameInfo.gameDate
        binding.assist.text = "AST\n${data.assist.split(" ")[1]}"
        binding.block.text = "BLK\n${data.block}"
        binding.deRebound.text = "DREB\n${data.deffensiveRebound}"
        binding.fieldGoal.text = "FGM\n${data.fieldGoalMade}"
        binding.fieldGoalAttempted.text = "FGM\n${data.fieldGoalAttempted}"
        binding.fieldGoalRate.text = "FG%\n${data.fieldGoalSuccessRate}"
        binding.foul.text = "P.F\n${data.personalFoul}"
        binding.ftRate.text = "FT%\n${data.freeThrowSuccessRate}"
        binding.fta.text = "FAM\n${data.freeThrowAttempted}"
        binding.ftm.text = "FTM\n${data.freeThrowMade}"
        binding.min.text = "MIN\n${data.minute}"
        binding.offRebound.text = "OREB\n${data.offenceRebound}"
        binding.points.text = "PTS\n${data.point.split(" ")[1]}"
        binding.steal.text = "STL\n${data.steal}"
        binding.threePointGoal.text = "3PM\n${data.threePointGoalMade}"
        binding.threePointGoalAttempted.text = "3PA\n${data.threePointGoalAttempted}"
        binding.threePointGoalRate.text = "3PR\n${data.threePointSuccessRate}%"
        binding.totalRebound.text = "REB\n${data.rebound.split(" ")[1]}"
        binding.turnover.text = "TOV\n${data.turnover}"
    }
}