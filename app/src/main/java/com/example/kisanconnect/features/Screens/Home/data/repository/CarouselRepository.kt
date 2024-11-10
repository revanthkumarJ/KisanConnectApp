package com.example.kisanconnect.features.Screens.Home.data.repository



import android.util.Log
import com.example.kisanconnect.features.Screens.Home.data.model.CarouselItemUI
import com.example.kisanconnect.features.Screens.Home.data.model.HomeScreenProductCardItemUI
import com.example.kisanconnect.features.Screens.Home.data.remote.ApiService
import javax.inject.Inject

class CarouselRepository @Inject constructor(private val apiService: ApiService) {

    // Fetch carousels with error handling
    suspend fun getAllCarousels(): List<CarouselItemUI> {
        return try {
            val response = apiService.getAllCarousels()
            response
        } catch (e: Exception) {
            emptyList()
        }
    }

    // Fetch all fruits with error handling
    suspend fun getAllFruits(): List<HomeScreenProductCardItemUI> {
        return try {
            val response = apiService.getAllFruits()
            response
        } catch (e: Exception) {
            emptyList()
        }
    }

    // Fetch all vegetables with error handling
    suspend fun getAllVegetables(): List<HomeScreenProductCardItemUI> {
        return try {
            val response = apiService.getAllVegetables()
            response
        } catch (e: Exception) {
            emptyList()
        }
    }

    // Fetch all dairy with error handling
    suspend fun getAllDairy(): List<HomeScreenProductCardItemUI> {
        return try {
            val response = apiService.getAllDairy()
            response
        } catch (e: Exception) {
            emptyList()
        }
    }

    // Fetch all  grains with error handling
    suspend fun getAllGrains(): List<HomeScreenProductCardItemUI> {
        return try {
            val response = apiService.getAllGrains()
            response
        } catch (e: Exception) {
            emptyList()
        }
    }

    // Fetch all other products with error handling
    suspend fun getAllOther(): List<HomeScreenProductCardItemUI> {
        return try {
            val response = apiService.getAllOther()
            response
        } catch (e: Exception) {
            emptyList()
        }
    }
}
