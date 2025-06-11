package com.example.myweather.ui.composable.sections

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myweather.ui.composable.card.WeeklyForecastItem
import com.example.myweather.ui.state.DailyForecastState
import com.example.myweather.ui.state.wmoCodeToWeatherConditionState
import com.example.myweather.ui.theme.MyWeatherTheme
import com.example.myweather.ui.theme.Urbanist


@Composable
fun ForecastForWeek(
    dailyForecastStates: List<DailyForecastState>
) {
    Column(
        modifier = Modifier.padding(horizontal = 12.dp)
    ) {
        Text(
            text = "Next 7 Days",
            fontFamily = Urbanist,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = MyWeatherTheme.colors.oppositeColor,
        )
        Spacer(modifier = Modifier.height(12.dp))
        Column(
            modifier = Modifier
                .background(
                    color = MyWeatherTheme.colors.surfaceTransparent70,
                    shape = RoundedCornerShape(24.dp)
                )
                .border(
                    width = 1.dp,
                    color = MyWeatherTheme.colors.oppositeColorTransparent8,
                    shape = RoundedCornerShape(24.dp)
                )
        ) {
            WeeklyForecastItem(dailyForecastStates[0], Modifier.padding(horizontal = 16.dp))
            dailyForecastStates.drop(1).forEach {
                HorizontalDivider(
                    thickness = 1.dp,
                    color = MyWeatherTheme.colors.oppositeColorTransparent8
                )
                WeeklyForecastItem(it, Modifier.padding(horizontal = 16.dp))
            }
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
@Composable
private fun ForecastForWeekPreview() {
    MyWeatherTheme(isDay = true) {
        ForecastForWeek(
            listOf(
                DailyForecastState(
                    dayName = "Sunday",
                    maxTemperature = 32,
                    minTemperature = 20,
                    weatherConditionState = wmoCodeToWeatherConditionState(wmoCode = 1),
                ),
                DailyForecastState(
                    dayName = "Monday",
                    maxTemperature = 32,
                    minTemperature = 20,
                    weatherConditionState = wmoCodeToWeatherConditionState(wmoCode = 0),
                ),
                DailyForecastState(
                    dayName = "Tuesday",
                    maxTemperature = 32,
                    minTemperature = 20,
                    weatherConditionState = wmoCodeToWeatherConditionState(wmoCode = 48),
                ),
                DailyForecastState(
                    dayName = "Wednesday",
                    maxTemperature = 32,
                    minTemperature = 20,
                    weatherConditionState = wmoCodeToWeatherConditionState(wmoCode = 65),
                ),
                DailyForecastState(
                    dayName = "Thursday",
                    maxTemperature = 32,
                    minTemperature = 20,
                    weatherConditionState = wmoCodeToWeatherConditionState(wmoCode = 81),
                ),
                DailyForecastState(
                    dayName = "Friday",
                    maxTemperature = 32,
                    minTemperature = 20,
                    weatherConditionState = wmoCodeToWeatherConditionState(wmoCode = 95),
                ),
                DailyForecastState(
                    dayName = "Saturday",
                    maxTemperature = 32,
                    minTemperature = 20,
                    weatherConditionState = wmoCodeToWeatherConditionState(wmoCode = 1),
                ),
            )
        )
    }

}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(
    showBackground = true,
    backgroundColor = 0xFF060414
)
@Composable
private fun ForecastForWeekDarkPreview() {
    MyWeatherTheme(isDay = false) {
        ForecastForWeek(
            listOf(
                DailyForecastState(
                    dayName = "Sunday",
                    maxTemperature = 32,
                    minTemperature = 20,
                    weatherConditionState = wmoCodeToWeatherConditionState(wmoCode = 1),
                ),
                DailyForecastState(
                    dayName = "Monday",
                    maxTemperature = 32,
                    minTemperature = 20,
                    weatherConditionState = wmoCodeToWeatherConditionState(wmoCode = 0),
                ),
                DailyForecastState(
                    dayName = "Tuesday",
                    maxTemperature = 32,
                    minTemperature = 20,
                    weatherConditionState = wmoCodeToWeatherConditionState(wmoCode = 48),
                ),
                DailyForecastState(
                    dayName = "Wednesday",
                    maxTemperature = 32,
                    minTemperature = 20,
                    weatherConditionState = wmoCodeToWeatherConditionState(wmoCode = 65),
                ),
                DailyForecastState(
                    dayName = "Thursday",
                    maxTemperature = 32,
                    minTemperature = 20,
                    weatherConditionState = wmoCodeToWeatherConditionState(wmoCode = 81),
                ),
                DailyForecastState(
                    dayName = "Friday",
                    maxTemperature = 32,
                    minTemperature = 20,
                    weatherConditionState = wmoCodeToWeatherConditionState(wmoCode = 95),
                ),
                DailyForecastState(
                    dayName = "Saturday",
                    maxTemperature = 32,
                    minTemperature = 20,
                    weatherConditionState = wmoCodeToWeatherConditionState(wmoCode = 1),
                ),
            )
        )
    }
}