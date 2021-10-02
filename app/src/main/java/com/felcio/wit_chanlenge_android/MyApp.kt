package com.felcio.wit_chanlenge_android

import android.app.Application
import com.felcio.wit_chanlenge_android.network.ApiClient
import com.felcio.wit_chanlenge_android.network.ApiHelper
import com.felcio.wit_chanlenge_android.repository.WeatherRepository
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApp  : Application() {
    val weatherRepository = WeatherRepository(ApiHelper(ApiClient.apiService()))
}