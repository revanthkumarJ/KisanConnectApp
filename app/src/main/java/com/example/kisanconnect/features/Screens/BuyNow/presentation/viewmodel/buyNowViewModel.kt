package com.example.kisanconnect.features.Screens.BuyNow.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kisanconnect.features.Screens.BuyNow.data.model.BuyNowItem
import com.example.kisanconnect.features.Screens.BuyNow.data.repository.BuyNowRepository
import com.example.kisanconnect.features.Screens.Product.data.remote.CartItemRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BuyNowViewModel @Inject constructor(
    private val repository: BuyNowRepository
) : ViewModel() {

    var product = mutableStateOf<BuyNowItem?>(null)
        private set
    var isLoading = mutableStateOf(true) // Initialize to true for loading
    var buyResult= mutableStateOf<Boolean?>(null)

    fun getItem(id: String) {
        isLoading.value = true
        viewModelScope.launch {
            val response = repository.getProductById(id)
            product.value = response
            isLoading.value = false // Set to false after loading is complete
        }
    }

    private fun getAuthHeader(): String {
        // Replace with logic to retrieve token dynamically
        return "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjY3MDdjNjM0OGZkMGZiYWFmMDc3NDcwZiIsImVtYWlsIjoicmFtZXNoMUBnbWFpbC5jb20iLCJuYW1lIjoiUmFtZXNoIiwiaXNBZG1pbiI6ZmFsc2UsImlzRmFybWVyIjp0cnVlLCJpc0RlbGl2ZXJ5Qm95IjpmYWxzZSwiaWF0IjoxNzMxNDEzODAyfQ.OeNA3pkfD5sef-Oq1phdE1oxqviwNRujIQjJXFvjs60"
    }

    fun postItem(productId:String,quantity:Int)
    {
        viewModelScope.launch {
            val response = repository.addToCart(CartItemRequest(productId,quantity), getAuthHeader())
            buyResult.value=response
        }

    }
}
