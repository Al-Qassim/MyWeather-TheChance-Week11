package com.example.myweather.ui.composable.sections

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import com.example.myweather.di.dependencies
import com.example.myweather.ui.ViewModel.WeatherViewModel
import com.example.myweather.ui.composable.card.CityName
import com.example.myweather.ui.composable.card.TemperatureInfo
import com.example.myweather.ui.extensionFunctions.dropShadow
import com.example.myweather.ui.state.WeatherSummaryState
import com.example.myweather.ui.state.toWeatherState
import com.example.myweather.ui.theme.Black
import com.example.myweather.ui.theme.MyWeatherTheme
import org.koin.core.context.GlobalContext.startKoin
import org.koin.java.KoinJavaComponent.getKoin
import kotlin.math.min

@Composable
fun WeatherSummary(
    weatherSummaryState: WeatherSummaryState,
    scrollState: ScrollState,
    modifier: Modifier = Modifier
) {
    val density = LocalDensity.current
    val scrollStateDp = with(density) { scrollState.value.toDp() }

    var state = min(scrollStateDp.value / 212, 1f) // from 0 to 1

    val screenWidth = LocalConfiguration.current.screenWidthDp

    var imageWidthDp by remember { mutableStateOf(0.dp) }
    var temperatureInfoWidthDp by remember { mutableStateOf(0.dp) }

    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        CityName(
            weatherSummaryState.city,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(
                    top = lerp(0.dp, 212.dp, state),
                    bottom = 12.dp
                )
        )
        Box(
            modifier = modifier
                .fillMaxWidth()
//                .border(width = 1.dp, color = Black)
        ) {
            Image(
                painter = weatherSummaryState.weatherConditionState.painter,
                contentDescription = null,
                modifier = Modifier
//                    .height(200.dp)
                    .height(lerp(200.dp, 112.dp, state))
                    .onGloballyPositioned { coordinates ->
                        imageWidthDp = with(density) { coordinates.size.width.toDp() }
                    }
                    .padding(top = lerp(0.dp, 15.5.dp, state))
                    .offset(
//                        x = ((screenWidth - imageWidthDp.value) / 2).dp
                        x = lerp(
                            ((screenWidth - imageWidthDp.value) / 2).dp,
                            12.dp,
                            state
                        )
                    )
//                    .dropShadow(
//                        color = Color(0x4000619D),
//                        blur = 150.dp,
//                        scaleY = 0.5f,
//                        offsetY = 50.dp
//                    )
            )
            TemperatureInfo(
                currentTemperature = weatherSummaryState.currentTemperature,
                maxTemperature = weatherSummaryState.maxTemperature,
                minTemperature = weatherSummaryState.minTemperature,
                weatherSummaryState.weatherConditionState.description,
                modifier = Modifier
//                    .padding(top = 212.dp)
                    .padding(top = lerp(212.dp, 0.dp, state))
                    .onGloballyPositioned { coordinates ->
                        temperatureInfoWidthDp = with(density) { coordinates.size.width.toDp() }
                    }
                    .offset(
//                        x = ((screenWidth - temperatureInfoWidthDp.value) / 2).dp
                        x = lerp(
                            ((screenWidth - temperatureInfoWidthDp.value) / 2).dp,
                            (screenWidth - temperatureInfoWidthDp.value - 12).dp,
                            state
                        )
                    )
            )
        }
    }
}
//
//@RequiresApi(Build.VERSION_CODES.O)
//@Preview(
//    showBackground = true,
//    backgroundColor = 0xFF060414,
//    widthDp = 360,
//    heightDp = 500,
//)
//@Composable
//private fun WeatherSummaryDarkPreview() {
//    val viewModel: WeatherViewModel = getKoin().get()
//
//    var scrollState = rememberScrollState()
//
//    MyWeatherTheme.setTheme(isDay = false)
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .verticalScroll(scrollState)
//    ) {
//        WeatherSummary(
//            viewModel.weather.toWeatherState().weatherSummaryState,
//            scrollState
//        )
//        Text("More stuff here")
//        Spacer(modifier = Modifier.height(700.dp))
//    }
//}
//
//@RequiresApi(Build.VERSION_CODES.O)
//@Preview(
//    showBackground = true,
//    widthDp = 360,
//    heightDp = 500,
//)
//@Composable
//private fun WeatherSummaryPreview() {
//    startKoin { modules(dependencies) }
//    val viewModel: WeatherViewModel = getKoin().get()
//
//    var scrollState = rememberScrollState()
//
//    MyWeatherTheme.setTheme(isDay = true)
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .verticalScroll(scrollState)
//    ) {
//        WeatherSummary(
//            viewModel.weather.toWeatherState().weatherSummaryState,
//            scrollState
//        )
//        Text("More stuff here")
//        Spacer(modifier = Modifier.height(700.dp))
//    }
//}