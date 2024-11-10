package com.example.kisanconnect.features.Screens.Home.data.remote

import com.example.kisanconnect.features.Screens.Home.data.model.CarouselItemUI
import com.example.kisanconnect.features.Screens.Home.data.model.HomeScreenProductCardItemUI
import retrofit2.http.GET


interface ApiService {
    @GET("customer/getAllCarousels")
    suspend fun getAllCarousels(): List<CarouselItemUI>

    @GET("customer/getAllFruits")
    suspend fun getAllFruits(): List<HomeScreenProductCardItemUI>

    @GET("customer/getAllVegetables")
    suspend fun getAllVegetables(): List<HomeScreenProductCardItemUI>

    @GET("customer/getAllDairy")
    suspend fun getAllDairy(): List<HomeScreenProductCardItemUI>

    @GET("customer/getAllGrains")
    suspend fun getAllGrains(): List<HomeScreenProductCardItemUI>

    @GET("customer/getAllOthers")
    suspend fun getAllOther(): List<HomeScreenProductCardItemUI>
}