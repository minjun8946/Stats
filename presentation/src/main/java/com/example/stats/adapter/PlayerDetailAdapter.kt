package com.example.stats.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.stats.databinding.ItemDetailPlayerBinding
import com.example.stats.model.BasicModel
import com.example.stats.model.PlayerSeasonAveragesModel

class PlayerDetailAdapter : RecyclerView.Adapter<PlayerDetailAdapter.PlayerBindingViewHolder>() {

    private val items = arrayListOf<PlayerSeasonAveragesModel>()

    inner class PlayerBindingViewHolder(val binding : ItemDetailPlayerBinding)
        : RecyclerView.ViewHolder(binding.root){
            fun bind(position: Int){
                binding.repo = getItems(position)
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerBindingViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemDetailPlayerBinding.inflate(inflater,parent,false)
        return PlayerBindingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlayerBindingViewHolder, position: Int) {
        holder.binding.executePendingBindings()
        holder.bind(position)
    }

    override fun getItemCount(): Int = items.size

    fun clearData() {
        this.items.clear()
    }

    fun addData(newItems: ArrayList<PlayerSeasonAveragesModel>){
        this.items.addAll(newItems)
        notifyDataSetChanged()
    }

    private fun getItems(position : Int) = items[position]
}