package com.example.kisanconnect.features.Screens.Product.data.remote

import com.example.kisanconnect.features.Screens.Product.data.model.ProductFromBackend
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface ProductApiService{

    @GET("customer/getProduct/{productId}")
    suspend fun getProductById(
        @Path("productId") productId: String
    ):ProductFromBackend

    @POST("user/addCartItem")
    @Headers("Content-Type: application/json")
    suspend fun addToCart(
        @Header("auth-token") authToken: String,
        @Body cartItemRequest: CartItemRequest
    ): Response<Unit>

}

data class CartItemRequest(
    val productId: String,
    val quantity: Int
)