package com.example.myweather.ui.state

import com.example.myweather.logic.entites.Weather

sealed class WeatherUiState {
    object Loading : WeatherUiState()
    data class Success(val data: Weather) : WeatherUiState()
    data class Error(val message: String) : WeatherUiState()
}