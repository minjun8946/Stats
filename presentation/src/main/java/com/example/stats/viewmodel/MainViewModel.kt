package com.example.stats.viewmodel


import androidx.lifecycle.ViewModel
import com.example.domain.base.Result
import com.example.domain.entity.PlayerSeasonAveragesInfo
import com.example.domain.entity.StatsBasicInfo
import com.example.domain.usecase.GetAllPlayerUseCase
import com.example.domain.usecase.GetPlayerSeasonAveragesUseCase
import com.example.stats.adapter.MainAdapter
import com.example.stats.base.BaseViewModel
import com.example.stats.base.SingleLiveEvent
import com.example.stats.model.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class MainViewModel : ViewModel(){

}