package com.example.myweather.data

import com.example.myweather.data.dto.WeatherDto
import com.example.myweather.data.dto.toWeather
import com.example.myweather.logic.Repository.WeatherRepository
import com.example.myweather.logic.entites.Location
import com.example.myweather.logic.entites.Weather
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
//import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json

class WeatherRepositoryImpl: WeatherRepository {
    override suspend fun getWeather(location: Location): Weather {

        val client = HttpClient(CIO) {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                })
            }
        }

        val url = "https://api.open-meteo.com/v1/forecast"+
                "?latitude=${location.latitude}" +
                "&longitude=${location.longitude}" +
                "&current=" +
                    "temperature_2m," +
                    "relative_humidity_2m," +
                    "uv_index," +
                    "is_day," +
                    "rain," +
                    "weather_code," +
                    "surface_pressure," +
                    "wind_speed_10m" +
                "&daily=" +
                    "temperature_2m_max," +
                    "temperature_2m_min," +
                    "weather_code" +
                "&hourly=" +
                    "temperature_2m," +
                    "weather_code" +
                "&timezone=auto" +
                "&forecast_days=8"

        return client.get(url).body<WeatherDto>().toWeather(location.city).also { client.close() }
    }
}

//fun main() {
//    val repository = WeatherRepositoryImpl()
//    runBlocking {
//        val weather = repository.getWeather(Location("Baghdad", 33.3152, 44.3661))
//        println(weather)
//    }
//}