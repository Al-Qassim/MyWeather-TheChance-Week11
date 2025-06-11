package com.example.myweather.ui.state

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.myweather.R
import com.example.myweather.logic.entites.CurrentWeather
import com.example.myweather.logic.entites.Daily
import com.example.myweather.logic.entites.Hourly
import com.example.myweather.logic.entites.Weather
import com.example.myweather.ui.theme.MyWeatherTheme
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.math.roundToInt

fun CurrentWeather.toCurrentWeatherDetailsState(): CurrentWeatherDetailsState {
    return CurrentWeatherDetailsState(
        windSpeed = windSpeed.toInt(),
        humidity = humidity,
        rain = rain.toInt(),
        uvIndex = uvIndex.toInt(),
        pressure = pressure.toInt(),
        temperature = temperature.toInt(),
        isDay = isDay
    )
}




@Composable
fun wmoCodeToWeatherConditionState(wmoCode: Int): WeatherConditionState {
    val isDay = MyWeatherTheme.isDay
    return when (wmoCode) {
        0 -> WeatherConditionState("Clear sky", if (isDay) painterResource(R.drawable.clear_sky_day) else painterResource(R.drawable.clear_sky_night))
        1 -> WeatherConditionState("Mainly clear", if (isDay) painterResource(R.drawable.mainly_clear_day) else painterResource(R.drawable.mainly_clear_night))
        2 -> WeatherConditionState("Partly cloudy", if (isDay) painterResource(R.drawable.partly_cloudy_day) else painterResource(R.drawable.partly_cloudy_night))
        3 -> WeatherConditionState("Overcast", if (isDay) painterResource(R.drawable.overcast_day) else painterResource(R.drawable.overcast_night))
        45 -> WeatherConditionState("Fog", if (isDay) painterResource(R.drawable.fog_day) else painterResource(R.drawable.fog_night))
        48 -> WeatherConditionState("Depositing rime fog", if (isDay) painterResource(R.drawable.depositing_rime_fog_day) else painterResource(R.drawable.depositing_rime_fog_night))
        51 -> WeatherConditionState("Drizzle: Light intensity", if (isDay) painterResource(R.drawable.drizzle_light_day) else painterResource(R.drawable.drizzle_light_night))
        53 -> WeatherConditionState("Drizzle: Moderate intensity", if (isDay) painterResource(R.drawable.drizzle_moderate_day) else painterResource(R.drawable.drizzle_moderate_night))
        55 -> WeatherConditionState("Drizzle: Dense intensity", if (isDay) painterResource(R.drawable.drizzle_intensity_day) else painterResource(R.drawable.drizzle_intensity_night))
        56 -> WeatherConditionState("Freezing Drizzle: Light intensity", if (isDay) painterResource(R.drawable.freezing_drizzle_light_day) else painterResource(R.drawable.freezing_drizzle_light_night))
        57 -> WeatherConditionState("Freezing Drizzle: Dense intensity", if (isDay) painterResource(R.drawable.freezing_drizzle_intensity_day) else painterResource(R.drawable.freezing_drizzle_intensity_night))
        61 -> WeatherConditionState("Rain: Slight intensity", if (isDay) painterResource(R.drawable.rain_slight_day) else painterResource(R.drawable.rain_slight_night))
        63 -> WeatherConditionState("Rain: Moderate intensity", if (isDay) painterResource(R.drawable.rain_moderate_day) else painterResource(R.drawable.rain_moderate_night))
        65 -> WeatherConditionState("Rain: Heavy intensity", if (isDay) painterResource(R.drawable.rain_intensity_day) else painterResource(R.drawable.rain_intensity_night))
        66 -> WeatherConditionState("Freezing Rain: Light intensity", if (isDay) painterResource(R.drawable.freezing_light_day) else painterResource(R.drawable.freezing_light_night))
        67 -> WeatherConditionState("Freezing Rain: Heavy intensity", if (isDay) painterResource(R.drawable.freezing_heavy_day) else painterResource(R.drawable.freezing_heavy_night))
        71 -> WeatherConditionState("Snow fall: Slight intensity", if (isDay) painterResource(R.drawable.snow_fall_light_day) else painterResource(R.drawable.snow_fall_light_night))
        73 -> WeatherConditionState("Snow fall: Moderate intensity", if (isDay) painterResource(R.drawable.snow_fall_moderate_day) else painterResource(R.drawable.snow_fall_moderate_night))
        75 -> WeatherConditionState("Snow fall: Heavy intensity", if (isDay) painterResource(R.drawable.snow_fall_intensity_day) else painterResource(R.drawable.snow_fall_intensity_night))
        77 -> WeatherConditionState("Snow grains", if (isDay) painterResource(R.drawable.snow_grains_day) else painterResource(R.drawable.snow_grains_night))
        80 -> WeatherConditionState("Rain showers: Slight", if (isDay) painterResource(R.drawable.rain_shower_slight_day) else painterResource(R.drawable.rain_shower_slight_night))
        81 -> WeatherConditionState("Rain showers: Moderate", if (isDay) painterResource(R.drawable.rain_shower_moderate_day) else painterResource(R.drawable.rain_shower_moderate_night))
        82 -> WeatherConditionState("Rain showers: Violent", if (isDay) painterResource(R.drawable.rain_shower_violent_day) else painterResource(R.drawable.rain_shower_violent_night))
        85 -> WeatherConditionState("Snow showers: Slight", if (isDay) painterResource(R.drawable.snow_shower_slight_day) else painterResource(R.drawable.snow_shower_slight_night))
        86 -> WeatherConditionState("Snow showers: Heavy", if (isDay) painterResource(R.drawable.snow_shower_heavy_day) else painterResource(R.drawable.snow_shower_heavy_night))
        95 -> WeatherConditionState("Thunderstorm: Slight or moderate", if (isDay) painterResource(R.drawable.thunderstrom_slight_or_moderate_day) else painterResource(R.drawable.thunderstrom_slight_or_moderate_day))
        96 -> WeatherConditionState("Thunderstorm with slight hail", if (isDay) painterResource(R.drawable.thunderstrom_with_slight_hail_day) else painterResource(R.drawable.thunderstrom_with_slight_hail_day))
        99 -> WeatherConditionState("Thunderstorm with heavy hail", if (isDay) painterResource(R.drawable.thunderstrom_with_heavy_hail_day) else painterResource(R.drawable.thunderstrom_with_heavy_hail_day))
        else -> WeatherConditionState("Unknown", painterResource(R.drawable.empty_image))
    }
}

@Composable
fun Hourly.toHourlyForecastState(): HourlyForecastState {
    return HourlyForecastState(
        temperature = temperature.roundToInt().toString(),
        time = time.takeLast(5),
        weatherConditionState = wmoCodeToWeatherConditionState(weatherCode),
    )
}

@RequiresApi(Build.VERSION_CODES.O)
private fun getDayOfWeekFromDateTimeString(dateTimeString: String): String {
    return try {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val dateTime = LocalDate.parse(dateTimeString, formatter)
        val weekNameAllCapital = dateTime.dayOfWeek.name
        weekNameAllCapital.substring(0, 1).uppercase() + weekNameAllCapital.substring(1).lowercase()
    } catch (e: Exception) {
        Log.i("DailyForecastState", "Error parsing date: $dateTimeString, ${e.message}")
        "unknown"
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Daily.toDailyForecastState(): DailyForecastState {
    return DailyForecastState(
        dayName = getDayOfWeekFromDateTimeString(time),
        maxTemperature = maxTemperature.toInt(),
        minTemperature = minTemperature.toInt(),
        weatherConditionState = wmoCodeToWeatherConditionState(weatherCode)
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Weather.toWeatherState(): WeatherState {
    return WeatherState(
        weatherSummaryState = WeatherSummaryState(
            city,
            wmoCodeToWeatherConditionState(currentWeather.weatherCode),
            currentWeather.temperature.toInt(),
            daily[0].maxTemperature.toInt(),
            daily[0].minTemperature.toInt()
        ),
        currentWeatherDetailsState = currentWeather.toCurrentWeatherDetailsState(),
        hourlyForecastStates = hourly.map { it.toHourlyForecastState() },
        dailyForecastState = daily.map { it.toDailyForecastState() }
    )
}
