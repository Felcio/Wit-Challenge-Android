package com.felcio.wit_chanlenge_android.responses

import com.felcio.wit_chanlenge_android.results.WeatherResult
import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("list") val list: List<WeatherResult>
)
