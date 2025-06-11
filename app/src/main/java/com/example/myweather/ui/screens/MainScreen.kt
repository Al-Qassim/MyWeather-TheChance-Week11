package com.example.myweather.ui.screens

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myweather.ui.ViewModel.WeatherViewModel
import com.example.myweather.ui.composable.sections.CurrentWeatherDetails
import com.example.myweather.ui.composable.sections.ForecastForToday
import com.example.myweather.ui.composable.sections.ForecastForWeek
import com.example.myweather.ui.composable.sections.WeatherSummary
import com.example.myweather.ui.state.WeatherState
import com.example.myweather.ui.state.WeatherUiState
import com.example.myweather.ui.state.getFakeWeatherState
import com.example.myweather.ui.state.toWeatherState
import com.example.myweather.ui.theme.MyWeatherTheme

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainScreen(
    viewModel: WeatherViewModel,
    modifier: Modifier = Modifier
) {

    val weatherUiState by viewModel.weatherUiState.collectAsState()

    Crossfade(targetState = weatherUiState, label = "WeatherUiStateFade") { uiState ->
        when (uiState) {
            is WeatherUiState.Loading -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ){
                    CircularProgressIndicator()
                }
            }

            is WeatherUiState.Error -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ){
                    Text("Error: ${uiState.message}", color = Color.Red)
                }
            }

            is WeatherUiState.Success -> {
                val weatherData = uiState.data

                MyWeatherTheme(isDay = weatherData.currentWeather.isDay) {
                    MainContent(
                        weatherState = weatherData.toWeatherState(),
                        modifier = modifier
                    )
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
private fun MainContent(
    weatherState: WeatherState,
    modifier: Modifier = Modifier
) {

    Log.i("myData", weatherState.toString())

    val scrollState = rememberScrollState()
    Scaffold(
        modifier = modifier
            .fillMaxSize(),
    ) { paddingValues ->
        Column(
            modifier = modifier
                .background(Brush.linearGradient(MyWeatherTheme.colors.backgrounds))
                .padding(paddingValues)
                .padding(top = 24.dp, bottom = 32.dp)
                .fillMaxSize()
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            WeatherSummary(weatherState.weatherSummaryState, scrollState)
            CurrentWeatherDetails(weatherState.currentWeatherDetailsState)
            ForecastForToday(weatherState.hourlyForecastStates)
            ForecastForWeek(weatherState.dailyForecastState)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(
    widthDp = 360,
    heightDp = 760
)
@Composable
private fun MainScreenPreview() {

    val weatherState = getFakeWeatherState(isDay = false)

    MyWeatherTheme(isDay = weatherState.currentWeatherDetailsState.isDay) {
        MainContent(
            weatherState = weatherState,
        )
    }
}