package com.example.stats.di

import com.example.data.datasource.*
import com.example.data.remote.ApiService
import com.example.data.repository.GamesRepositoryImpl
import com.example.data.repository.PlayerRepositoryImpl
import com.example.data.repository.TeamRepositoryImpl
import com.example.domain.repository.GamesRepository
import com.example.domain.repository.PlayerRepository
import com.example.domain.repository.TeamRepository
import com.example.domain.service.*
import com.example.domain.usecase.GetAllPlayerUseCase
import com.example.domain.usecase.GetGamesDataUseCase
import com.example.domain.usecase.GetPlayerSeasonAveragesUseCase
import com.example.domain.usecase.GetTeamListUseCase
import com.example.stats.adapter.MainAdapter
import com.example.stats.adapter.RecyclerViewAdapter
import com.example.stats.viewmodel.*
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
    single { RecyclerViewAdapter() }

    //DataSource
    single <PlayerDataSource>{ PlayerDataSourceImpl(get()) }
    single <TeamDataSource>{ TeamDataSourceImpl(get()) }
    single <GamesDataSource>{ GamesDataSourceImpl(get()) }

    //Repository
    single<PlayerRepository>{ PlayerRepositoryImpl(get()) }
    single<TeamRepository>{ TeamRepositoryImpl(get()) }
    single<GamesRepository>{ GamesRepositoryImpl(get()) }

    //Service
    single <PlayerService>{ PlayerServiceImpl(get()) }
    single <TeamService>{ TeamServiceImpl(get()) }
    single <GamesService>{ GamesServiceImpl(get()) }

    //UseCase
    single { GetAllPlayerUseCase(get()) }
    single { GetPlayerSeasonAveragesUseCase(get()) }
    single { GetTeamListUseCase(get()) }
    single { GetGamesDataUseCase(get()) }

    //ViewModel
    viewModel { MainViewModel() }
    viewModel { PlayerDetailViewModel(get()) }
    viewModel { SearchPlayerViewModel(get()) }
    viewModel { TeamViewModel(get()) }
    viewModel { CalenderViewModel(get()) }
}