package com.example.myweather.ui.state

import androidx.compose.runtime.Composable
import com.example.myweather.logic.entites.Hourly

data class HourlyForecastState (
    val temperature: String,
    val time: String,
    val weatherConditionState: WeatherConditionState,
)