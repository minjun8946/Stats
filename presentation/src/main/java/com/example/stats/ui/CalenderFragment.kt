package com.example.stats.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.fragment.app.viewModels
import com.example.stats.R
import com.example.stats.base.BaseFragment
import com.example.stats.databinding.FragmentCalenderBinding
import com.example.stats.model.DateModel
import com.example.stats.viewmodel.CalenderViewModel
import com.prolificinteractive.materialcalendarview.CalendarDay
import dagger.hilt.android.AndroidEntryPoint
import org.threeten.bp.LocalDate

@AndroidEntryPoint
class CalenderFragment : BaseFragment<FragmentCalenderBinding, CalenderViewModel>() {

    override val viewModel: CalenderViewModel by viewModels()
    override val layoutId = R.layout.fragment_calender
    var koreaTime: LocalDate = LocalDate.now()

    override fun init() {
        onCalenderClick()
        binding.reloadBtn.setOnClickListener {
            getDayGameData()
        }
        defaultDay()
        reload()
    }

    private fun defaultDay(){
        binding.cvCalendar.selectedDate = CalendarDay.today()
        koreaTime = koreaTime.minusDays(1)
        getDayGameData()
    }

    private fun onCalenderClick() {
        binding.cvCalendar.setOnDateChangedListener { widget, date, selected ->
            koreaTime = date.date.minusDays(1)
            getDayGameData()
        }
    }

    private fun reload(){
        binding.reloadBtn.setOnClickListener {
            getDayGameData()
        }
    }

    private fun getDayGameData() {
        viewModel.getGamesData(
            DateModel(
                koreaTime.toString(),
                null,
                null,
                0,
                100
            )
        )
    }

}