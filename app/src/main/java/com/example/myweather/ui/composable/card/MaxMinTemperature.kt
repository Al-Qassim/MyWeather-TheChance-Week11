package com.example.myweather.ui.composable.card

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myweather.R
import com.example.myweather.ui.theme.BlackTransparent87
import com.example.myweather.ui.theme.MyWeatherTheme
import com.example.myweather.ui.theme.Urbanist

@Composable
internal fun MaxMinTemperature(
    maxTemperature: Int,
    minTemperature: Int,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = 14.sp,
    color: Color = MyWeatherTheme.colors.oppositeColorTransparent87,
    middleSpacing: Dp = 4.dp
) {
    Box (
        modifier = modifier,
        contentAlignment = Alignment.CenterEnd
    ) {
        Box {
            Icon(
                painter = painterResource(id = R.drawable.vertical_line),
                contentDescription = null,
                modifier = Modifier
                    .height(14.dp)
                    .align(Alignment.Center),
                tint = color
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.arrow_up),
                    contentDescription = null,
                    tint = color,
                    modifier = Modifier.size(12.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "$maxTemperature°C",
                    fontFamily = Urbanist,
                    fontSize = fontSize,
                    fontWeight = FontWeight.Medium,
                    color = color,
                    letterSpacing = TextUnit(.01f, TextUnitType.Sp)
                )
                Spacer(modifier = Modifier.width((middleSpacing.value * 2).dp))
                Icon(
                    painter = painterResource(id = R.drawable.arrow_down),
                    contentDescription = null,
                    tint = color,
                    modifier = Modifier.size(12.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "$minTemperature°C",
                    fontFamily = Urbanist,
                    fontSize = fontSize,
                    fontWeight = FontWeight.Medium,
                    color = color,
                    letterSpacing = TextUnit(.01f, TextUnitType.Sp)
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
)

@Composable
private fun Preview() {
    MyWeatherTheme(isDay = true){
        MaxMinTemperature(
            maxTemperature = 32,
            minTemperature = 20,
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
        MaxMinTemperature(
            maxTemperature = 32,
            minTemperature = 20,
        )
    }
}