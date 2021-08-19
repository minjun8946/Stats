package com.example.stats.bindingadapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.stats.adapter.MainAdapter
import com.example.stats.adapter.PlayerDetailAdapter
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

@BindingAdapter("viewpager")
fun viewPager(viewPager2: ViewPager2,adapter : PlayerDetailAdapter){
        viewPager2.adapter = adapter
        viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL
}