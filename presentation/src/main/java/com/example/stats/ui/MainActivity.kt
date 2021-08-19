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

    private lateinit var searchEditText : EditText

    private var searchText =""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.vm = viewModel
        binding.lifecycleOwner = this
        setContentView(binding.root)

        searchEditText = findViewById(R.id.search_edittext)

        getAllPlayer()
        scrollListenerEvent()
        search()
    }

    private fun search(){
        viewModel.searchEvent.observe(this,{
            searchText = searchEditText.text.toString()
            getAllPlayer()
        })
    }

    private fun scrollListenerEvent(){
        viewModel.scrollListenerEvent.observe(this,{
            getAllPlayer()
        })
    }

    private fun getAllPlayer(){
        viewModel.getAllPlayer(PageModel(viewModel.page,15,searchText))
    }


}