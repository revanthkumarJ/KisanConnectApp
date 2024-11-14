package com.example.kisanconnect.features.Screens.OtherOrders.data.remote

import com.example.kisanconnect.features.Screens.OtherOrders.data.model.OnTheWayItems
import com.example.kisanconnect.features.Screens.OtherOrders.data.model.orderedItem
import retrofit2.http.GET
import retrofit2.http.Header

interface OtherProductsApiService{


    @GET("user/getAllOnTheWay")
    suspend fun getAllOnTheWayItems(
        @Header("auth-token") header:String
    ):OnTheWayItems

    @GET("user/getAllDeliveredItems")
    suspend fun getAllOrderedItems(
        @Header("auth-token") header:String
    ):orderedItem

}