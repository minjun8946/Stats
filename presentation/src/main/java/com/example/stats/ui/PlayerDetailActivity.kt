package com.example.stats.ui

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.stats.R
import com.example.stats.base.BaseActivity
import com.example.stats.base.teamImage
import com.example.stats.databinding.ActivityPlayerDetailBinding
import com.example.stats.model.BasicModel
import com.example.stats.model.PlayerSeasonIdModel
import com.example.stats.viewmodel.PlayerDetailViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PlayerDetailActivity : BaseActivity<ActivityPlayerDetailBinding, PlayerDetailViewModel>() {

    override val viewModel: PlayerDetailViewModel by viewModel()
    override val layoutId: Int = R.layout.activity_player_detail

    @RequiresApi(Build.VERSION_CODES.O)
    override fun init() {
        val basicData = intent.getSerializableExtra("data") as BasicModel
        setBasicData(basicData)
        viewModel.setYear()
        getPlayerSeasonEvent(basicData)
    }
    private fun getPlayerSeasonEvent(basicData: BasicModel) {
        viewModel.getPlayerSeasonEvent.observe(this, {
            if (it > 1980) viewModel.getPlayerSeasonStats(
                PlayerSeasonIdModel(it, basicData.personId)
            )
        })
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun setBasicData(basicData: BasicModel) {
        binding.name.text = basicData.name
        binding.height.text = basicData.height
        binding.weight.text = basicData.pounds
        binding.teamName.text = basicData.teamName
        binding.detailTeamImage.setImageDrawable(resources.getDrawable(teamImage(basicData.teamId)))
    }

}