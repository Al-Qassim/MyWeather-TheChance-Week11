package com.example.myweather.ui.state

data class CurrentWeatherDetailsState (
    val windSpeed: Int,
    val humidity: Int,
    val rain: Int,
    val uvIndex: Int,
    val pressure: Int,
    val temperature: Int,
    val isDay: Boolean,
)

