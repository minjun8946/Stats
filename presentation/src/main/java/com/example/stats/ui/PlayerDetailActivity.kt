package com.example.stats.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.data.entity.BasicData
import com.example.domain.entity.Basic
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
        binding.detailTeamImage.setImageDrawable(resources.getDrawable(basicData.teamId))
    }

}