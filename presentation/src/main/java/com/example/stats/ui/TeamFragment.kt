package com.example.stats.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.fragment.app.viewModels
import com.example.stats.R
import com.example.stats.base.BaseFragment
import com.example.stats.databinding.FragmentTeamBinding
import com.example.stats.model.DateModel
import com.example.stats.viewmodel.TeamViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.time.LocalDate

@AndroidEntryPoint
class TeamFragment : BaseFragment<FragmentTeamBinding,TeamViewModel>() {

    override val viewModel : TeamViewModel by viewModels()
    override val layoutId = R.layout.fragment_team

    @RequiresApi(Build.VERSION_CODES.O)
    var year = LocalDate.now().year

    override fun init() {
        viewModel.getTeamList()
        getGameData()
        binding.plusYearBtn.setOnClickListener {
            year++
            setYear()
            getGameData()

        }

        binding.minusYearBtn.setOnClickListener {
            year--
            setYear()
            getGameData()
        }

        viewModel.getGameResult(setYear())
    }

    private fun getGameData(){
        viewModel.checkRoomData("${year-1} - $year")
        viewModel.sizeEvent.observe(this,{
            if(it == 0){
                for(i in it..17){
                    println("숫자 $it")
                    viewModel.getGameData(DateModel(null, year-1, null,false, i, 100))
                }
            }

        })
        viewModel.getGameResult(setYear())
    }

    private fun setYear()  : String{
        binding.teamYearTv.text =  "$year - ${year+1}"
        return "$year - ${year+1}"
    }

}