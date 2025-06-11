package com.example.myweather.ui.composable.card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myweather.ui.theme.Black
import com.example.myweather.ui.theme.BlackTransparent60
import com.example.myweather.ui.theme.BlackTransparent8
import com.example.myweather.ui.theme.MyWeatherTheme
import com.example.myweather.ui.theme.Urbanist

@Composable
fun TemperatureInfo(
    currentTemperature: Int,
    maxTemperature: Int,
    minTemperature: Int,
    weatherDescription: String,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "$currentTemperature°C",
            fontFamily = Urbanist,
            fontSize = 64.sp,
            fontWeight = FontWeight.SemiBold,
            color = MyWeatherTheme.colors.oppositeColor
        )
        Text(
            text = weatherDescription,
            fontFamily = Urbanist,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = MyWeatherTheme.colors.oppositeColorTransparent60
        )
        Spacer(Modifier.height(12.dp))
        MaxMinTemperature(
            maxTemperature = maxTemperature,
            minTemperature = minTemperature,
            modifier = Modifier
                .background(
                    color = MyWeatherTheme.colors.oppositeColorTransparent8,
                    shape = RoundedCornerShape(100)
                )
                .padding(vertical = 8.dp, horizontal = 24.dp),
            fontSize = 16.sp,
            color = MyWeatherTheme.colors.oppositeColorTransparent60,
            middleSpacing = 8.dp
        )
    }
}


@Preview(
    showBackground = true,
)

@Composable
private fun Preview() {
    MyWeatherTheme(isDay = true){
        TemperatureInfo(
            currentTemperature = 24,
            maxTemperature = 32,
            minTemperature = 20,
            "Partly cloudy"
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
        TemperatureInfo(
            currentTemperature = 24,
            maxTemperature = 32,
            minTemperature = 20,
            "Partly cloudy"
        )
    }
}