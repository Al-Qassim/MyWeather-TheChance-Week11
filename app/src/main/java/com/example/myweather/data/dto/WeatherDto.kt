package com.example.myweather.data.dto

import android.annotation.SuppressLint
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@SuppressLint("UnsafeOptInUsageError")
@Serializable
data class WeatherDto (
    val latitude: Double,
    val longitude: Double,
    @SerialName("current_units")
    val currentUnits: CurrentUnitsDto,
    val current: CurrentDto,
    @SerialName("hourly_units")
    val hourlyUnits: HourlyUnitsDto,
    val hourly: HourlyDto,
    @SerialName("daily_units")
    val dailyUnits: DailyUnitsDto,
    val daily: DailyDto
)



