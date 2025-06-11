package com.example.myweather.data.dto

import android.annotation.SuppressLint
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@SuppressLint("UnsafeOptInUsageError")
@Serializable
data class CurrentDto (
    val time: String,
    @SerialName("temperature_2m")
    val temperature: Double,
    @SerialName("relative_humidity_2m")
    val humidity: Int,
    @SerialName("uv_index")
    val uvIndex: Double,
    @SerialName("is_day")
    val isDay: Int,
    val rain: Double,
    @SerialName("weather_code")
    val weatherCode: Int,
    @SerialName("surface_pressure")
    val pressure: Double,
    @SerialName("wind_speed_10m")
    val windSpeed: Double
)