package com.example.stats.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.stats.R
import com.example.stats.adapter.MainAdapter
import com.example.stats.base.SingleLiveEvent
import com.example.stats.databinding.ActivityMainBinding
import com.example.stats.model.BasicModel
import com.example.stats.model.PageModel
import com.example.stats.model.PlayerSeasonIdModel
import com.example.stats.model.StatsBasicInfoModel
import com.example.stats.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel : MainViewModel by viewModel()
    private lateinit var binding : ActivityMainBinding
    lateinit var viewPager2: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.vm = viewModel
        binding.lifecycleOwner = this
        setContentView(binding.root)

        viewPager2 = findViewById(R.id.main_viewPager2)
        val mainAdapter = MainAdapter(this)
        viewPager2.adapter = mainAdapter

    }

}