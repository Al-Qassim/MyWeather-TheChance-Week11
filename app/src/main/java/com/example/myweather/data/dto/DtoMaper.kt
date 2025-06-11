package com.example.myweather.data.dto

import com.example.myweather.logic.entites.CurrentWeather
import com.example.myweather.logic.entites.CurrentUnits
import com.example.myweather.logic.entites.Daily
import com.example.myweather.logic.entites.DailyUnits
import com.example.myweather.logic.entites.Hourly
import com.example.myweather.logic.entites.HourlyUnits
import com.example.myweather.logic.entites.Weather

fun WeatherDto.toWeather(city: String): Weather {
    return Weather(
        city = city,
        currentUnits = this.currentUnits.toCurrentUnits(),
        currentWeather = this.current.toCurrent(),
        hourlyUnits = this.hourlyUnits.toHourlyUnits(),
        hourly = this.hourly.toHourlyList(),
        dailyUnits = this.dailyUnits.toDailyUnits(),
        daily = this.daily.toDailyList()
    )
}


fun CurrentUnitsDto.toCurrentUnits(): CurrentUnits {
    return CurrentUnits(
        time = this.time,
        temperature = this.temperature,
        humidity = this.humidity,
        uvIndex = this.uvIndex,
        isDay = this.isDay,
        rain = this.rain,
        weatherCode = this.weatherCode,
        pressure = this.pressure,
        windSpeed = this.windSpeed
    )
}

fun CurrentDto.toCurrent(): CurrentWeather {
    return CurrentWeather(
        time = this.time,
        temperature = this.temperature,
        humidity = this.humidity,
        uvIndex = this.uvIndex,
        isDay = this.isDay == 1,
        rain = this.rain,
        weatherCode = this.weatherCode,
        pressure = this.pressure,
        windSpeed = this.windSpeed
    )
}

fun HourlyUnitsDto.toHourlyUnits(): HourlyUnits {
    return HourlyUnits(
        time = this.time,
        temperature = this.temperature,
        weatherCode = this.weatherCode
    )
}

fun HourlyDto.toHourlyList(): List<Hourly> {
    return this.time.mapIndexed { index, time ->
        Hourly(
            time = time,
            temperature = this.temperature[index],
            weatherCode = this.weatherCode[index]
        )
    }
}

fun DailyUnitsDto.toDailyUnits(): DailyUnits {
    return DailyUnits(
        time = this.time,
        mixTemperature = this.mixTemperature,
        minTemperature = this.minTemperature,
        weatherCode = this.weatherCode
    )
}

fun DailyDto.toDailyList(): List<Daily> {
    return this.time.mapIndexed { index, time ->
        Daily(
            time = time,
            maxTemperature = this.mixTemperature[index],
            minTemperature = this.minTemperature[index],
            weatherCode = this.weatherCode[index]
        )
    }
}

