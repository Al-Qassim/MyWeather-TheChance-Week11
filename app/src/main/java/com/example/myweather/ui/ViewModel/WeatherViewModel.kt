package com.example.myweather.ui.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myweather.logic.GetWeatherUseCase
import com.example.myweather.ui.state.WeatherUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class WeatherViewModel(
    val getWeatherUseCase: GetWeatherUseCase
) : ViewModel() {

    private val _weatherUiState = MutableStateFlow<WeatherUiState>(WeatherUiState.Loading)
    val weatherUiState = _weatherUiState.asStateFlow()

    init {
        fetchWeatherData()
    }

    fun fetchWeatherData() {
        viewModelScope.launch {
            try {
                _weatherUiState.value = WeatherUiState.Loading

                val weatherData = getWeatherUseCase.getWeather()
                _weatherUiState.value = WeatherUiState.Success(weatherData)

            } catch (e: Exception) {
                _weatherUiState.value = WeatherUiState.Error(e.message ?: "Unknown error")
            }
        }
    }
}