package com.example.kisanconnect.features.Screens.BuyNow.data.repository

import android.util.Log
import com.example.kisanconnect.features.Screens.BuyNow.data.model.BuyNowItem
import com.example.kisanconnect.features.Screens.BuyNow.data.remote.BuyNowApiService
import com.example.kisanconnect.features.Screens.Product.data.remote.CartItemRequest
import java.io.IOException
import javax.inject.Inject

class BuyNowRepository @Inject constructor(
    private val apiService: BuyNowApiService
)
{
    suspend fun getProductById(id:String):BuyNowItem
    {
        return try {
            val response=apiService.getProductById(id).item
            BuyNowItem(productName = response.productName, price = response.price, unit = response.unit, stock = response.stock, image = response.image, deliveryTime = response.deliveryTime)
        } catch (e: Exception) {
            Log.e("Buy Now Repository", "Error fetching product by id: $id", e)
            throw e
        }
    }

    suspend fun addToCart(cartItem: CartItemRequest, header:String):Boolean{
        return try {
//            Log.i("Revanth",cartItem.toString())
            val response=apiService.postProduct(header,cartItem)
//            Log.i("Revanth",response.toString())
            if(response.isSuccess){
                true
            }
            else{
                false
            }

        }catch (e: IOException) {
            // Handle network issues, like no internet connection
//            Result.failure(e)
            false
        } catch (e: Exception) {
            // Handle any other exceptions
//            Result.failure(e)
            false
        }
    }

}