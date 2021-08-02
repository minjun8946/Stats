package com.example.stats.di

import com.example.data.datasource.StatsDataSource
import com.example.data.datasource.StatsDataSourceImpl
import com.example.data.remote.ApiService
import com.example.data.repository.StatsRepositoryImpl
import com.example.domain.repository.StatsRepository
import com.example.domain.service.StatsService
import com.example.domain.service.StatsServiceImpl
import com.example.domain.usecase.GetAllPlayerUseCase
import com.example.stats.base.BaseApi
import com.example.stats.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val modules = module {

    //DataSource
    single <StatsDataSource>{ StatsDataSourceImpl(get()) }

    //Repository
    single<StatsRepository>{ StatsRepositoryImpl(get()) }

    //Service
    single <StatsService>{ StatsServiceImpl(get()) }

    //UseCase
    single { GetAllPlayerUseCase(get()) }

    //BaseApi
    single { BaseApi() }

    //ViewModel
    viewModel { MainViewModel(get()) }
}