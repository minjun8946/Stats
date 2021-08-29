package com.example.stats.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.stats.R
import com.example.stats.adapter.MainAdapter
import com.example.stats.base.BaseActivity
import com.example.stats.base.BaseViewModel
import com.example.stats.base.SingleLiveEvent
import com.example.stats.databinding.ActivityMainBinding
import com.example.stats.model.BasicModel
import com.example.stats.model.PageModel
import com.example.stats.model.PlayerSeasonIdModel
import com.example.stats.model.StatsBasicInfoModel
import com.example.stats.viewmodel.MainViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, BaseViewModel>(),BottomNavigationView.OnNavigationItemSelectedListener {

    override val viewModel : MainViewModel by viewModel()
    override val layoutResID: Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
        return when(item.itemId){
            R.id.search_player ->{
                binding.mainViewPager2.currentItem = 0
                true
            }
            R.id.team ->{
                binding.mainViewPager2.currentItem = 1
                true
            }
            else -> {
                binding.mainViewPager2.currentItem = 2
                true
            }
        }
    }
}