package com.example.myweather.ui.state

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.example.myweather.R

data class WeatherConditionState (
    val description: String,
    val painter: Painter,
)