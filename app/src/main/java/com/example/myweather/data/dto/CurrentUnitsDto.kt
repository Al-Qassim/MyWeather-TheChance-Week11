package com.example.myweather.data.dto

import android.annotation.SuppressLint
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@SuppressLint("UnsafeOptInUsageError")
@Serializable
data class CurrentUnitsDto (
    val time: String,
    @SerialName("temperature_2m")
    val temperature: String,
    @SerialName("relative_humidity_2m")
    val humidity: String,
    @SerialName("uv_index")
    val uvIndex: String,
    @SerialName("is_day")
    val isDay: String,
    val rain: String,
    @SerialName("weather_code")
    val weatherCode: String,
    @SerialName("surface_pressure")
    val pressure: String,
    @SerialName("wind_speed_10m")
    val windSpeed: String
)