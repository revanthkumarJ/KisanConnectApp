package com.example.kisanconnect.features.Screens.Product.data.remote

import com.example.kisanconnect.features.Screens.Product.data.model.ProductFromBackend
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductApiService{

    @GET("customer/getProduct/{productId}")
    suspend fun getProductById(
        @Path("productId") productId: String
    ):ProductFromBackend
}