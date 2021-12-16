package com.example.stats.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.fragment.app.viewModels
import com.example.stats.R
import com.example.stats.base.BaseFragment
import com.example.stats.databinding.FragmentTeamBinding
import com.example.stats.viewmodel.TeamViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.time.LocalDate

@AndroidEntryPoint
class TeamFragment : BaseFragment<FragmentTeamBinding,TeamViewModel>() {

    override val viewModel : TeamViewModel by viewModels()
    override val layoutId = R.layout.fragment_team

    @RequiresApi(Build.VERSION_CODES.O)
    var teamYear = LocalDate.now().year

    override fun init() {
        viewModel.getTeamList()
        setYear(teamYear)
        binding.plusYearBtn.setOnClickListener {
            teamYear++
            setYear(teamYear)
        }

        binding.minusYearBtn.setOnClickListener {
            teamYear--
            setYear(teamYear)
        }

        viewModel.getGameResult("2021 - 2022")
    }

    private fun setYear(year : Int) {
        binding.teamYearTv.text =  "$year - ${year+1}"
    }

}