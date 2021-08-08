package com.example.stats.bindingadapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.stats.adapter.MainAdapter
import com.example.stats.base.SingleLiveEvent


@BindingAdapter("recyclerView")
fun recyclerView(recyclerView: RecyclerView, adapter: MainAdapter) {
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context,LinearLayoutManager.VERTICAL,false)
}

@BindingAdapter("scrollListener")
fun scrollListener(recyclerView: RecyclerView, scrollListener : SingleLiveEvent<Unit>){
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener(){
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                        super.onScrolled(recyclerView, dx, dy)
                        if(!recyclerView.canScrollVertically(1)){
                                scrollListener.setValue(Unit)
                        }
                }
        })
}