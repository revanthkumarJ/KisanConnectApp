package com.example.kisanconnect.features.Screens.Product.data.repository

import android.util.Log
import com.example.kisanconnect.features.Screens.Product.data.model.Product
import com.example.kisanconnect.features.Screens.Product.data.remote.CartItemRequest
import com.example.kisanconnect.features.Screens.Product.data.remote.ProductApiService
import javax.inject.Inject
import java.io.IOException

class ProductRepository @Inject constructor(private val apiService: ProductApiService) {

    suspend fun getProductById(productId: String): Result<Product> {
        return try {
            val response = apiService.getProductById(productId)
            Result.success(response.item)
        } catch (e: IOException) {
            // Handle network issues, like no internet connection
            Result.failure(e)
        } catch (e: Exception) {
            // Handle any other exceptions
            Result.failure(e)
        }
    }

    suspend fun addToCart(cartItem: CartItemRequest,header:String):Boolean{
        return try {
//            Log.i("Revanth",cartItem.toString())
            val response=apiService.addToCart(header,cartItem)
//            Log.i("Revanth",response.toString())
            if(response.isSuccessful){
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
