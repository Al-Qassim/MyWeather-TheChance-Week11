package com.example.myweather.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import kotlin.properties.Delegates

data class WeatherColorScheme(
    val primary: Color,
    val backgrounds: List<Color>,
    val variantColor: Color,
    val surface: Color,
    val surfaceTransparent87: Color,
    val surfaceTransparent70: Color,
    val surfaceTransparent60: Color,
    val surfaceTransparent8: Color,
    val oppositeColor: Color,
    val oppositeColorTransparent87: Color,
    val oppositeColorTransparent70: Color,
    val oppositeColorTransparent60: Color,
    val oppositeColorTransparent8: Color,
)

val lightWeatherColorScheme = WeatherColorScheme(
    LightBlue,
    listOf(LightBlue, White),
    DarkGray,
    White,
    WhiteTransparent87,
    WhiteTransparent70,
    WhiteTransparent60,
    WhiteTransparent8,
    Black,
    BlackTransparent87,
    BlackTransparent70,
    BlackTransparent60,
    BlackTransparent8,
)

val darkWeatherColorScheme = WeatherColorScheme(
    LightBlue,
    listOf(Black, Black),
    White,
    Black,
    BlackTransparent87,
    BlackTransparent70,
    BlackTransparent60,
    BlackTransparent8,
    White,
    WhiteTransparent87,
    WhiteTransparent70,
    WhiteTransparent60,
    WhiteTransparent8,
)

object MyWeatherTheme {
    var colors: WeatherColorScheme = lightWeatherColorScheme
    var isDay by Delegates.notNull<Boolean>()
    fun setTheme(isDay: Boolean){
        colors = if (isDay) lightWeatherColorScheme else darkWeatherColorScheme
        this.isDay = isDay
    }
}

@Composable
fun MyWeatherTheme(
    isDay: Boolean = true,
    content: @Composable () -> Unit
) {
    MyWeatherTheme.setTheme(isDay = isDay)
    content()
}
