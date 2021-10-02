package com.felcio.wit_chanlenge_android.listener

import com.felcio.wit_chanlenge_android.results.WeatherResult

interface CityListener {
    fun onCityClicked(weatherResult: WeatherResult)
}
