package com.example.kisanconnect.features.Screens.Cart.data.remote

import com.example.kisanconnect.features.Screens.Cart.data.model.cartItems
import com.example.kisanconnect.features.Screens.Product.data.model.ProductFromBackend
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface CartApiService {
    @GET("customer/getProduct/{productId}")
    suspend fun getProductById(
        @Path("productId") productId: String
    ): ProductFromBackend


    @GET("user/getAllCartItems")
    suspend fun getAllCartItems(
        @Header("auth-token") authToken: String
    ): cartItems


    @DELETE("user/deleteCardItem/{productId}")
    suspend fun deleteCartItem(
        @Path("productId") productId: String,
        @Header("auth-token") authToken:String
    ): Response<Unit>

}