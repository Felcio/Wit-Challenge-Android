package com.felcio.wit_chanlenge_android.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.felcio.wit_chanlenge_android.databinding.CityItemBinding
import com.felcio.wit_chanlenge_android.listener.CityListener
import com.felcio.wit_chanlenge_android.results.WeatherResult

class CityAdapter(
    private val citiesWeather: ArrayList<WeatherResult>,
    private val listener: CityListener
) :
    RecyclerView.Adapter<CityAdapter.CityViewHolder>() {

    class CityViewHolder(private val binding: CityItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindCityWeather(item: WeatherResult, listener: CityListener) {
            binding.europeanCityWeather = item
            binding.root.setOnClickListener { listener.onCityClicked(item) }
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): CityViewHolder {
                val binding =
                    CityItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return CityViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        return CityViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        holder.bindCityWeather(citiesWeather[position], listener)
    }

    override fun getItemCount() = citiesWeather.size

    fun addCitiesWeather(users: List<WeatherResult>) {
        this.citiesWeather.apply {
            clear()
            addAll(users)
        }
    }
}