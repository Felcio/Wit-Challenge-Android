package com.felcio.wit_chanlenge_android.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.felcio.wit_chanlenge_android.R
import com.felcio.wit_chanlenge_android.adapters.CityAdapter
import com.felcio.wit_chanlenge_android.databinding.ActivityMainBinding
import com.felcio.wit_chanlenge_android.listener.CityListener
import com.felcio.wit_chanlenge_android.repository.WeatherRepository
import com.felcio.wit_chanlenge_android.responses.WeatherDetailsResponse
import com.felcio.wit_chanlenge_android.results.WeatherResult
import com.felcio.wit_chanlenge_android.utils.INTENT_WEATHER_RESULT
import com.felcio.wit_chanlenge_android.utils.Status
import com.felcio.wit_chanlenge_android.viewmodels.MainActivityViewModel
import com.felcio.wit_chanlenge_android.viewmodels.MainActivityViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), CityListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var cityAdapter: CityAdapter
    private lateinit var mViewModel: MainActivityViewModel

    @Inject
    lateinit var weatherRepository: WeatherRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setupViewModel()
        doInitialization()
        setUpObservers()
    }

    private fun doInitialization() {
        binding.recyclerviewEuropeanCities.layoutManager = LinearLayoutManager(this)
        binding.recyclerviewEuropeanCities.setHasFixedSize(true)
        cityAdapter = CityAdapter(arrayListOf(), this)
        binding.recyclerviewEuropeanCities.adapter = cityAdapter
    }

    private fun setupViewModel() {
        mViewModel = ViewModelProviders.of(
            this,
            MainActivityViewModelFactory(weatherRepository)
        ).get(MainActivityViewModel::class.java)
    }

    private fun setUpObservers() {
        mViewModel.getMyCityWeather().observe(this, Observer {
            it?.let { r ->
                when (r.status) {
                    Status.SUCCESS -> {
                        binding.cardviewMyCityWeather.visibility = View.VISIBLE
                        it.data?.let { weatherDetails -> retrieveMyCityWeather(weatherDetails) }
                    }

                    Status.ERROR -> {
                        binding.cardviewMyCityWeather.visibility = View.INVISIBLE
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }

                    Status.LOADING -> {
                        binding.cardviewMyCityWeather.visibility = View.VISIBLE
                    }
                }
            }
        })

        mViewModel.getEuropeanCitiesWeather().observe(this, Observer {
            it?.let { r ->
                when (r.status) {
                    Status.SUCCESS -> {
                        // binding.recyclerviewEuropeanCities.visibility = View.VISIBLE
                        binding.isLoading = false
                        r.data?.let { weatherResponse ->
                            retrieveEuropeanCitiesWeather(weatherResponse.list)
                        }
                    }

                    Status.ERROR -> {
                        binding.isLoading = false
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }

                    Status.LOADING -> {
                        binding.isLoading = true
                    }
                }
            }
        })
    }

    private fun retrieveMyCityWeather(response: WeatherDetailsResponse) {
        binding.myCityNameAndCountry = response.cityAndCountry
        binding.myCityDateAndTime = response.dt
        binding.myCityWeatherIcon = response.weather[0].iconUrlType2
        binding.myCityWeatherDescription = response.weather[0].description
        binding.myCityHumidity = response.main.humidity
        binding.myCityWind = response.wind.speed
        binding.myCityTemperature = response.main.temp

        binding.cardviewMyCityWeather.setOnClickListener {
            response.let {
                val intent = Intent(this, WeatherDetailsActivity::class.java)
                intent.putExtra(INTENT_WEATHER_RESULT, it.id.toString())
                startActivity(intent)
            }
        }
    }

    private fun retrieveEuropeanCitiesWeather(citiesWeather: List<WeatherResult>) {
        cityAdapter.apply {
            addCitiesWeather(citiesWeather)
            notifyDataSetChanged()
        }
    }

    override fun onCityClicked(weatherResult: WeatherResult) {
        val intent = Intent(this, WeatherDetailsActivity::class.java)
        intent.putExtra(INTENT_WEATHER_RESULT, weatherResult.id.toString())
        startActivity(intent)
    }
}