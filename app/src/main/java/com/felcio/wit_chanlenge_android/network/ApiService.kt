package com.felcio.wit_chanlenge_android.network

import com.felcio.wit_chanlenge_android.responses.WeatherDetailsResponse
import com.felcio.wit_chanlenge_android.responses.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("group")
    suspend fun getWeatherByCityId(
        @Query("id") cityId : String,
        @Query("appid") clientApiKey : String,
        @Query("units") units : String
    )  : WeatherResponse

    @GET("weather")
    suspend fun getWeatherbyCityName(
        @Query("q") cityName : String,
        @Query("appid") clientApiKey: String,
        @Query("units") units: String
    ): WeatherDetailsResponse
}