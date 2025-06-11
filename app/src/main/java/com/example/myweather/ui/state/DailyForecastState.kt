package com.example.myweather.ui.state

data class DailyForecastState(
    val dayName: String,
    val maxTemperature: Int,
    val minTemperature: Int,
    val weatherConditionState: WeatherConditionState,
)