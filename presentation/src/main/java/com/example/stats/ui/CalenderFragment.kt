package com.example.stats.ui

import com.example.stats.R
import com.example.stats.base.BaseFragment
import com.example.stats.databinding.FragmentCalenderBinding
import com.example.stats.model.DateModel
import com.example.stats.viewmodel.CalenderViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CalenderFragment : BaseFragment<FragmentCalenderBinding, CalenderViewModel>() {

    override val viewModel: CalenderViewModel by viewModel()
    override val layoutId = R.layout.fragment_calender

    override fun init() {
        onCalenderClick()
    }

    private fun onCalenderClick() {
        binding.cvCalendar.setOnDateChangedListener { widget, date, selected ->
            val koreaTime = date.date.minusDays(1)
            viewModel.getGamesData(DateModel("${koreaTime.year}-${koreaTime.month.value}-${date.day - 1}",null,null,0,100))
        }
    }

}