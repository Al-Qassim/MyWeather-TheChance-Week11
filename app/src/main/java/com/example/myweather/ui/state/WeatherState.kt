package com.example.myweather.ui.state

data class WeatherState (
    val weatherSummaryState: WeatherSummaryState,
    val currentWeatherDetailsState: CurrentWeatherDetailsState,
    val hourlyForecastStates: List<HourlyForecastState>,
    val dailyForecastState: List<DailyForecastState>,
)