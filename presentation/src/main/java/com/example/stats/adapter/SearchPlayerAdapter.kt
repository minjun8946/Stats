package com.example.stats.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.stats.base.SingleLiveEvent
import com.example.stats.databinding.ItemInfoBinding
import com.example.stats.model.BasicModel
import com.example.stats.ui.PlayerDetailActivity


class SearchPlayerAdapter : RecyclerView.Adapter<SearchPlayerAdapter.BindingViewHolder>() {

    private var items = arrayListOf<BasicModel>()

    lateinit var playerInfo : BasicModel


    inner class BindingViewHolder(val binding : ItemInfoBinding)
        : RecyclerView.ViewHolder(binding.root){
        fun bind(position : Int){
            binding.repo = getItems(position)

            itemView.setOnClickListener {
                playerInfo = getItems(position)
                val intent = Intent(itemView.context,PlayerDetailActivity::class.java)
                intent.putExtra("data",playerInfo).run { itemView.context.startActivity(this) }
            }
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

    fun clearData() {
        this.items.clear()
    }

    fun addData(newItems: ArrayList<BasicModel>){
        this.items.addAll(newItems)
        notifyDataSetChanged()
    }

    private fun getItems(position : Int) = items[position]
}


