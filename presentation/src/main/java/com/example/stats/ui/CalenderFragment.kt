package com.example.stats.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.stats.R
import com.example.stats.databinding.FragmentCalenderBinding
import com.example.stats.model.DateModel
import com.example.stats.viewmodel.CalenderViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.time.LocalDate

class CalenderFragment : Fragment() {

    val viewModel: CalenderViewModel by viewModel()
    lateinit var binding: FragmentCalenderBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_calender, container, false)
        binding.lifecycleOwner = this
        binding.vm = viewModel

        binding.cvCalendar.setOnDateChangedListener { widget, date, selected ->
            val koreaTime = date.date.minusDays(1)
            viewModel.getGamesData(DateModel("${koreaTime.year}-${koreaTime.month.value}-${date.day-1}"))

            println("${koreaTime.year}-${koreaTime.month.value}-${date.day-1}")
        }

        return binding.root
    }
}