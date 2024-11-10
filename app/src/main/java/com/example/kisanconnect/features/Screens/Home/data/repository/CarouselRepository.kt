package com.example.kisanconnect.features.Screens.Home.data.repository

import android.util.Log
import com.example.kisanconnect.features.Screens.Home.data.model.CarouselItemUI
import com.example.kisanconnect.features.Screens.Home.data.remote.ApiService
import javax.inject.Inject

class CarouselRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getAllCarousels(): List<CarouselItemUI> {
        Log.i("Revanth","Carousel Repo called")
        val response = apiService.getAllCarousels()
        Log.i("Revanth", "Response from API: $response")
        return response
    }
}