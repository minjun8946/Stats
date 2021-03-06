package com.example.stats.bindingadapter

import android.widget.ImageView
import androidx.core.view.isNotEmpty
import androidx.core.view.size
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.stats.adapter.RecyclerViewAdapter
import com.example.stats.base.SingleLiveEvent
import com.example.stats.base.teamImage


@BindingAdapter("recyclerView")
fun RecyclerView.setRecyclerAdapter(adapter: RecyclerViewAdapter) {
    this.adapter = adapter
    layoutManager = LinearLayoutManager(context)
}

@BindingAdapter("imageBinding")
fun ImageView.imageBinding(resId: Int) {
    val imageId = teamImage(resId)
    setImageResource(imageId)
}

@BindingAdapter("scrollListener")
fun RecyclerView.scrollListener(scrollListener: SingleLiveEvent<Unit>) {
    addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            if (!recyclerView.canScrollVertically(1)) {
                if(recyclerView.size > 6){
                    scrollListener.setValue(Unit)
                }
            }
        }
    })
}

@BindingAdapter("viewpager")
fun ViewPager2.viewPager(recyclerAdapter: RecyclerViewAdapter) {
    adapter = recyclerAdapter
}