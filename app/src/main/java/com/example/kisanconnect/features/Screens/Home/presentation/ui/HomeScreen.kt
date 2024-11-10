package com.example.kisanconnect.features.Screens.Home.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.kisanconnect.core.ui.ProgressIndicator
import com.example.kisanconnect.features.Screens.Home.presentation.viewmodel.HomeViewModel

@Composable
fun HomeScreen(homeViewModel: HomeViewModel = hiltViewModel()) {
    val carousels by homeViewModel.carousels
    val fruits by homeViewModel.fruits
    val vegetables by homeViewModel.vegetables
    val grains by homeViewModel.grains
    val dairy by homeViewModel.dairy
    val others by homeViewModel.others
    val loadingState by homeViewModel.isLoading

    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
    ) {
        // Carousel Row
        if (loadingState.isCarouselsLoading) {
            ProgressIndicator()
        } else {
            CarouselRow(list = carousels)
        }

        // Fruits Row
        if (loadingState.isFruitsLoading) {
            ProgressIndicator()
        } else {
            HomeScreenProductRow("Fruits", list = fruits)
        }

        // Vegetables Row
        if (loadingState.isVegetablesLoading) {
            ProgressIndicator()
        } else {
            HomeScreenProductRow("Vegetables", list = vegetables)
        }

        // Grains Row
        if (loadingState.isGrainsLoading) {
            ProgressIndicator()
        } else {
            HomeScreenProductRow("Grains", list = grains)
        }

        // Dairy Row
        if (loadingState.isDairyLoading) {
            ProgressIndicator()
        } else {
            HomeScreenProductRow("Dairy", list = dairy)
        }

        // Others Row
        if (loadingState.isOthersLoading) {
            ProgressIndicator()
        } else {
            HomeScreenProductRow("Others", list = others)
        }
    }
}
