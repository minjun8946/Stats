package com.example.stats.bindingadapter

import android.widget.LinearLayout
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.stats.adapter.MainAdapter


@BindingAdapter("recyclerView")
fun recyclerView(recyclerView: RecyclerView, adapter: MainAdapter) {
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context,LinearLayoutManager.VERTICAL,false)
        adapter.notifyDataSetChanged()
}