package com.example.myweather.logic.entites

data class Hourly(
    val time: String,
    val temperature: Double,
    val weatherCode: Int
)