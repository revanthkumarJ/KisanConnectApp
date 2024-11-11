package com.example.kisanconnect.features.Screens.Home.data.repository

import com.example.kisanconnect.features.Screens.Home.data.model.CarouselItemUI
import com.example.kisanconnect.features.Screens.Home.data.model.HomeScreenProductCardItemUI
import com.example.kisanconnect.features.Screens.Home.data.remote.HomeApiService
import javax.inject.Inject
import java.io.IOException

class CarouselRepository @Inject constructor(private val apiService: HomeApiService) {

    // Fetch carousels with error handling
    suspend fun getAllCarousels(): Result<List<CarouselItemUI>> {
        return try {
            val response = apiService.getAllCarousels()
            Result.success(response)
        } catch (e: IOException) {
            Result.failure(e)  // Handle network issues
        } catch (e: Exception) {
            Result.failure(e)  // Handle other exceptions
        }
    }

    // Fetch all fruits with error handling
    suspend fun getAllFruits(): Result<List<HomeScreenProductCardItemUI>> {
        return try {
            val response = apiService.getAllFruits()
            Result.success(response)
        } catch (e: IOException) {
            Result.failure(e)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    // Fetch all vegetables with error handling
    suspend fun getAllVegetables(): Result<List<HomeScreenProductCardItemUI>> {
        return try {
            val response = apiService.getAllVegetables()
            Result.success(response)
        } catch (e: IOException) {
            Result.failure(e)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    // Fetch all dairy products with error handling
    suspend fun getAllDairy(): Result<List<HomeScreenProductCardItemUI>> {
        return try {
            val response = apiService.getAllDairy()
            Result.success(response)
        } catch (e: IOException) {
            Result.failure(e)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    // Fetch all grains with error handling
    suspend fun getAllGrains(): Result<List<HomeScreenProductCardItemUI>> {
        return try {
            val response = apiService.getAllGrains()
            Result.success(response)
        } catch (e: IOException) {
            Result.failure(e)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    // Fetch all other products with error handling
    suspend fun getAllOther(): Result<List<HomeScreenProductCardItemUI>> {
        return try {
            val response = apiService.getAllOther()
            Result.success(response)
        } catch (e: IOException) {
            Result.failure(e)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
