package com.example.stats.bindingadapter

import android.widget.LinearLayout
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.stats.adapter.MainAdapter


@BindingAdapter("viewpagerAdapter")
fun ViewPager2.connectAdapter(adapter : MainAdapter){
    if(this.adapter != null){
        this.adapter = adapter
        this.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    }
}