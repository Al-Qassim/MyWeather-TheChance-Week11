package com.example.myweather.logic.entites

data class CurrentUnits (
    val time: String,
    val temperature: String,
    val humidity: String,
    val uvIndex: String,
    val isDay: String,
    val rain: String,
    val weatherCode: String,
    val pressure: String,
    val windSpeed: String
)