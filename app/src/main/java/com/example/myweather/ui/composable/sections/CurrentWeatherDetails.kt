package com.example.myweather.ui.composable.sections

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myweather.R
import com.example.myweather.di.dependencies
import com.example.myweather.ui.ViewModel.WeatherViewModel
import com.example.myweather.ui.composable.card.WeatherInfoCard
import com.example.myweather.ui.state.CurrentWeatherDetailsState
import com.example.myweather.ui.state.toWeatherState
import org.koin.core.context.GlobalContext.startKoin
import org.koin.java.KoinJavaComponent.getKoin

@Composable
fun CurrentWeatherDetails(
    currentWeatherDetailsState: CurrentWeatherDetailsState
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            WeatherInfoCard(
                information = "${currentWeatherDetailsState.windSpeed} KM/h",
                description = "Wind",
                icon = painterResource(id = R.drawable.fast_wind_icon),
                modifier = Modifier.weight(1f)
            )
            WeatherInfoCard(
                information = "${currentWeatherDetailsState.humidity}%",
                description = "Humidity",
                icon = painterResource(id = R.drawable.humidity_icon),
                modifier = Modifier.weight(1f)
            )
            WeatherInfoCard(
                information = "${currentWeatherDetailsState.rain}%",
                description = "Rain",
                icon = painterResource(id = R.drawable.rain_icon),
                modifier = Modifier.weight(1f)
            )
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            WeatherInfoCard(
                information = "${currentWeatherDetailsState.uvIndex}",
                description = "UV Index",
                icon = painterResource(id = R.drawable.uv_icon),
                modifier = Modifier.weight(1f)
            )
            WeatherInfoCard(
                information = "${currentWeatherDetailsState.pressure} hPa",
                description = "Pressure",
                icon = painterResource(id = R.drawable.pressure_icon),
                modifier = Modifier.weight(1f)
            )
            WeatherInfoCard(
                information = "${currentWeatherDetailsState.temperature}°C",
                description = "Feels like",
                icon = painterResource(id = R.drawable.temperature_icon),
                modifier = Modifier.weight(1f)
            )
        }
    }
}
//
//@RequiresApi(Build.VERSION_CODES.O)
//@Preview(
//    showBackground = true
//)
//@Composable
//private fun CurrentWeatherDetailsPreview() {
//    startKoin { modules(dependencies) }
//    val viewModel: WeatherViewModel = getKoin().get()
//    CurrentWeatherDetails(viewModel.weather.toWeatherState().currentWeatherDetailsState)
//}