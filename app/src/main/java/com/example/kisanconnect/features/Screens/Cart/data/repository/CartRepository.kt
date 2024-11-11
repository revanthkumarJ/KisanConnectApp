package com.example.kisanconnect.features.Screens.Cart.data.repository

import android.util.Log
import com.example.kisanconnect.features.Screens.Cart.data.model.cartItem
import com.example.kisanconnect.features.Screens.Cart.data.model.cartItemUI
import com.example.kisanconnect.features.Screens.Cart.data.remote.CartApiService
import com.example.kisanconnect.features.Screens.Product.data.model.Product
import javax.inject.Inject

class CartRepository @Inject constructor(
    private val cartApiService: CartApiService
) {

    suspend fun getAllCartItems(header: String): List<cartItem> {
        return try {
            val response = cartApiService.getAllCartItems(header)
            response.cartItems
        } catch (e: Exception) {
            Log.e("CartRepository", "Error fetching cart items", e)
            emptyList() // Return empty list if there's an error
        }
    }

    suspend fun getItemById(id: String): Product {
        return try {
            cartApiService.getProductById(id).item
        } catch (e: Exception) {
            Log.e("CartRepository", "Error fetching product by id: $id", e)
            throw e // Propagate the error after logging
        }
    }

    suspend fun getAllCartItemsWithDetails(header: String): List<cartItemUI> {
        val cartItems = getAllCartItems(header)
        val list = mutableListOf<cartItemUI>()

        for (cartItem in cartItems) {
            try {
                val product = getItemById(cartItem.productId)
                list.add(
                    cartItemUI(
                        productId = cartItem.productId,
                        name = product.productName,
                        quantity = cartItem.quantity,
                        price = product.price,
                        unit = product.unit,
                        stock = product.stock,
                        image = product.image
                    )
                )
            } catch (e: Exception) {
                // Handle error if a product can't be fetched
                Log.e("CartRepository", "Error fetching product for cart item: ${cartItem.productId}", e)
            }
        }
        return list
    }
}
