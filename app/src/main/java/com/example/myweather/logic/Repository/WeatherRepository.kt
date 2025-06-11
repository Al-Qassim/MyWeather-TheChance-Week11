package com.example.myweather.logic.Repository

import com.example.myweather.logic.entites.Location
import com.example.myweather.logic.entites.Weather

interface WeatherRepository {
    suspend fun getWeather(location: Location): Weather
}