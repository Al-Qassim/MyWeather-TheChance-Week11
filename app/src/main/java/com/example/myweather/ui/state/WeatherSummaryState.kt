package com.example.myweather.ui.state

data class WeatherSummaryState (
    val city: String,
    val weatherConditionState: WeatherConditionState,
    val currentTemperature: Int,
    val maxTemperature: Int,
    val minTemperature: Int,
)