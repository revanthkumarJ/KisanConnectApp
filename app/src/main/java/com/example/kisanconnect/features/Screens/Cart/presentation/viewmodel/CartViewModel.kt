package com.example.kisanconnect.features.Screens.Cart.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kisanconnect.features.Screens.Cart.data.model.cartItemUI
import com.example.kisanconnect.features.Screens.Cart.data.repository.CartRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val cartRepository: CartRepository
) : ViewModel() {

    var cartItems = mutableStateOf<List<cartItemUI>>(emptyList())
    var isLoading = mutableStateOf(false)
    var errorMessage = mutableStateOf<String?>(null)
    var deleteResult= mutableStateOf<Boolean?>(null)

    init {
        getAllcartItems()
    }

    fun getAllcartItems() {
        viewModelScope.launch {
            isLoading.value = true
            try {
                // Assuming the header would be retrieved dynamically from user session or preferences
                val response = cartRepository.getAllCartItemsWithDetails(header = getAuthHeader())
                cartItems.value = response
                isLoading.value = false
            } catch (e: Exception) {
                errorMessage.value = "Failed to load cart items"
                isLoading.value = false
            }
        }
    }

    private fun getAuthHeader(): String {
        // Replace with logic to retrieve token dynamically
        return "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjY3MDdjNjM0OGZkMGZiYWFmMDc3NDcwZiIsImVtYWlsIjoicmFtZXNoMUBnbWFpbC5jb20iLCJuYW1lIjoiUmFtZXNoIiwiaXNBZG1pbiI6ZmFsc2UsImlzRmFybWVyIjp0cnVlLCJpc0RlbGl2ZXJ5Qm95IjpmYWxzZSwiaWF0IjoxNzMxNDEzODAyfQ.OeNA3pkfD5sef-Oq1phdE1oxqviwNRujIQjJXFvjs60"
    }

    fun OnDelete(id: String) {

        viewModelScope.launch {
            try {
                // Attempt to delete the cart item
                val isDeleted = cartRepository.deleteCartItem(id,getAuthHeader())

                // If deletion is successful, update the cartItems list
                if (isDeleted) {
                    deleteResult.value=true
                    cartItems.value = cartItems.value.filter { it.productId != id }
                } else {

                    deleteResult.value=false

                }
            } catch (e: Exception) {
                Log.e("Revanth", e.toString())

                deleteResult.value=false

            }
        }

    }
}
