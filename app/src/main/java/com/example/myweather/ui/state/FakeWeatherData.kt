package com.example.myweather.ui.state

import androidx.compose.runtime.Composable
import com.example.myweather.ui.theme.MyWeatherTheme

@Composable
fun getFakeWeatherState(isDay: Boolean = true): WeatherState {
    MyWeatherTheme.setTheme(isDay = isDay)
    return WeatherState(
        weatherSummaryState = WeatherSummaryState(
            city = "California",
            weatherConditionState = wmoCodeToWeatherConditionState(1),
            currentTemperature = 10,
            maxTemperature = 20,
            minTemperature = 10
        ),
        currentWeatherDetailsState = CurrentWeatherDetailsState(
            windSpeed = 4,
            humidity = 93,
            rain = 0,
            uvIndex = 0,
            pressure = 1013,
            temperature = 10,
            isDay = isDay
        ),
        hourlyForecastStates = listOf(
            HourlyForecastState(
                temperature = "12",
                time = "00:00",
                weatherConditionState = wmoCodeToWeatherConditionState(1),
            ),
            HourlyForecastState(
                temperature = "13",
                time = "01:00",
                weatherConditionState = wmoCodeToWeatherConditionState(2),
            ),
            HourlyForecastState(
                temperature = "14",
                time = "02:00",
                weatherConditionState = wmoCodeToWeatherConditionState(3),
            ),
            HourlyForecastState(
                temperature = "13",
                time = "03:00",
                weatherConditionState = wmoCodeToWeatherConditionState(2),
            ),
            HourlyForecastState(
                temperature = "12",
                time = "04:00",
                weatherConditionState = wmoCodeToWeatherConditionState(1),
            ),
            HourlyForecastState(
                temperature = "11",
                time = "05:00",
                weatherConditionState = wmoCodeToWeatherConditionState(0),
            ),
        ),
        dailyForecastState = listOf(
            DailyForecastState(
                dayName = "Sunday",
                maxTemperature = 42,
                minTemperature = 30,
                weatherConditionState = wmoCodeToWeatherConditionState(1),
            ),
            DailyForecastState(
                dayName = "Monday",
                maxTemperature = 42,
                minTemperature = 30,
                weatherConditionState = wmoCodeToWeatherConditionState(2),
            ),
            DailyForecastState(
                dayName = "Tuesday",
                maxTemperature = 42,
                minTemperature = 30,
                weatherConditionState = wmoCodeToWeatherConditionState(0),
            ),
            DailyForecastState(
                dayName = "Wednesday",
                maxTemperature = 42,
                minTemperature = 30,
                weatherConditionState = wmoCodeToWeatherConditionState(51),
            ),
            DailyForecastState(
                dayName = "Thursday",
                maxTemperature = 42,
                minTemperature = 30,
                weatherConditionState = wmoCodeToWeatherConditionState(65),
            ),
            DailyForecastState(
                dayName = "Friday",
                maxTemperature = 42,
                minTemperature = 30,
                weatherConditionState = wmoCodeToWeatherConditionState(1),
            ),
            DailyForecastState(
                dayName = "Saturday",
                maxTemperature = 42,
                minTemperature = 30,
                weatherConditionState = wmoCodeToWeatherConditionState(1),
            ),
        )
    )
}