package com.example.myweather.ui.theme

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.core.app.ComponentActivity
import androidx.core.view.WindowInsetsControllerCompat
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
    @Composable
    fun SetTheme(isDay: Boolean){
        colors = if (isDay) lightWeatherColorScheme else darkWeatherColorScheme
        this.isDay = isDay
        SetStatusBarIconColor(isDay)
    }
}

@Composable
fun MyWeatherTheme(
    isDay: Boolean = true,
    content: @Composable () -> Unit
) {
    MyWeatherTheme.SetTheme(isDay = isDay)
    content()
}

@SuppressLint("RestrictedApi")
@Composable
fun SetStatusBarIconColor(isDarkIcons: Boolean) {
    val view = LocalView.current
    val window = (view.context as? ComponentActivity)?.window ?: return
    val insetsController = WindowInsetsControllerCompat(window, view)
    insetsController.isAppearanceLightStatusBars = isDarkIcons
}
