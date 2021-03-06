package com.example.stats.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entity.TeamBasicInfo
import com.example.stats.R
import com.example.stats.model.*
import com.example.stats.ui.GameStatsDetailActivity
import com.example.stats.ui.PlayerDetailActivity
import com.example.stats.ui.StatsActivity
import com.example.stats.ui.TeamGameListActivity
import com.example.stats.viewmodel.TeamGameListViewModel

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.BindingViewHolder>() {

    private val items = arrayListOf<RecyclerItem>()

    private lateinit var recyclerItem: RecyclerItem

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
            when (items[position].layoutId) {
                R.layout.item_player -> {
                    recyclerItem = getItems(position)
                    val intent = Intent(view.context, PlayerDetailActivity::class.java)
                    intent.putExtra("data", recyclerItem.data as BasicModel)
                    view.context.startActivity(intent)
                }
                R.layout.item_game_list -> {
                    recyclerItem = getItems(position)
                    val data = recyclerItem.data as GamesModel
                    if(data.period != 0 && data.homeTeamScore != "0"){
                        val intent = Intent(view.context, StatsActivity::class.java)
                        intent.putExtra("gameData", recyclerItem.data as GamesModel)
                        view.context.startActivity(intent)
                    }



                }
                R.layout.item_game_player -> {
                    recyclerItem = getItems(position)
                    val intent = Intent(view.context, GameStatsDetailActivity::class.java)
                    intent.putExtra("statsData", recyclerItem.data as StatsModel)
                    view.context.startActivity(intent)
                }
                R.layout.item_team -> {
                    recyclerItem = getItems(position)
                    val intent = Intent(view.context, TeamGameListActivity::class.java)
                    intent.putExtra("teamData", recyclerItem.data as GameResultModel)
                    view.context.startActivity(intent)
                }
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun clearData() {
        this.items.clear()
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")

    fun changeData(newItems: List<RecyclerItem>) {
        this.items.clear()
        this.items.addAll(newItems)
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addData(newItems: List<RecyclerItem>) {
        this.items.addAll(newItems)
        notifyDataSetChanged()
    }

    private fun getItems(position: Int): RecyclerItem {
        return items[position]
    }

    inner class BindingViewHolder(
        val binding: ViewDataBinding,
    ) : RecyclerView.ViewHolder(binding.root)
}

