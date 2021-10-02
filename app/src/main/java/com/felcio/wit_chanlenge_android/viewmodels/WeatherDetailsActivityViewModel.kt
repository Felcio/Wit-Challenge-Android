package com.felcio.wit_chanlenge_android.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.felcio.wit_chanlenge_android.repository.WeatherRepository
import com.felcio.wit_chanlenge_android.utils.API_KEY
import com.felcio.wit_chanlenge_android.utils.Resource
import com.felcio.wit_chanlenge_android.utils.UNITS_METRIC
import kotlinx.coroutines.Dispatchers

class WeatherDetailsActivityViewModel(private val weatherRepository: WeatherRepository) :
    ViewModel(){

        fun getWeatherByCityId(id : String) = liveData(Dispatchers.IO) {
            emit(Resource.loading(null))
            try {
                emit(Resource.success(weatherRepository.getWeatherByCityId(id, API_KEY, UNITS_METRIC)))
            }catch (e : Exception) {
                emit(Resource.error(null, e.message))
            }
        }
}