package com.example.stats.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.stats.R
import com.example.stats.databinding.FragmentSearchPlayerBinding
import com.example.stats.model.PageModel
import com.example.stats.viewmodel.SearchPlayerViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel



class SearchPlayerFragment : Fragment() {

    val viewModel : SearchPlayerViewModel by viewModel()
    lateinit var binding : FragmentSearchPlayerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_search_player,container,false)
        binding.vm = viewModel
        binding.lifecycleOwner = this

        getAllPlayer()
        scrollListenerEvent()
        search()

        return binding.root
    }

    private fun search(){

        viewModel.searchEvent.observe(this,{
            getAllPlayer()
        })
    }

    private fun scrollListenerEvent(){
        viewModel.scrollListenerEvent.observe(this,{
            getAllPlayer()
        })
    }

    private fun getAllPlayer(){
        val text = binding.searchEdittext.text.toString()
        viewModel.getAllPlayer(PageModel(viewModel.page,15,text))
        println("$text asdf")
    }

}

