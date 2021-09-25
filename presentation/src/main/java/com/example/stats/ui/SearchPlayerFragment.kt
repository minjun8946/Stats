package com.example.stats.ui

import com.example.stats.R
import com.example.stats.base.BaseFragment
import com.example.stats.databinding.FragmentSearchPlayerBinding
import com.example.stats.model.PageModel
import com.example.stats.viewmodel.SearchPlayerViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class SearchPlayerFragment : BaseFragment<FragmentSearchPlayerBinding, SearchPlayerViewModel>() {

    override val viewModel: SearchPlayerViewModel by viewModel()
    override val layoutId = R.layout.fragment_search_player

    override fun init() {
        getAllPlayer()
        scrollListenerEvent()
        search()
    }



    private fun search() {
        viewModel.searchEvent.observe(this, {
            getAllPlayer()
        })
    }

    private fun scrollListenerEvent() {
        viewModel.scrollListenerEvent.observe(this, {
            getAllPlayer()
        })
    }



    private fun getAllPlayer() {
        val text = binding.searchEdittext.text.toString()
        viewModel.getAllPlayer(PageModel(viewModel.page, 15, text))
    }
}

