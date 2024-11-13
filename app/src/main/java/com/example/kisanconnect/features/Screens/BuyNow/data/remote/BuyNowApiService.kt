package com.example.kisanconnect.features.Screens.BuyNow.data.remote

import com.example.kisanconnect.features.Screens.Product.data.model.ProductFromBackend
import com.example.kisanconnect.features.Screens.Product.data.remote.CartItemRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface BuyNowApiService {

    @GET("customer/getProduct/{productId}")
    suspend fun getProductById(
        @Path("productId") productId: String
    ): ProductFromBackend

    @POST("user/placeOrder")
    @Headers("Content-Type: application/json")
    suspend fun postProduct(
        @Header("auth-token") authToken: String,
        @Body cartItemRequest: CartItemRequest
    ):Result<Unit>
}