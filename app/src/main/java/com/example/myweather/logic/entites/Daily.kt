package com.example.myweather.logic.entites

data class Daily(
    val time: String,
    val maxTemperature: Double,
    val minTemperature: Double,
    val weatherCode: Int
)
