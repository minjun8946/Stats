package com.example.stats.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.stats.R
import com.example.stats.base.SingleLiveEvent
import com.example.stats.databinding.ActivityMainBinding
import com.example.stats.model.PageModel
import com.example.stats.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel : MainViewModel by viewModel()
    private lateinit var binding : ActivityMainBinding

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchEditText : EditText

    private var searchText =""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.vm = viewModel
        binding.lifecycleOwner = this
        setContentView(binding.root)

        searchEditText = findViewById(R.id.search_edittext)
        recyclerView = findViewById(R.id.recycler_view)

        getAllPlayer()
        successEvent()
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

    private fun successEvent(){
        viewModel.successEvent.observe(this,{
            println("실행")
        })
    }

    private fun getAllPlayer(){
        viewModel.getAllPlayer(PageModel(viewModel.page,15,searchText))
    }

    fun <T> singleLiveEvent(event : SingleLiveEvent<T>) {
        event.observe(this,{

        })
    }


}