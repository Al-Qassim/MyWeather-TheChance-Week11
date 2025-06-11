package com.example.myweather.ui.composable.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myweather.R
import com.example.myweather.ui.extensionFunctions.dropShadow
import com.example.myweather.ui.state.HourlyForecastState
import com.example.myweather.ui.state.WeatherConditionState
import com.example.myweather.ui.theme.BlackTransparent60
import com.example.myweather.ui.theme.BlackTransparent8
import com.example.myweather.ui.theme.BlackTransparent87
import com.example.myweather.ui.theme.MyWeatherTheme
import com.example.myweather.ui.theme.Urbanist
import com.example.myweather.ui.theme.WhiteTransparent70


@Composable
fun DailyForecastCard(
    hourlyForecastState: HourlyForecastState,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .height(132.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .size(88.dp, 120.dp)
                .align(Alignment.BottomCenter)
                .background(
                    color = MyWeatherTheme.colors.surfaceTransparent70,
                    shape = RoundedCornerShape(24.dp)
                )
                .border(
                    width = 1.dp,
                    color = MyWeatherTheme.colors.oppositeColorTransparent8,
                    shape = RoundedCornerShape(24.dp)
                )
                .padding(horizontal = 8.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${hourlyForecastState.temperature}°C",
                    fontFamily = Urbanist,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = MyWeatherTheme.colors.oppositeColorTransparent87,
                )
            }
            Text(
                text = hourlyForecastState.time,
                fontFamily = Urbanist,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = MyWeatherTheme.colors.oppositeColorTransparent60,
            )
        }

        Image(
            painter = hourlyForecastState.weatherConditionState.painter,
            contentDescription = null,
            modifier = Modifier
                .height(58.dp)
                .align(Alignment.TopCenter)
        )
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF87CEFA // Dark background for preview
)

@Composable
private fun Preview() {
    MyWeatherTheme(isDay = true){
        DailyForecastCard(
            HourlyForecastState(
                temperature = "25",
                time = "11:00",
                weatherConditionState = WeatherConditionState(
                    "Mainly Clear",
                    painterResource(id = R.drawable.mainly_clear_day)
                )
            )
        )
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF060414
)

@Composable
private fun DarkPreview() {
    MyWeatherTheme(isDay = false){
        DailyForecastCard(
            HourlyForecastState(
                temperature = "25",
                time = "11:00",
                weatherConditionState = WeatherConditionState(
                    "Mainly Clear",
                    painterResource(id = R.drawable.mainly_clear_night)
                )
            )
        )
    }
}