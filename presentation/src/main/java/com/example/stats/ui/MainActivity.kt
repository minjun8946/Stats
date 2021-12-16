package com.example.stats.ui

import android.os.Build
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.viewpager2.widget.ViewPager2
import com.example.stats.R
import com.example.stats.adapter.MainAdapter
import com.example.stats.base.BaseActivity
import com.example.stats.base.BaseViewModel
import com.example.stats.databinding.ActivityMainBinding
import com.example.stats.model.DateModel
import com.example.stats.viewmodel.MainViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import java.time.LocalDate
import java.util.*

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, BaseViewModel>(),
    BottomNavigationView.OnNavigationItemSelectedListener {

    override val viewModel: MainViewModel by viewModels()
    override val layoutId: Int = R.layout.activity_main

    @RequiresApi(Build.VERSION_CODES.O)
    override fun init() {
        mainViewPagerSlide()
        firstGetGameData()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun firstGetGameData() {
        val localYear = LocalDate.now().year
        if(viewModel.checkRoomData("$localYear - ${localYear+1}")){
            for(i in 0..17){
                viewModel.getGameData(DateModel(null, localYear, null,false, i, 100))
            }
        }
    }

    private fun mainViewPagerSlide() {
        val mainAdapter = MainAdapter(this)
        binding.mainViewPager2.adapter = mainAdapter

        binding.mainViewPager2.registerOnPageChangeCallback(
            object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    binding.bottomNavigationView.menu.getItem(position).isChecked = true
                }
            }
        )
        binding.bottomNavigationView.setOnNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.search_player -> binding.mainViewPager2.currentItem = 0

            R.id.team -> binding.mainViewPager2.currentItem = 1

            else -> binding.mainViewPager2.currentItem = 2
        }
        return true
    }
}