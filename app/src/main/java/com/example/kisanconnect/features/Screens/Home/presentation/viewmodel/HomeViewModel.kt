package com.example.kisanconnect.features.Screens.Home.presentation.viewmodel

import androidx.compose.runtime.MutableState
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

    init {
        getAllCarousels()
        getAllProductRows()
    }

    // Function to fetch data
    private fun getAllCarousels() {
        viewModelScope.launch {
            try {
                isLoading.value = isLoading.value.copy(isCarouselsLoading = true)
                val result = carouselRepository.getAllCarousels()
                carousels.value = result
            } catch (exception: Exception) {
                carousels.value = emptyList()
            } finally {
                isLoading.value = isLoading.value.copy(isCarouselsLoading = false)
            }
        }
    }


    private fun getAllProductRows() {
        viewModelScope.launch {
            try {
                isLoading.value = isLoading.value.copy(isFruitsLoading = true, isVegetablesLoading = true, isDairyLoading = true, isGrainsLoading = true, isOthersLoading = true)

                val fruitResult = carouselRepository.getAllFruits()
                fruits.value = fruitResult
                isLoading.value = isLoading.value.copy(
                    isFruitsLoading = false,
                )

                val vegetablesResult = carouselRepository.getAllVegetables()
                vegetables.value = vegetablesResult
                isLoading.value = isLoading.value.copy(
                    isVegetablesLoading = false,
                )


                val dairyResult = carouselRepository.getAllDairy()
                dairy.value = dairyResult
                isLoading.value = isLoading.value.copy(
                    isDairyLoading = false,
                )

                val grainsResult = carouselRepository.getAllGrains()
                grains.value = grainsResult
                isLoading.value = isLoading.value.copy(
                    isGrainsLoading = false,
                )

                val othersResult = carouselRepository.getAllOther()
                others.value = othersResult
                isLoading.value = isLoading.value.copy(
                    isOthersLoading = false
                )
            } catch (exception: Exception) {
                // handle error
            } finally {
                isLoading.value = isLoading.value.copy(
                    isFruitsLoading = false,
                    isVegetablesLoading = false,
                    isDairyLoading = false,
                    isGrainsLoading = false,
                    isOthersLoading = false
                )
            }
        }
    }
}



data class LoadingState(
    val isCarouselsLoading: Boolean = false,
    val isFruitsLoading: Boolean = false,
    val isVegetablesLoading: Boolean = false,
    val isDairyLoading: Boolean = false,
    val isGrainsLoading: Boolean = false,
    val isOthersLoading: Boolean = false
)
