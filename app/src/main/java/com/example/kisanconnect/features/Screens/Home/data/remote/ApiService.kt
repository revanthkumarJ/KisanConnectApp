package com.example.kisanconnect.features.Screens.Home.data.remote

import com.example.kisanconnect.features.Screens.Home.data.model.CarouselItemUI
import retrofit2.http.GET


interface ApiService {
    @GET("customer/getAllCarousels")
    suspend fun getAllCarousels(): List<CarouselItemUI>
}