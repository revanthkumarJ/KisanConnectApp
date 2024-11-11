package com.example.kisanconnect.features.Screens.Product.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kisanconnect.features.Screens.Product.data.model.Product
import com.example.kisanconnect.features.Screens.Product.data.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject




@HiltViewModel
class ProductViewModel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {

    var productId = mutableStateOf("")
        private set
    var ProductByIdIsLoading = mutableStateOf(false)
        private set
    var errorMessage = mutableStateOf<String?>(null)
        private set
    var product = mutableStateOf<Product?>(null)
        private set

    // Function to fetch product by id
    fun getProductById() {
        ProductByIdIsLoading.value = true
        viewModelScope.launch {
            val response = productRepository.getProductById(productId.value)

            response.fold(
                onFailure = {
                    errorMessage.value = "Failed to load Product: ${it.message}"
                },
                onSuccess = {
                    product.value = it
                }
            )
            ProductByIdIsLoading.value = false
        }
    }
}

