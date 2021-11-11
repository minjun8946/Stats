package com.example.stats.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.fragment.app.viewModels
import com.example.stats.R
import com.example.stats.base.BaseFragment
import com.example.stats.databinding.FragmentCalenderBinding
import com.example.stats.model.DateModel
import com.example.stats.viewmodel.CalenderViewModel
import dagger.hilt.android.AndroidEntryPoint
import org.threeten.bp.LocalDate

@AndroidEntryPoint
class CalenderFragment : BaseFragment<FragmentCalenderBinding, CalenderViewModel>() {

    override val viewModel: CalenderViewModel by viewModels()
    override val layoutId = R.layout.fragment_calender
    var koreaTime: LocalDate = LocalDate.now()
    var day: Int? = null

    @RequiresApi(Build.VERSION_CODES.O)
    override fun init() {
        onCalenderClick()
        binding.reloadBtn.setOnClickListener {
            getDayGameData()
        }
    }
    private fun onCalenderClick() {
        binding.cvCalendar.setOnDateChangedListener { widget, date, selected ->
            koreaTime = date.date.minusDays(1)
            day = date.day
            getDayGameData()
        }
    }

    private fun getDayGameData() {
        if (day == null) return
        viewModel.getGamesData(
            DateModel(
                "${koreaTime.year}-${koreaTime.month.value}-${day!! - 1}",
                null,
                null,
                0,
                100
            )
        )
    }

}