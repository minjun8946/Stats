package com.example.stats.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.stats.R
import com.example.stats.databinding.ActivityMainBinding
import com.example.stats.model.PageModel
import com.example.stats.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel : MainViewModel by viewModel()
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.vm = viewModel
        binding.lifecycleOwner = this
        setContentView(binding.root)

        viewModel.getAllPlayer(PageModel(1,1,"LeBron"))

    }
}