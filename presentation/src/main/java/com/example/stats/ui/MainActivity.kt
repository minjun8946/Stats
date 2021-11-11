package com.example.stats.ui

import android.view.MenuItem
import androidx.activity.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.example.stats.R
import com.example.stats.adapter.MainAdapter
import com.example.stats.base.BaseActivity
import com.example.stats.base.BaseViewModel
import com.example.stats.databinding.ActivityMainBinding
import com.example.stats.viewmodel.MainViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, BaseViewModel>(),BottomNavigationView.OnNavigationItemSelectedListener {

    override val viewModel : MainViewModel by viewModels()
    override val layoutId: Int = R.layout.activity_main

    override fun init() {
        mainViewPagerSlide()
    }

    private fun mainViewPagerSlide(){
        val mainAdapter = MainAdapter(this)
        binding.mainViewPager2.adapter = mainAdapter

        binding.mainViewPager2.registerOnPageChangeCallback(
            object : ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    binding.bottomNavigationView.menu.getItem(position).isChecked = true
                }
            }
        )
        binding.bottomNavigationView.setOnNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
         when(item.itemId){
            R.id.search_player -> binding.mainViewPager2.currentItem = 0

            R.id.team -> binding.mainViewPager2.currentItem = 1

            else -> binding.mainViewPager2.currentItem = 2
        }
        return true
    }
}