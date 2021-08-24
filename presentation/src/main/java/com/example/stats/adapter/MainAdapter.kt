package com.example.stats.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.stats.ui.CalenderFragment
import com.example.stats.ui.SearchPlayerFragment
import com.example.stats.ui.TeamFragment

class MainAdapter (fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    private val searchPlayerFragment = SearchPlayerFragment()
    private val teamFragment  = TeamFragment()
    private val calenderFragment = CalenderFragment()

    companion object {
        // 페이지 개수를 정적 변수로 선언
        private const val NUM_PAGES = 3
    }

    override fun getItemCount(): Int {
        return NUM_PAGES
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> searchPlayerFragment
            1 -> teamFragment
            else ->calenderFragment
        }
    }

}