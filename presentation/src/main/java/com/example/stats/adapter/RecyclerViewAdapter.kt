package com.example.stats.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter : RecyclerView.Adapter<BindingViewHolder>() {

    val items = arrayListOf<RecyclerItem>()

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).layoutId
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BindingViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding = DataBindingUtil.inflate(inflater, viewType, parent, false)
        return BindingViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: BindingViewHolder,
        position: Int
    ) {
        getItem(position).bind(holder.binding)
        holder.binding.executePendingBindings()
    }

    fun clearData() {
        this.items.clear()
        notifyDataSetChanged()
    }

    fun addData(newItems: List<RecyclerItem>) {
        this.items.addAll(newItems)
        notifyDataSetChanged()
    }

    private fun getItem(position: Int): RecyclerItem {
        return items[position]
    }

}

class BindingViewHolder(
    val binding: ViewDataBinding
) : RecyclerView.ViewHolder(binding.root)