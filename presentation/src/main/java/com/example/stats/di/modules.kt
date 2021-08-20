package com.example.stats.di

import com.example.data.datasource.StatsDataSource
import com.example.data.datasource.StatsDataSourceImpl
import com.example.data.remote.ApiService
import com.example.data.repository.StatsRepositoryImpl
import com.example.domain.repository.StatsRepository
import com.example.domain.service.StatsService
import com.example.domain.service.StatsServiceImpl
import com.example.domain.usecase.GetAllPlayerUseCase
import com.example.domain.usecase.GetPlayerSeasonAveragesUseCase
import com.example.stats.adapter.MainAdapter
import com.example.stats.viewmodel.MainViewModel
import com.example.stats.viewmodel.PlayerDetailViewModel
import com.example.stats.viewmodel.SearchPlayerViewModel
import com.example.stats.viewmodel.TeamViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val modules = module {


    single {
        Retrofit.Builder()
            .baseUrl("https://www.balldontlie.io/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    single<ApiService> { get<Retrofit>().create(ApiService::class.java) }

    //adapter
    single { MainAdapter(get()) }

    //DataSource
    single <StatsDataSource>{ StatsDataSourceImpl(get()) }

    //Repository
    single<StatsRepository>{ StatsRepositoryImpl(get()) }

    //Service
    single <StatsService>{ StatsServiceImpl(get()) }

    //UseCase
    single { GetAllPlayerUseCase(get()) }
    single { GetPlayerSeasonAveragesUseCase(get()) }

    //ViewModel
    viewModel { MainViewModel() }
    viewModel { PlayerDetailViewModel(get()) }
    viewModel { SearchPlayerViewModel(get()) }
    viewModel { TeamViewModel() }
}