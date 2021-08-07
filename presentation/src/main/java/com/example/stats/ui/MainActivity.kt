package com.example.stats.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.stats.R
import com.example.stats.adapter.MainAdapter
import com.example.stats.databinding.ActivityMainBinding
import com.example.stats.model.PageModel
import com.example.stats.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel : MainViewModel by viewModel()
    lateinit var binding : ActivityMainBinding

    private lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.vm = viewModel
        binding.lifecycleOwner = this
        setContentView(binding.root)

        recyclerView = findViewById(R.id.recycler_view)
        viewModel.getAllPlayer(PageModel(1,10,null))
        successEvent()
    }
    fun successEvent(){
        viewModel.successEvent.observe(this,{
            println("실행")
            val mainAdapter = MainAdapter(viewModel.basicModel)
            recyclerView.adapter = mainAdapter
            recyclerView.layoutManager = LinearLayoutManager(recyclerView.context,LinearLayoutManager.VERTICAL,false)
            mainAdapter.notifyDataSetChanged()
        })
    }

}