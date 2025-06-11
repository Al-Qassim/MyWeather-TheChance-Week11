package com.example.myweather.di

import com.example.myweather.data.LocationRepositoryImpl
import com.example.myweather.data.WeatherRepositoryImpl
import com.example.myweather.logic.GetWeatherUseCase
import com.example.myweather.logic.Repository.LocationRepository
import com.example.myweather.logic.Repository.WeatherRepository
import com.example.myweather.ui.ViewModel.WeatherViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val dependencies = module {
    single<WeatherRepository> { WeatherRepositoryImpl() }
    single<LocationRepository> { LocationRepositoryImpl(androidContext()) }
    single{ GetWeatherUseCase(get(), get()) }
    single{ WeatherViewModel(get()) }
}