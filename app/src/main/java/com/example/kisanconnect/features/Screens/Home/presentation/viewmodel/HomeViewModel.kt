package com.example.kisanconnect.features.Screens.Home.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kisanconnect.features.Screens.Home.data.model.CarouselItemUI
import com.example.kisanconnect.features.Screens.Home.data.repository.CarouselRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val carouselRepository: CarouselRepository
) : ViewModel() {

    // State for storing carousels
    var carousels = mutableStateOf<List<CarouselItemUI>>(emptyList())
        private set

    init {
        getAllCarousels()
    }
    // Function to fetch data
    private fun getAllCarousels() {
        viewModelScope.launch {
            try {
                val result = carouselRepository.getAllCarousels()
                carousels.value = result
            } catch (exception: Exception) {
                carousels.value = emptyList()
            }
        }
    }
}
