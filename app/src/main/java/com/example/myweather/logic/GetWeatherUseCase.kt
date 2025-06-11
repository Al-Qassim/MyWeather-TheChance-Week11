package com.example.myweather.logic

import com.example.myweather.logic.Repository.LocationRepository
import com.example.myweather.logic.Repository.WeatherRepository
import com.example.myweather.logic.entites.Weather

class GetWeatherUseCase(
    private val weatherRepository: WeatherRepository,
    private val locationRepository: LocationRepository
) {
    suspend fun getWeather(): Weather {
        val location = locationRepository.getLocation()
        return weatherRepository.getWeather(location)
    }
}