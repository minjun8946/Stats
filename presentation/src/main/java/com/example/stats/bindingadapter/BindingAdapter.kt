package com.example.stats.bindingadapter

import android.content.Intent
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintLayoutStates
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.stats.adapter.RecyclerViewAdapter
import com.example.stats.base.SingleLiveEvent


@BindingAdapter("recyclerView")
fun RecyclerView.setRecyclerAdapter(adapter: RecyclerViewAdapter) {
        if (this.adapter == null) {
                this.adapter = adapter
                layoutManager = LinearLayoutManager(context)
        }
}

@BindingAdapter("scrollListener")
fun RecyclerView.scrollListener(scrollListener : SingleLiveEvent<Unit>){
        addOnScrollListener(object : RecyclerView.OnScrollListener(){
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                        super.onScrolled(recyclerView, dx, dy)
                        if(!recyclerView.canScrollVertically(1)){
                                scrollListener.setValue(Unit)
                        }
                }
        })
}


@BindingAdapter("viewpager")
fun ViewPager2.viewPager(recyclerAdapter : RecyclerViewAdapter){
        adapter = recyclerAdapter

}