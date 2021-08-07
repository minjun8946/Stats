package com.example.stats.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.stats.databinding.ItemInfoBinding
import com.example.stats.model.BasicModel


class MainAdapter(val items : List<BasicModel>) : RecyclerView.Adapter<MainAdapter.BindingViewHolder>() {

    inner class BindingViewHolder(val binding : ItemInfoBinding)
        : RecyclerView.ViewHolder(binding.root){
        fun bind(position : Int){
            println("${items[position].firstName} 가나다라")
            binding.repo = getItems(position)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemInfoBinding.inflate(inflater, parent, false)
        return BindingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BindingViewHolder, position: Int) {
        holder.binding.executePendingBindings()
        holder.bind(position)

    }

    override fun getItemCount(): Int = items.size

    private fun getItems(position : Int) = items[position]
}


