package com.example.myweather.data.dto

import android.annotation.SuppressLint
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@SuppressLint("UnsafeOptInUsageError")
@Serializable
data class DailyUnitsDto(
    val time: String,
    @SerialName("temperature_2m_max")
    val mixTemperature: String,
    @SerialName("temperature_2m_min")
    val minTemperature: String,
    @SerialName("weather_code")
    val weatherCode: String
)
