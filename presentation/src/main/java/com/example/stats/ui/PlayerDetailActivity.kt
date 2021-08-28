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
import com.example.stats.base.teamImage
import com.example.stats.databinding.ActivityPlayerDetailBinding
import com.example.stats.model.BasicModel
import com.example.stats.model.PlayerSeasonIdModel
import com.example.stats.viewmodel.PlayerDetailViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PlayerDetailActivity : AppCompatActivity() {

    private val viewModel : PlayerDetailViewModel by viewModel()
    lateinit var binding : ActivityPlayerDetailBinding

    lateinit var name : TextView
    lateinit var height : TextView
    lateinit var weight : TextView
    lateinit var teamName : TextView
    lateinit var teamImage : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_player_detail)
        binding.vm = viewModel
        binding.lifecycleOwner = this
        setContentView(binding.root)

        

        val basicData = intent.getSerializableExtra("data") as BasicModel
        setBasicData(basicData)

        viewModel.setYear()
        viewModel.getPlayerSeasonEvent.observe(this,{
            if(it >1980)
            viewModel.getPlayerSeasonStats(PlayerSeasonIdModel(it,basicData.personId))
            println(it)
        })

        println(basicData)
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun setBasicData(basicData: BasicModel){

        name=findViewById(R.id.name)
        name.text = basicData.name
        height = findViewById(R.id.height)
        height.text = basicData.height
        weight = findViewById(R.id.weight)
        weight.text = basicData.pounds
        teamName = findViewById(R.id.team_name)
        teamName.text = basicData.teamName
        teamImage = findViewById(R.id.detail_team_image)
        teamImage.setImageDrawable(resources.getDrawable(basicData.teamId))
        println("${basicData.teamId} 아이더 넘버 ")
    }
}