package com.felcio.wit_chanlenge_android.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.felcio.wit_chanlenge_android.repository.WeatherRepository

@Suppress("UNCHECKED_CAST")
class WeatherDetailsActivityViewModelFactory(private val weatherRepository: WeatherRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WeatherDetailsActivityViewModel::class.java)) {
            return WeatherDetailsActivityViewModel(weatherRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }

}