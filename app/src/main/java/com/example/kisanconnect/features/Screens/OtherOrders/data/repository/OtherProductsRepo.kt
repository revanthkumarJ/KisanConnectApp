package com.example.kisanconnect.features.Screens.OtherOrders.data.repository

import com.example.kisanconnect.features.Screens.OtherOrders.data.model.OnTheWayItem
import com.example.kisanconnect.features.Screens.OtherOrders.data.model.OrderedItemX
import com.example.kisanconnect.features.Screens.OtherOrders.data.remote.OtherProductsApiService
import javax.inject.Inject

class OtherProductsRepo @Inject constructor(
    private val otherProductsApiService: OtherProductsApiService
) {

    suspend fun getAllOnTheWay(header: String): List<OnTheWayItem> {
        return try {
            val response = otherProductsApiService.getAllOnTheWayItems(header)
            response[0].onTheWayItems
        } catch (e: Exception) {
            throw e
        }
    }

    suspend fun getAllOrdered(header: String): List<OrderedItemX> {
        return try {
            val response = otherProductsApiService.getAllOrderedItems(header)
            response[0].orderedItems
        } catch (e: Exception) {
            throw e
        }
    }
}
