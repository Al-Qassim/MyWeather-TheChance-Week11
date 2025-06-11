package com.example.myweather.ui.composable.sections

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myweather.di.dependencies
import com.example.myweather.ui.ViewModel.WeatherViewModel
import com.example.myweather.ui.composable.card.DailyForecastCard
import com.example.myweather.ui.state.HourlyForecastState
import com.example.myweather.ui.state.toWeatherState
import com.example.myweather.ui.theme.MyWeatherTheme
import com.example.myweather.ui.theme.Urbanist
import org.koin.core.context.GlobalContext.startKoin
import org.koin.java.KoinJavaComponent.getKoin

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun ForecastForToday(
    hourlyForecastStates: List<HourlyForecastState>
) {

    Column {
        Text(
            text = "Today",
            fontFamily = Urbanist,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = MyWeatherTheme.colors.oppositeColor,
            modifier = Modifier.padding(start = 12.dp, bottom = 12.dp)
        )
        LazyRow(
            contentPadding = PaddingValues(horizontal = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(hourlyForecastStates) { DailyForecastCard(it) }
        }
    }
}
//
//@RequiresApi(Build.VERSION_CODES.O)
//@Preview(
//    showBackground = true
//)
//@Composable
//private fun ForecastForTodayPreview() {
//    startKoin { modules(dependencies) }
//    val viewModel: WeatherViewModel = getKoin().get()
//    ForecastForToday(viewModel.weather.toWeatherState().hourlyForecastStates)
//}