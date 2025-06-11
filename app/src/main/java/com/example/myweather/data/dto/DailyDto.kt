package com.example.myweather.data.dto

import android.annotation.SuppressLint
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@SuppressLint("UnsafeOptInUsageError")
@Serializable
data class DailyDto(
    val time: List<String>,
    @SerialName("temperature_2m_max")
    val mixTemperature: List<Double>,
    @SerialName("temperature_2m_min")
    val minTemperature: List<Double>,
    @SerialName("weather_code")
    val weatherCode: List<Int>
)
