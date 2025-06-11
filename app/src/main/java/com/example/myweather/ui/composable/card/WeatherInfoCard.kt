package com.example.myweather.ui.composable.card

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myweather.R
import com.example.myweather.ui.theme.MyWeatherTheme
import com.example.myweather.ui.theme.Urbanist

@Composable
fun WeatherInfoCard(
    information: String,
    description: String,
    icon: Painter,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .height(115.dp)
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
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = icon,
            contentDescription = null,
            tint = MyWeatherTheme.colors.primary,
            modifier = Modifier
                .padding(bottom = 8.dp)
                .size(32.dp)
        )
        Text(
            text = information,
            fontFamily = Urbanist,
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            color = MyWeatherTheme.colors.oppositeColor,
            modifier = Modifier.padding(bottom = 2.dp)
        )
        Text(
            text = description,
            fontFamily = Urbanist,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            color = MyWeatherTheme.colors.oppositeColorTransparent60
        )
    }
}

@Preview(
    widthDp = 108,
    heightDp = 115,
    showBackground = true,
    backgroundColor = 0xFF87CEFA
)

@Composable
private fun Preview() {
    MyWeatherTheme(isDay = true) {
        WeatherInfoCard(
            information = "22°C",
            description = "Feels like",
            icon = painterResource(id = R.drawable.temperature_icon)
        )
    }
}

@Preview(
    widthDp = 108,
    heightDp = 115,
    showBackground = true,
    backgroundColor = 0xFF060414
)

@Composable
private fun DarkPreview() {
    MyWeatherTheme(isDay = false) {
        WeatherInfoCard(
            information = "22°C",
            description = "Feels like",
            icon = painterResource(id = R.drawable.temperature_icon)
        )
    }
}