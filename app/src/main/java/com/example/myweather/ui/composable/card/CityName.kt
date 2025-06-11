package com.example.myweather.ui.composable.card

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
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
import com.example.myweather.ui.theme.MyWeatherTheme
import com.example.myweather.ui.theme.Urbanist


@Composable
fun CityName(
    city: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.location_icon),
            contentDescription = null,
            tint = MyWeatherTheme.colors.variantColor,
        )
        Text(
            text = city,
            fontFamily = Urbanist,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = MyWeatherTheme.colors.variantColor,
            modifier = Modifier.padding(start = 4.dp)
        )
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF87CEFA
)

@Composable
private fun Preview() {
    MyWeatherTheme(isDay = true) {
        CityName("Baghdad")
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF060414
)

@Composable
private fun DarkPreview() {
    MyWeatherTheme(isDay = false) {
        CityName("Baghdad")
    }
}