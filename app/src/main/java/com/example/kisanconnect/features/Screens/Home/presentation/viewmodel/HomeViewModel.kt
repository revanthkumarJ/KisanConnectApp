package com.example.kisanconnect.features.Screens.Home.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kisanconnect.features.Screens.Home.data.model.CarouselItemUI
import com.example.kisanconnect.features.Screens.Home.data.model.HomeScreenProductCardItemUI
import com.example.kisanconnect.features.Screens.Home.data.repository.CarouselRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val carouselRepository: CarouselRepository
) : ViewModel() {

    var carousels = mutableStateOf<List<CarouselItemUI>>(emptyList())
        private set

    var fruits = mutableStateOf<List<HomeScreenProductCardItemUI>>(emptyList())
        private set

    var vegetables = mutableStateOf<List<HomeScreenProductCardItemUI>>(emptyList())
        private set

    var dairy = mutableStateOf<List<HomeScreenProductCardItemUI>>(emptyList())
        private set

    var grains = mutableStateOf<List<HomeScreenProductCardItemUI>>(emptyList())
        private set

    var others = mutableStateOf<List<HomeScreenProductCardItemUI>>(emptyList())
        private set

    var isLoading = mutableStateOf(LoadingState())
        private set

    var errorMessage = mutableStateOf<String?>(null)
        private set

    init {
        getAllCarousels()
        getAllProductRows()
    }

    fun clearErrorMessage(){
        errorMessage.value=null
    }

    // Function to fetch carousels with Result handling
    private fun getAllCarousels() {
        viewModelScope.launch {
            isLoading.value = isLoading.value.copy(isCarouselsLoading = true)
            errorMessage.value = null

            val result = carouselRepository.getAllCarousels()
            result.fold(
                onSuccess = { carousels.value = it },
                onFailure = { errorMessage.value = "Failed to load carousels: ${it.message}" }
            )

            isLoading.value = isLoading.value.copy(isCarouselsLoading = false)
        }
    }

    // Function to fetch all product rows with Result handling
    private fun getAllProductRows() {
        viewModelScope.launch {
            isLoading.value = isLoading.value.copy(
                isFruitsLoading = true, isVegetablesLoading = true,
                isDairyLoading = true, isGrainsLoading = true, isOthersLoading = true
            )
            errorMessage.value = null

            // Fruits
            val fruitResult = carouselRepository.getAllFruits()
            fruitResult.fold(
                onSuccess = { fruits.value = it },
                onFailure = { errorMessage.value = "Failed to load fruits: ${it.message}" }
            )
            isLoading.value = isLoading.value.copy(isFruitsLoading = false)

            // Vegetables
            val vegetableResult = carouselRepository.getAllVegetables()
            vegetableResult.fold(
                onSuccess = { vegetables.value = it },
                onFailure = { errorMessage.value = "Failed to load vegetables: ${it.message}" }
            )
            isLoading.value = isLoading.value.copy(isVegetablesLoading = false)

            // Dairy
            val dairyResult = carouselRepository.getAllDairy()
            dairyResult.fold(
                onSuccess = { dairy.value = it },
                onFailure = { errorMessage.value = "Failed to load dairy products: ${it.message}" }
            )
            isLoading.value = isLoading.value.copy(isDairyLoading = false)

            // Grains
            val grainsResult = carouselRepository.getAllGrains()
            grainsResult.fold(
                onSuccess = { grains.value = it },
                onFailure = { errorMessage.value = "Failed to load grains: ${it.message}" }
            )
            isLoading.value = isLoading.value.copy(isGrainsLoading = false)

            // Other products
            val othersResult = carouselRepository.getAllOther()
            othersResult.fold(
                onSuccess = { others.value = it },
                onFailure = { errorMessage.value = "Failed to load other products: ${it.message}" }
            )
            isLoading.value = isLoading.value.copy(isOthersLoading = false)
        }
    }
}

// Data class for loading states
data class LoadingState(
    val isCarouselsLoading: Boolean = false,
    val isFruitsLoading: Boolean = false,
    val isVegetablesLoading: Boolean = false,
    val isDairyLoading: Boolean = false,
    val isGrainsLoading: Boolean = false,
    val isOthersLoading: Boolean = false
)
