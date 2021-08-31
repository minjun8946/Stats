package com.example.stats.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.stats.R
import com.example.stats.base.BaseActivity
import com.example.stats.base.BaseViewModel
import com.example.stats.databinding.ActivityMainBinding
import com.example.stats.databinding.ActivityStatsBinding
import com.example.stats.model.BasicModel
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
    }

    fun getStats(gamesModel: GamesModel){
        viewModel.getStats(GameIdModel(gamesModel.gameId,100))
    }
}