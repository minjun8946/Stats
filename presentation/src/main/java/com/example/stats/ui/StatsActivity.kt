package com.example.stats.ui

import android.annotation.SuppressLint
import com.example.stats.R
import com.example.stats.base.BaseActivity
import com.example.stats.base.BaseViewModel
import com.example.stats.base.teamImage
import com.example.stats.databinding.ActivityStatsBinding
import com.example.stats.model.GameIdModel
import com.example.stats.model.GamesModel
import com.example.stats.viewmodel.StatsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class StatsActivity : BaseActivity<ActivityStatsBinding, BaseViewModel>() {

    override val layoutId: Int = R.layout.activity_stats
    override val viewModel : StatsViewModel by viewModel()

    override fun init() {
        val basicData = intent.getSerializableExtra("gameData") as GamesModel
        getStats(basicData)
        getGamesModel(basicData)
    }

    private fun getStats(gamesModel: GamesModel){
        viewModel.getStats(GameIdModel(gamesModel.gameId,100))
    }
    @SuppressLint("UseCompatLoadingForDrawables")
    private fun getGamesModel(gamesModel: GamesModel){
        binding.homeTeamImage.setImageDrawable(resources.getDrawable(teamImage(gamesModel.homeTeam.homeTeamId)))
        binding.homeTeamText.text = gamesModel.homeTeam.homeCityName
        binding.homeTeamScore.text = gamesModel.homeTeamScore
        binding.gameDate.text = gamesModel.gameDate
        binding.status.text = gamesModel.status
        binding.visitorTeamImage.setImageDrawable(resources.getDrawable(teamImage(gamesModel.visitorTeam.visitorId)))
        binding.visitorTeamText.text = gamesModel.visitorTeam.visitorCityName
        binding.visitorScore.text = gamesModel.visitorTeamScore
    }
}