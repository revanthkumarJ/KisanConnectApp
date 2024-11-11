package com.example.kisanconnect.features.Screens.Cart.presentation.viewmodel

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
        return "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjY2ZGVkYWMxYjFhMGNjNzJkYTlmMTc0NiIsImVtYWlsIjoicmFtZXNoQGdtYWlsLmNvbSIsIm5hbWUiOiJSZXZhbnRoIFJLIiwiaXNBZG1pbiI6dHJ1ZSwiaXNGYXJtZXIiOnRydWUsImlzRGVsaXZlcnlCb3kiOnRydWUsImlhdCI6MTczMDYxMTIzOH0.bR2eDWze6sTQHKIyOtBLhyOA-XUQQSKml__z3pUc2PE"
    }
}
