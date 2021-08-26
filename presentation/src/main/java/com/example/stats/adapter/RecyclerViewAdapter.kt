package com.example.stats.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.stats.R
import com.example.stats.model.BasicModel
import com.example.stats.ui.PlayerDetailActivity

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.BindingViewHolder>() {

    private val items = arrayListOf<RecyclerItem>()

    private lateinit var playerInfo: RecyclerItem

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return getItems(position).layoutId
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
        onClick(holder.itemView, position)
        getItems(position).bind(holder.binding)
        holder.binding.executePendingBindings()

    }

    private fun onClick(view: View, position: Int) {
        view.setOnClickListener {
            if (items[position].layoutId == R.layout.item_player) {
                playerInfo = getItems(position)
                val intent = Intent(view.context, PlayerDetailActivity::class.java)
                intent.putExtra("data", playerInfo.data as BasicModel)
                    .run { view.context.startActivity(intent) }
            }
        }
    }

    fun clearData() {
        this.items.clear()
        notifyDataSetChanged()
    }
    fun changeData(newItems : List<RecyclerItem>){
        this.items.clear()
        this.items.addAll(newItems)
        notifyDataSetChanged()
    }

    fun addData(newItems: List<RecyclerItem>) {
        this.items.addAll(newItems)
        notifyDataSetChanged()
    }

    private fun getItems(position: Int): RecyclerItem {
        return items[position]
    }

    inner class BindingViewHolder(
        val binding: ViewDataBinding
    ) : RecyclerView.ViewHolder(binding.root)

}

